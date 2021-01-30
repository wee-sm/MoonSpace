package com.moon.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/{moonprojectId}")
	public String update(@PathVariable Long moonprojectId, MoonProject updatemoonproject, HttpServletRequest request) {
		MoonProject originmoonproject = moonProjectRepository.findById(moonprojectId).get();
		originmoonproject.update(updatemoonproject);
		moonProjectRepository.save(originmoonproject);
		
	    String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}

	@DeleteMapping("/{moonprojectId}")
	public String delete(@PathVariable Long moonprojectId, HttpServletRequest request) {
		MoonProject targetProject = moonProjectRepository.findById(moonprojectId).get();
		moonProjectRepository.delete(targetProject);
		
	    String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
}