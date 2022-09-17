package com.coderscampus.gamereviews.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.gamereviews.domain.Game;
import com.coderscampus.gamereviews.domain.User;
import com.coderscampus.gamereviews.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	public Game newGame(User user, Game game) {
		game.setUser(user);
		
		return gameRepository.save(game);
	}

	public Optional<Game> findById(Long gameId) {
		return gameRepository.findById(gameId);

	}
}
