package com.cg;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Aditya Ghogale
 *
 */
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "false")
@RestController
public class GetController {
	
	

	@Autowired
	 private Getallrepository proxy;
	private static final Logger logger = LoggerFactory.getLogger( GetUser.class);
	
	
	/*@GetMapping("/login")
	public List<GetUser> retrieve(){
		List<GetUser> get= proxy.retrieve();
		return get;
	}*/
	
	@GetMapping(path = "/login/{userName}/{password}")
	public GetUser findByuserName(@PathVariable String userName,@PathVariable String password){
		GetUser tmpList =  proxy.findByuserNameAndPassword(userName,password);
		return tmpList;
	}

}
