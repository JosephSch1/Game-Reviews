package com.coderscampus.gamereviews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.gamereviews.domain.Post;
import com.coderscampus.gamereviews.domain.User;
import com.coderscampus.gamereviews.service.PostService;

@Controller
public class DashboardController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/")
	public String dashboardRedirect() {
		return "redirect:/dasboard";
	}
	
	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal User user, ModelMap model) {
	model.put("user", user);
	model.put("post", new Post());
	model.put("allPosts", postService.findAll());
	return "dashboard";
	}
}
