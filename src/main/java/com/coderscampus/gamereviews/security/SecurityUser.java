package com.coderscampus.gamereviews.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.coderscampus.gamereviews.domain.Role;
import com.coderscampus.gamereviews.domain.User;

public class SecurityUser extends User implements UserDetails {
	

	private static final long serialVersionUID = -6181706091746350146L;

	public SecurityUser() {
	}

	public SecurityUser(User user) {
		this.setUserId(getUserId());
		this.setEmail(getEmail());
		this.setUserName(getUserName());
		this.setPosts(getPosts());
		this.setGames(getGames());
		this.setRoles(getRoles());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}
}
