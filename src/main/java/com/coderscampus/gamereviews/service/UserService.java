package com.coderscampus.gamereviews.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coderscampus.gamereviews.domain.Post;
import com.coderscampus.gamereviews.domain.Role;
import com.coderscampus.gamereviews.domain.User;
import com.coderscampus.gamereviews.repository.PostRepository;
import com.coderscampus.gamereviews.repository.RoleRepository;
import com.coderscampus.gamereviews.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PostRepository postRepo;

	public void CreateUser(User user) {
		Role role = new Role();
		role.setUser(user);
		role.setAuthority("USER");
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		roleRepo.save(role);
	}
	
	public void updateUserProfile(User user) {
		
		userRepo.save(user);
	}
	
	public User findByUserId(Long id) {
		return userRepo.findByUserId(id);
	}
	
	public Optional<User> findByUserPost(Long postId) {
		Post post = postRepo.findByPostId(postId);
		Optional<User> user = userRepo.findById(post.getUser().getUserId());
		return user;
	}
}
