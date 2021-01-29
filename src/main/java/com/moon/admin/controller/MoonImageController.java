package com.moon.admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.moon.admin.domain.MoonImage;
import com.moon.admin.repository.MoonImageRepository;
import com.moon.admin.repository.MoonProjectRepository;

@Controller
@RequestMapping("moonimage")
public class MoonImageController {
	@Autowired
	private MoonImageRepository moonImageRepository;
	@Autowired
	private MoonProjectRepository moonProjectRepository;

	@PutMapping("")
	public String create(@RequestParam("moonProjectId") Long moonProjectId, @RequestParam("image") MultipartFile image,
			@RequestParam("imageName") String imageName, HttpServletRequest request) {
		try {
			MoonImage newMoonImage = new MoonImage();
			newMoonImage.setMoonProjects(moonProjectRepository.findById(moonProjectId).get());
			newMoonImage.setImage(image.getBytes());
			newMoonImage.setImageName(imageName);
			moonImageRepository.save(newMoonImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
}
