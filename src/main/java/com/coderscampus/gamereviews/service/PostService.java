package com.coderscampus.gamereviews.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.gamereviews.domain.Post;
import com.coderscampus.gamereviews.domain.User;
import com.coderscampus.gamereviews.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post createPost(User user, Post post) {
		post.setUser(user);
		
		return postRepository.save(post);
	}
	public List<Post> findAll() {
		List<Post> allPosts = postRepository.findAll();
		
		return allPosts;
	}
	
	public void deleteById(Long postId) {
		postRepository.deleteById(postId);
	}
	
	public Optional<Post> findById(Long postId) {
		return postRepository.findById(postId);
	}
}
