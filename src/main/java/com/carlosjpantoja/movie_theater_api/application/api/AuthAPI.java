package com.carlosjpantoja.movie_theater_api.application.api;

import com.carlosjpantoja.movie_theater_api.domain.dto.AuthRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppEndpoint.AUTH;
import static com.carlosjpantoja.movie_theater_api.domain.constant.AppEndpoint.AUTHENTICATE;

@RequestMapping(AUTH)
public interface AuthAPI {

	@PostMapping(AUTHENTICATE)
	ResponseEntity<AuthResponse> authenticate(
			@Valid
			@RequestBody
			AuthRequest request
	);

}
