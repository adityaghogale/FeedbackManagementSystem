package com.cg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= {"http://localhost:4200"},allowCredentials = "true")
@RestController
public class FeedbackController {
	@Autowired
	FeedbackRepository proxy;
	
	@Autowired
	EmployeeRepository empproxy;
	
	@Autowired
	TrainingProgramRepository trainingprogramproxy;
	private static final Logger logger = LoggerFactory.getLogger(Feedback.class);
	
	@PostMapping(path="/addfeedback")//{empId}/{trainingProgramId}")
	public Feedback addFeedback(@RequestBody Feedback feedback) {//,@PathVariable long empId,@PathVariable long trainingProgramId) {
		Feedback tmpFeedback=proxy.addFeedback(feedback);
		if(null==tmpFeedback) return null;
		else return tmpFeedback;
	}
	
	
}
