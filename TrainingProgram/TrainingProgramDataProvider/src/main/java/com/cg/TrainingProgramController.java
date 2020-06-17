package com.cg;

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
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class TrainingProgramController {
	@Autowired
	TrainingProgramRepository trainprogramrepo;
	private static final Logger logger = LoggerFactory.getLogger(TrainingProgram.class);
	@GetMapping("/trainingprogram")
	public List<TrainingProgram> getAllTrainingProgram(){
		return trainprogramrepo.findAll();
	}
	
	@GetMapping("/trainingprogram/{trainingProgramId}")
	@HystrixCommand(fallbackMethod = "defaultProgram")
	public TrainingProgram getTrainingProgram(@PathVariable long trainingProgramId){
		return trainprogramrepo.findById(trainingProgramId).get();
	}
	
	public TrainingProgram defaultProgram(long id) {
		return new TrainingProgram();
	}
	
	@PostMapping(path="/addtrainingprogram")
	public TrainingProgram addTrainingProgram(@RequestBody TrainingProgram trainingprog) {
		/*Course tmpCourse=courserepo.findById(courseId).get();
		trainingprog.setCourse(tmpCourse);
		Employee tmptrainer=employeerepo.findById(empId).get();
		trainingprog.setTrainer(tmptrainer);//.setParticipant(tmptrainer);*/
		return trainprogramrepo.save(trainingprog);
	}
	
	@PutMapping("/updatetrainingprogram")
	public TrainingProgram updateTrainingProgram(@RequestBody TrainingProgram trainingprog) {
		return trainprogramrepo.save(trainingprog);
	}
}
