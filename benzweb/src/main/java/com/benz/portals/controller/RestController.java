package com.benz.portals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/rest")
public class RestController {
	
	@RequestMapping("/index")
	public String index(Model model,Integer type) {
		model.addAttribute("type", type);
		return "rest/index";
	}
	
	@RequestMapping(value="/fileupload")
	public String fileupload(Model model,Integer type) {
		model.addAttribute("type", type);
		return "rest/fileupload";
	}
}
