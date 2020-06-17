package com.cg;

import java.util.List;
import java.util.Optional;

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
public class ParticipantEnrollmentController {
	
	@Autowired
	ParticipantEnrollmentRepository enrollmentrepo;
	private static final Logger logger = LoggerFactory.getLogger(ParticipantEnrollment.class);
	@GetMapping("/enrollment")
	public List<ParticipantEnrollment> getAllParticipantEnrollment(){
		return enrollmentrepo.findAll();
	}
	
	@GetMapping("/enrollment/{trainingId}")
	@HystrixCommand(fallbackMethod = "defaultEnrollment")
	public ParticipantEnrollment getParticipantEnrollment(@PathVariable long trainingId){
		return enrollmentrepo.findById(trainingId).get();
	}
	
	public ParticipantEnrollment defaultEnrollment(long id) {
		return new ParticipantEnrollment();
	}
	
	@PostMapping(path="/addenrollment")
	public ParticipantEnrollment addParticipantEnrollment(@RequestBody ParticipantEnrollment enrollment) {
		return enrollmentrepo.save(enrollment);
	}
	
	@PutMapping("/updateenrollment")
	public ParticipantEnrollment updateParticipantEnrollment(@RequestBody ParticipantEnrollment enrollment) {
	
		return enrollmentrepo.save(enrollment);
	}
}
