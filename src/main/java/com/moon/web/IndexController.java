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
	
	@GetMapping("mainprojects/{name}")
	public String mainprojects(@PathVariable String name) {
		return "archi/mainprojects/" + name;
	}
}