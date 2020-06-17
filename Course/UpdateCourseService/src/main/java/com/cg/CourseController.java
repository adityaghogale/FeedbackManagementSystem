package com.cg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "false")
@RestController
public class CourseController {
	@Autowired
	CourseRepository proxy;
	
	@Autowired
	SkillRepository skillproxy;
	private static final Logger logger = LoggerFactory.getLogger(Course.class);
	
	
	@PostMapping(path="/addcourse")
	public Course addCourse(@RequestBody Course course) {		
		//course.setSkill(tmpskill);
		Course tmpCourse=proxy.addCourse(course);
		if(null==tmpCourse)return null;
		else return tmpCourse;
	}
	
	
	@PutMapping("/updatecourse")
	public Course updateCourse(@RequestBody Course course) {
		Course tmpCourse=proxy.updateCourse(course);
		if(null==tmpCourse)return null;
		else return tmpCourse;
	}
}
