package com.moon.web;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moon.admin.domain.MoonImage;
import com.moon.admin.domain.MoonProject;
import com.moon.admin.repository.MoonProjectRepository;

@Controller
public class ArchiController {
	@Autowired
	private MoonProjectRepository moonProjectsRepository;
	
	@GetMapping("archi/{type}/{name}/{id}")
	public String archiprojects(@PathVariable String type, @PathVariable String name, @PathVariable Long id, Model model) {

		MoonProject moonProject = moonProjectsRepository.findById(id).get();
		if (moonProject != null) {
			model.addAttribute("accessmessage", "success to access");
			model.addAttribute("moonprojectIs", true);
			
			List<MoonImage> moonImages = moonProject.getMoonImages();
			Map<String, String> iamges = new HashMap<>();
			for (int i = 0; i < moonImages.size(); i++) {
				Base64.Encoder encoder = Base64.getEncoder();
				String imageName = moonImages.get(i).getImageName();
				String encoding = "data:image/png;base64," + encoder.encodeToString(moonImages.get(i).getImage());
				iamges.put(imageName, encoding);
			}
			model.addAttribute("moonproject", moonProject);
			model.addAttribute("moonimages", iamges);
		} else {
			model.addAttribute("accessmessage", "fail to access");
			model.addAttribute("moonprojectIs", false);
		}
		
		return "archi/" + type + "/" + name;
	}
}
