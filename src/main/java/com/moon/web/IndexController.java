package com.moon.web;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.moon.admin.domain.MoonImage;
import com.moon.admin.repository.MoonImageRepository;

@Controller
public class IndexController {
	@Autowired
	private MoonImageRepository moonImageRepository;
	
	@GetMapping("")
	public String index(Model model) {
//		List<MoonImage> otherImages = moonImageRepository.findImagesByGroup(999);
//		Base64.Encoder encoder = Base64.getEncoder();
//		
//		for (int i = 0; i < otherImages.size(); i++) {
//			MoonImage moonimage = otherImages.get(i);
//			model.addAttribute(moonimage.getImageName(), "data:image/png;base64," + encoder.encodeToString(moonimage.getImage()));
//		}
		return "index";
	}
}
