package com.coderscampus.gamereviews.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.gamereviews.domain.Game;
import com.coderscampus.gamereviews.domain.Post;
import com.coderscampus.gamereviews.repository.PostRepository;
import com.coderscampus.gamereviews.repository.UserRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	public void createPost(Post post) {
		Post newPost = new Post();
		newPost.setGame(post.getGame());
		newPost.setReview(post.getReview());
		
		postRepository.save(post);
	}
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	public void deleteById(Long postId) {
		postRepository.deleteById(postId);
	}
	
	public Optional<Post> findById(Long postId) {
		return postRepository.findById(postId);
	}

}
