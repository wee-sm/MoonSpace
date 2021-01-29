package com.moon.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.admin.domain.MoonProject;
import com.moon.admin.repository.MoonProjectRepository;

@Controller
@RequestMapping("moonproject")
public class MoonProjectController {
	@Autowired
	private MoonProjectRepository moonProjectRepository;
	
	@PostMapping("")
	public String create(MoonProject newMoonProject, HttpServletRequest request) {
		moonProjectRepository.save(newMoonProject);
		
	    String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
}