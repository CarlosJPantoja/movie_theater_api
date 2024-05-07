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
	AUTH_03("Error al verificar el token de autenticación"),

	MOVIE_01("La película no existe"),

	ROOM_01("La sala no existe"),
	ROOM_02("El número de sala ya está en uso"),

	SCHEDULE_01("El horario de proyección no existe"),
	SCHEDULE_02("La sala se encuentra ocupada en el horario seleccionado"),

	RESERVATION_01("La reserva no existe");

	private final String message;

}