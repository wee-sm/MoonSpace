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
		if (moonProjectsRepository != null) {
			model.addAttribute("moonprojects", moonProjectsRepository.findAll());
			model.addAttribute("moonprojectsIs", true);
		} else {
			model.addAttribute("moonprojectsIs", false);
		}
		return "admin/projects";
	}

	@GetMapping("/{id}")
	public String showProjectImages(@PathVariable Long id, Model model) {
		MoonProject moonProject = moonProjectsRepository.findById(id).get();
		if (moonProject != null) {
			model.addAttribute("accessmessage", "success to access");
			model.addAttribute("moonprojectIs", true);
			
			List<MoonImage> moonImages = moonProject.getMoonImages();
			Map<Long, List<String>> iamges = new HashMap<>();
			for (int i = 0; i < moonImages.size(); i++) {
				Base64.Encoder encoder = Base64.getEncoder();
				Long imageId = moonImages.get(i).getId();
				String imageName = moonImages.get(i).getImageName();
				String encoding = "data:image/png;base64," + encoder.encodeToString(moonImages.get(i).getImage());
				List<String> list=new ArrayList<String>();
				list.add(imageName);
				list.add(encoding);
				iamges.put(imageId, list);
			}
			model.addAttribute("moonproject", moonProject);
			model.addAttribute("moonimages", iamges);
		} else {
			model.addAttribute("accessmessage", "fail to access");
			model.addAttribute("moonprojectIs", false);
		}
		return "admin/projectControl";
	}
}