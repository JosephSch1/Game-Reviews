package com.coderscampus.gamereviews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.gamereviews.domain.Post;
import com.coderscampus.gamereviews.domain.User;
import com.coderscampus.gamereviews.service.PostService;
import com.coderscampus.gamereviews.service.UserService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/post")
	public String getPost(ModelMap model, @PathVariable Long postId, @AuthenticationPrincipal User user) {
		model.put("post", postService.findById(postId));
		model.put("user", user);
		return "post";
	}
	
	@PostMapping("/post")
	public String createPost(@AuthenticationPrincipal User user, Post post) {
		postService.createPost(user, post);
		return "redirect:/dashboard";
	}
}
