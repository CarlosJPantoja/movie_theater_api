package com.carlosjpantoja.movie_theater_api.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppError {

	private String code;
	private String message;

}
