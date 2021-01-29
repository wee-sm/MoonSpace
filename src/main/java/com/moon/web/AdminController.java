package com.moon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.admin.repository.MoonProjectRepository;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private MoonProjectRepository moonProjectsRepository;
	
	@GetMapping("")
	public String projects(Model model) {
		if (moonProjectsRepository !=null) {
			model.addAttribute("moonprojects", moonProjectsRepository.findAll());
			model.addAttribute("moonprojectsIs", true);
		} else {
			model.addAttribute("moonprojectsIs", false);
		}
		return "admin/main";
	}
}