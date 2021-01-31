package com.moon.admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String create(
			@RequestParam("moonProjectId") Long moonProjectId,
			@RequestParam("image") MultipartFile image,
			@RequestParam("imageName") String imageName,
			@RequestParam("imageGroup") int imageGroup,
			HttpServletRequest request) {
		try {
			MoonImage newMoonImage = new MoonImage();
			newMoonImage.setMoonProjects(moonProjectRepository.findById(moonProjectId).get());
			newMoonImage.setImage(image.getBytes());
			newMoonImage.setImageName(imageName);
			newMoonImage.setImageGroup(imageGroup);
			moonImageRepository.save(newMoonImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@DeleteMapping("/{moonimageId}")
	public String delete(@PathVariable Long moonimageId, HttpServletRequest request) {
		MoonImage targetImage = moonImageRepository.findById(moonimageId).get();
		moonImageRepository.delete(targetImage);
		
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
}
