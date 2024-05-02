package com.carlosjpantoja.movie_theater_api.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthRequest {

	public final static String USERNAME_NOT_NULL = "El usuario no puede ser nulo";
	public final static String USERNAME_NOT_BLANK = "El usuario no puede estar vacio";
	public final static String PASSWORD_NOT_NULL = "La contraseña no puede ser nula";
	public final static String PASSWORD_NOT_BLANK = "La contraseña no puede estar vacia";

	@NotNull(message = USERNAME_NOT_NULL)
	@NotBlank(message = USERNAME_NOT_BLANK)
	private String username;
	@NotNull(message = PASSWORD_NOT_NULL)
	@NotBlank(message = PASSWORD_NOT_BLANK)
	private String password;

}
