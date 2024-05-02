package com.carlosjpantoja.movie_theater_api.domain.service.impl;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.User;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.UserRole;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.UserRolePK;
import com.carlosjpantoja.movie_theater_api.infrastructure.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

	private User user;
	private UserRoleRepository userRoleRepository;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userRoleRepository.findAllById_User_Id(user.getId())
				.stream()
				.map(UserRole::getId)
				.map(UserRolePK::getRole)
				.collect(toList());
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !user.isAccountExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.isAccountLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.isPasswordExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

}
