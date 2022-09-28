package com.coderscampus.gamereviews.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coderscampus.gamereviews.domain.Authorities;
import com.coderscampus.gamereviews.domain.Post;
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

	public void createUser(User user) {
			encodePassword(user);
			Authorities authority = new Authorities();
			authority.setUser(user);
			authority.setAuthority("USER");
			
			userRepo.save(user);
			roleRepo.save(authority);
	}

	public void updateUserProfile(User user) {
		userRepo.save(user);
	}

	public User findByUserId(Long id) {
		return userRepo.findByUserId(id);
	}

	public void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}
}
