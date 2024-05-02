package com.carlosjpantoja.movie_theater_api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponse {

	private String role;
	private String token;

}
