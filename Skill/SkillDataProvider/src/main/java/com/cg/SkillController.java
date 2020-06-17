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
public class SkillController {
	@Autowired
	SkillRepository skillrepo;
	private static final Logger logger = LoggerFactory.getLogger(Skill.class);
	
	@GetMapping("/skill")
	@HystrixCommand(fallbackMethod = "defaultSkillList")
	public List<Skill> getAllSkill(){
		return skillrepo.findAll();
	}
	
	public List<Skill> defaultSkillList() {
		return new ArrayList<Skill>();
	}
	
	@GetMapping("/skill/{skillId}")
	@HystrixCommand(fallbackMethod = "defaultSkill")
	public Skill getSkill(@PathVariable long skillId){
		return skillrepo.findById(skillId).get();
	}
	
	public Skill defaultSkill(long id) {
		return new Skill();
	}
	
	@PostMapping("/addskill")
	public Skill addSkill(@RequestBody Skill skill){
		return skillrepo.save(skill);
	}
	
	@PutMapping("/updateskill/{skillId}")
	public Skill updateSkill(@RequestBody Skill skill,@PathVariable long skillId) {
		skillrepo.delete(skillrepo.findById(skillId).get());
		return skillrepo.save(skill);
	}
}
