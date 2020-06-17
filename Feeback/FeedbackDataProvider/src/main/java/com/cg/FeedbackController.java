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
public class FeedbackController {
	@Autowired
	FeedbackRepository feedbackrepo;
	private static final Logger logger = LoggerFactory.getLogger(Feedback.class);

	@GetMapping("/feedback")
	public List<Feedback> getAllFeedback() {
		return feedbackrepo.findAll();
	}

	@GetMapping("/feedback/{feedbackId}")
	@HystrixCommand(fallbackMethod = "defaultFeedback")
	public Optional<Feedback> getFeedback(@PathVariable long feedbackId) {
		return feedbackrepo.findById(feedbackId);
	}
	
	public Feedback defaultFeedback(long id) {
		return new Feedback();
	}
	@PostMapping(path = "/addfeedback") // {empId}/{trainingProgramId}")
	public Feedback addFeedback(@RequestBody Feedback feedback) {// ,@PathVariable long empId,@PathVariable long
																	// trainingProgramId) {
		/*
		 * Employee tmpparticipant=employeerepo.findById(empId).get();
		 * feedback.setParticipant(tmpparticipant); TrainingProgram
		 * tmptrainingprogram=trainprogramrepo.findById(trainingProgramId).get();
		 * feedback.setTrainingProgram(tmptrainingprogram);
		 */
		return feedbackrepo.save(feedback);
	}

}
