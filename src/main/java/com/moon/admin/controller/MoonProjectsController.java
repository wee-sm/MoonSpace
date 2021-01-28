package com.moon.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.admin.domain.MoonProjects;
import com.moon.admin.repository.MoonProjectsRepository;

@Controller
@RequestMapping("moonproject")
public class MoonProjectsController {
	@Autowired
	private MoonProjectsRepository moonProjectsRepository;
	
	@PostMapping("")
	public String create(MoonProjects newMoonProject) {
		moonProjectsRepository.save(newMoonProject);
		return "redirect:/";
	}
}