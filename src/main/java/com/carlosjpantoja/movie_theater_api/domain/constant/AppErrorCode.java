package com.carlosjpantoja.movie_theater_api.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppErrorCode {

	VALIDATOR("Se encontraron los siguientes errores: "),

	BASE_64("Error al codificar"),

	AUTH_01("El usuario o la contraseña son incorrectos"),
	AUTH_02("Se requiere un token de autenticación"),
	AUTH_03("Error al verificar el token de autenticación");

	private final String message;

}