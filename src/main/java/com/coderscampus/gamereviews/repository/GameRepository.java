package com.coderscampus.gamereviews.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.gamereviews.domain.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
}
