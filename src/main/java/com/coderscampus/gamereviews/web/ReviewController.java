package com.coderscampus.gamereviews.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coderscampus.gamereviews.domain.Game;
import com.coderscampus.gamereviews.service.GameService;
import com.coderscampus.gamereviews.service.PostService;

@Controller
public class ReviewController {

	@Autowired
	PostService postService;
	@Autowired
	GameService gameService;

	@GetMapping("/review/{gameId}")
	public String review(ModelMap model, @PathVariable Long gameId) {
		Optional<Game> thisGame =  gameService.findById(gameId);
		
		model.put("post", thisGame.get().getPost());
		
		return "review";
	}

}
