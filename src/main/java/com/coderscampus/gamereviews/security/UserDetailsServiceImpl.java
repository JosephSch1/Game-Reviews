package com.coderscampus.gamereviews.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coderscampus.gamereviews.domain.User;
import com.coderscampus.gamereviews.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userByUsername = userRepository.findByUserName(username);
		if (userByUsername != null) {
			return new SecurityUser(userByUsername);
		}
		throw new UsernameNotFoundException("No User with username: " + username);
	}
	

}
