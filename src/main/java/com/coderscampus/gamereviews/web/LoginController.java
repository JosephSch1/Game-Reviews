package com.coderscampus.gamereviews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.gamereviews.domain.User;
import com.coderscampus.gamereviews.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getLogin() {
		
		return "login";
	}
	
	
	@GetMapping("/register")
	public String getRegister(ModelMap model) {
		model.put("user", new User());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String createUser(User user) {
		userService.CreateUser(user);
		
		System.out.println(user.getUserName());
		return "redirect:/login";
	}
}
