package com.cg;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CourseController {
	@Autowired
	CourseRepository courserepo;
	private static final Logger logger = LoggerFactory.getLogger(Course.class);

	
	//Skill skill;
	
	@GetMapping("/course")
	@HystrixCommand(fallbackMethod = "defaultCourseList")
	public List<Course> getAllCourse(){
		return courserepo.findAll();
	}
	
	public List<Course> defaultCourseList(){
		return new ArrayList<Course>();
	}
	
	@GetMapping("/course/{courseId}")
	@HystrixCommand(fallbackMethod = "defaultCourse")
	public Course getCourse(@PathVariable long courseId){
		Course tmpCourse=courserepo.findById(courseId).get();
		if(null==tmpCourse)return null;
		else return tmpCourse;
	}
	
	public Course defaultCourse(long id) {
		return new Course();
	}
	
	@PostMapping(path="/addcourse")
	public Course addCourse(@RequestBody Course course) {
		/*Skill tmpSkill = skillrepo.findById(skillId).get();
		course.setSkill(tmpSkill);*/
		
		return courserepo.save(course);
	}
	
	/*@PostMapping(path="/addcourse/{skillId}")
	public Course addCourse(@RequestBody Course course,@RequestBody Skill skill,@PathVariable long skillId) {
		/*Skill tmpSkill = skillrepo.findById(skillId).get();
		course.setSkill(tmpSkill);
		return courserepo.save(course);
	}*/
	
	@PutMapping("/updatecourse")
	public Course updateCourse(@RequestBody Course course) {
		return courserepo.save(course);
	}
}
