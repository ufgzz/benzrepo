package com.signhor.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@RequestMapping("/home")
	public String home(Model model) {
		return "common/home";
	}

}
