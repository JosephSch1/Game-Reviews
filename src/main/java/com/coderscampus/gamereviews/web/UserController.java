package com.coderscampus.gamereviews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coderscampus.gamereviews.domain.User;
import com.coderscampus.gamereviews.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile/{userId}")
	public String getOtherProfile(ModelMap model, @AuthenticationPrincipal User user, @PathVariable Long userId) {
		User otherUser = userService.findByUserId(userId);
		model.put("posts", otherUser.getPosts());
		model.put("games", otherUser.getGames());
		model.put("user", user);
		model.put("otherUser", otherUser);
		
		return "profile";
	}
}
