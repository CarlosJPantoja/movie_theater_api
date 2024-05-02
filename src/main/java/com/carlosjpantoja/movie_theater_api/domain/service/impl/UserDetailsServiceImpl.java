package com.carlosjpantoja.movie_theater_api.domain.service.impl;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.User;
import com.carlosjpantoja.movie_theater_api.infrastructure.repository.UserRepository;
import com.carlosjpantoja.movie_theater_api.infrastructure.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(
						() -> new UsernameNotFoundException("")
				);
		return new UserDetailsImpl(user, userRoleRepository);
	}

}
