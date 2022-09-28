package com.coderscampus.gamereviews.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.gamereviews.domain.Game;
import com.coderscampus.gamereviews.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	Post findByPostId(Long PostId);


	List<Post> findAllByGame(Optional<Game> thisGame);



}
