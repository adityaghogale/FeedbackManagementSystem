package com.cg;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SkillController {
	@Autowired
	SkillRepository proxy;
	private static final Logger logger = LoggerFactory.getLogger(Skill.class);
	
	@PostMapping("/addskill")
	public Skill addSkill(@RequestBody Skill skill) {
		return proxy.addSkill(skill);
	}
	
	@PostMapping("/updateskill/{skillId}")
	public Skill updateSkill(@RequestBody Skill skill,@PathVariable long skillId) {
		return proxy.updateSkill(skill, skillId);
	}
}
