package com.moon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
	@GetMapping("")
	public String index() {
		return "index";
	}
	
	@GetMapping("archi/{type}/{name}")
	public String archiprojects(@PathVariable String type, @PathVariable String name) {
		return "/archi/" + type + "/" + name;
	}
	
}
