package com.moon.web;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.admin.domain.MoonImage;
import com.moon.admin.domain.MoonProject;
import com.moon.admin.repository.MoonProjectRepository;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private MoonProjectRepository moonProjectsRepository;

	@GetMapping("")
	public String projects(Model model) {
		model.addAttribute("moonprojects", moonProjectsRepository.findAll());
		return "admin/projects";
	}

	@GetMapping("/{id}")
	public String showImages(@PathVariable Long id, Model model) {
		MoonProject moonProject = moonProjectsRepository.findById(id).get();
		List<MoonImage> moonImages = moonProject.getMoonImages();
		
		Map<Long, ArrayList<Object>> iamgesMap = new HashMap<>();
		Base64.Encoder encoder = Base64.getEncoder();
		
		for (int i = 0; i < moonImages.size(); i++) {
			MoonImage moonimage = moonImages.get(i);
			Long imageId = moonimage.getId();
			
			List<Object> imageData = new ArrayList<Object>();
			imageData.add(moonimage.getImageName());
			imageData.add(moonimage.getImageGroup());
			imageData.add("data:image/png;base64," + encoder.encodeToString(moonimage.getImage()));
			iamgesMap.put(imageId, (ArrayList<Object>) imageData);
		}

		model.addAttribute("moonproject", moonProject);
		model.addAttribute("moonimages", iamgesMap);
		return "admin/images";
	}
}