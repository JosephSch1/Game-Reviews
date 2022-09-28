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
import com.coderscampus.gamereviews.service.GameService;
import com.coderscampus.gamereviews.service.PostService;
import com.coderscampus.gamereviews.service.UserService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	@Autowired
	private GameService gameService;
	
	@GetMapping("/post/{gameId}")
	public String createPost(Post post, ModelMap model, @PathVariable Long gameId) {
		model.put("post", post);
		model.put("game", gameService.findById(gameId));
		return "post";
	}
	
	@PostMapping("/post/{gameId}")
	public String createPost(Post post, @PathVariable Long gameId) {
		postService.createPost(post);
		return "redirect:/dashboard";
	}
	
	}

