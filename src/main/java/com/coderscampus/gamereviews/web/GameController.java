package com.coderscampus.gamereviews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.gamereviews.domain.Game;
import com.coderscampus.gamereviews.domain.User;
import com.coderscampus.gamereviews.service.GameService;
import com.coderscampus.gamereviews.service.UserService;

@Controller
public class GameController {
	@Autowired
	private GameService gameService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/createGame")
	public String newGame(Game game, ModelMap model) {
		model.put("game", game);
		return "game";
	}
	
	@PostMapping("/createGame")
	public String newGame(Game game) {
		gameService.newGame(game);
		return "game";
	}
}

