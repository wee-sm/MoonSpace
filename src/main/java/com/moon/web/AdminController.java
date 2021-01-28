package com.moon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.admin.repository.MoonProjectsRepository;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private MoonProjectsRepository moonProjectsRepository;
	
	@GetMapping("")
	public String projects(Model model) {
		model.addAttribute("moonprojects", moonProjectsRepository.findAll());
		return "admin/main";
	}
}