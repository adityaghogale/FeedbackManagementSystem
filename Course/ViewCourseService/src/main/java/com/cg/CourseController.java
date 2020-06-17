package com.cg;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "false")
@RestController
public class CourseController {
	@Autowired
	CourseRepository proxy;
	
	private static final Logger logger = LoggerFactory.getLogger(Course.class);
	
	//@Autowired
	//Skill skill;
	
	@GetMapping("/course")
	public List<Course> getAllCourse(){
		return proxy.getAllCourse();
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable long courseId){
		Course tmpCourse=proxy.getCourse(courseId);
		if(null==tmpCourse)return null;
		else return tmpCourse;
	}
	
	}
