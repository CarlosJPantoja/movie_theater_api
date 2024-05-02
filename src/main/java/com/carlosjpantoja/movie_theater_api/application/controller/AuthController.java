package com.carlosjpantoja.movie_theater_api.application.controller;

import com.carlosjpantoja.movie_theater_api.application.api.AuthAPI;
import com.carlosjpantoja.movie_theater_api.application.security.JWTUtil;
import com.carlosjpantoja.movie_theater_api.domain.dto.AuthRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static java.util.stream.Collectors.joining;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthAPI {

	private final AuthenticationManager authenticationManager;

	public ResponseEntity<AuthResponse> authenticate(@RequestBody @Valid AuthRequest request) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(),
						request.getPassword()
				)
		);
		return ResponseEntity.ok(
				new AuthResponse(
						authentication.getAuthorities().stream()
								.map(GrantedAuthority::getAuthority).collect(joining(",")),
						JWTUtil.generateToken(request.getUsername())
				)
		);
	}

}
