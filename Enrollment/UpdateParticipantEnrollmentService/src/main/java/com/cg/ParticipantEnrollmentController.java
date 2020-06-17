package com.cg;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"},allowCredentials = "true")
@RestController
public class ParticipantEnrollmentController {
	@Autowired
	ParticipantEnrollmentRepository  proxy;
	
	@Autowired
	EmployeeRepository empproxy;
	
	@Autowired
	TrainingProgramRepository trainprogproxy;
	private static final Logger logger = LoggerFactory.getLogger(ParticipantEnrollment.class);
	
	@PostMapping(path="/addenrollment")
	public ParticipantEnrollment addTrainingProgram(@RequestBody ParticipantEnrollment enrollment) {
		TrainingProgram tmptrainprog = trainprogproxy.getTrainingProgram(enrollment.getTrainingId());
		if(tmptrainprog!=null) {
			return proxy.addParticipantEnrollment(enrollment);
		}
		return null;
	}
	
	@PutMapping("/updateenrollment")
	public ParticipantEnrollment updateParticipantEnrollment(@RequestBody ParticipantEnrollment enrollment) {
		ParticipantEnrollment tmpEnroll=proxy.updateParticipantEnrollment(enrollment);
		if(null==tmpEnroll) return null;
		else return tmpEnroll;
	}
}
