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
@RequestMapping("archi")
public class ArchiController {
	@Autowired
	private MoonProjectRepository moonProjectsRepository;

	@GetMapping("/{type}/{name}/{id}")
	public String archiprojects(
			@PathVariable String type,
			@PathVariable String name,
			@PathVariable Long id,
			Model model) {

		MoonProject moonProject = moonProjectsRepository.findById(id).get();
		List<MoonImage> moonImages = moonProject.getMoonImages();
		
		Map<String, String> iamgesMap = new HashMap<>();
		Map<Long, ArrayList<Object>> otherIamgesMap = new HashMap<>();
		
		Base64.Encoder encoder = Base64.getEncoder();
		
		for (int i = 0; i < moonImages.size(); i++) {
			MoonImage moonimage = moonImages.get(i);
			Long imageId = moonimage.getId();
			
			if(moonimage.getImageGroup() == 0) {
				iamgesMap.put(moonimage.getImageName(), "data:image/png;base64," + encoder.encodeToString(moonimage.getImage()));
			} else {
				List<Object> imageData = new ArrayList<Object>();
				imageData.add(moonimage.getImageName());
				imageData.add("data:image/png;base64," + encoder.encodeToString(moonimage.getImage()));
				
				otherIamgesMap.put(imageId, (ArrayList<Object>) imageData);
			}
		}
		model.addAttribute("moonproject", moonProject);
		model.addAttribute("moonimages", iamgesMap);
		model.addAttribute("moonotherimages", otherIamgesMap);

		return "archi/" + type + "/" + name;
	}
	
	@GetMapping("/modal/{name}/{id}")
	public String otherProjects(
			Model model,
			@PathVariable String name,
			@PathVariable Long id) {
		
		MoonProject modalProject = moonProjectsRepository.findById(id).get();
		List<MoonImage> modalImages = modalProject.getMoonImages();
		
		Base64.Encoder encoder = Base64.getEncoder();
		
		for (int i = 0; i < modalImages.size(); i++) {
			MoonImage moonimage = modalImages.get(i);
			model.addAttribute(moonimage.getImageName(), "data:image/png;base64," + encoder.encodeToString(moonimage.getImage()));
		}
		
		return "archi/otherproject_modal/" + name;
	}
	
	@GetMapping("/modal/loading")
	public String otherLoading() {
		return "archi/otherproject_modal/999_loading";
	}
}
