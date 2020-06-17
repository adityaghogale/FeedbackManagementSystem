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

@CrossOrigin(origins= {"http://localhost:4200"},allowCredentials = "false")
@RestController
public class TrainingProgramController {
	@Autowired
	TrainingProgramRepository proxy;
	private static final Logger logger = LoggerFactory.getLogger(TrainingProgram.class);
	
	/*@Autowired
	CourseRepository courseproxy;
	
	@Autowired
	EmployeeRepository employeeproxy;*/
	
	@GetMapping("/trainingprogram")
	public List<TrainingProgram> getAllTrainingProgram(){
		return proxy.getAllTrainingProgram();
	}
	
	@GetMapping("/trainingprogram/{trainingProgramId}")
	public TrainingProgram getTrainingProgram(@PathVariable long trainingProgramId){
		return proxy.getTrainingProgram(trainingProgramId);
	}
	
}
