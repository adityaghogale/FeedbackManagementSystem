package com.cg;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"},allowCredentials = "true")
@RestController
public class FacultySkillController {
	
	@Autowired
	FacultySkillRepository proxy;
	private static final Logger logger = LoggerFactory.getLogger(FacultySkill.class);
	
	@PostMapping(path="/addfacultyskill")
	public FacultySkill addFacultySkill(@RequestBody FacultySkill facultyskill){
		FacultySkill tmpSkill=proxy.addFacultySkill(facultyskill);
		if(null==tmpSkill) return null;
		else return tmpSkill;
	}
	
	@PutMapping("/updatefacultyskill")
	public FacultySkill updateFacultySkill(@RequestBody FacultySkill facultyskill){
		FacultySkill tmpSkill=proxy.updateFacultySkill(facultyskill);
		if(null==tmpSkill) return null;
		else return tmpSkill;
	}
}
