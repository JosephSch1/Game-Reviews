package com.coderscampus.gamereviews.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.gamereviews.domain.Game;
import com.coderscampus.gamereviews.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	UserService userService;
	
	
	public void newGame(Game game) {
		Game newGame = new Game();
		newGame.setDescription(game.getDescription());
		newGame.setGenre(game.getGenre());
		newGame.setTitle(game.getTitle());
		newGame.setReleaseDate(game.getReleaseDate());
		newGame.setUser(game.getUser());
		gameRepository.save(newGame);
	}

	public Optional<Game> findById(Long gameId) {
		return gameRepository.findById(gameId);
	}

	public List<Game> findAll() {
		return gameRepository.findAll();
	}
}
