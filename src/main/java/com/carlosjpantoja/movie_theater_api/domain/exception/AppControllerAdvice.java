package com.carlosjpantoja.movie_theater_api.domain.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.AUTH_01;
import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.VALIDATOR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@ControllerAdvice
public class AppControllerAdvice {

	@ExceptionHandler(AppException.class)
	public ResponseEntity<AppError> handleException(AppException exception) {
		return new ResponseEntity<>(exception.getError(), exception.getHttpStatus());
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<AppError> handleException() {
		return new ResponseEntity<>(new AppError(AUTH_01.name(), AUTH_01.getMessage()), UNAUTHORIZED);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<AppError> handleException(MethodArgumentNotValidException exception) {
		return new ResponseEntity<>(
				new AppError(
						VALIDATOR.name(),
						VALIDATOR.getMessage() + String.join(
								", ",
								exception.getBindingResult()
										.getAllErrors()
										.stream()
										.map(ObjectError::getDefaultMessage)
										.collect(Collectors.toSet()))
				),
				BAD_REQUEST
		);
	}

}