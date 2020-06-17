package com.cg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= {"http://localhost:4200"},allowCredentials = "true")
@RestController
public class TrainingProgramController {
	@Autowired
	TrainingProgramRepository proxy;
	private static final Logger logger = LoggerFactory.getLogger(TrainingProgram.class);
	
	@PostMapping(path="/addtrainingprogram")
	public TrainingProgram addTrainingProgram(@RequestBody TrainingProgram trainingprog) {
		TrainingProgram tmpProgram=proxy.addTrainingProgram(trainingprog);
		if(null==tmpProgram) return null;
		else return tmpProgram;
	}
	
	@PutMapping("/updatetrainingprogram")
	public TrainingProgram updateTrainingProgram(@RequestBody TrainingProgram trainingprog) {
		TrainingProgram tmpProgram=proxy.updateTrainingProgram(trainingprog);
		if(null==tmpProgram) return null;
		else return tmpProgram;
	}
}
