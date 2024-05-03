package com.carlosjpantoja.movie_theater_api.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class RoomRequest {

	public final static String NUMBER_NOT_NULL = "El número de la sala no puede ser nulo";
	public final static String NUMBER_POSITIVE = "El número de la sala debe ser mayor a cero";
	public final static String CAPACITY_NOT_NULL = "La capacidad de la sala no puede ser nula";
	public final static String CAPACITY_POSITIVE = "La capacidad de la sala debe ser mayor a cero";

	@NotNull(message = NUMBER_NOT_NULL)
	@Positive(message = NUMBER_POSITIVE)
	private Long number;

	@NotNull(message = CAPACITY_NOT_NULL)
	@Positive(message = CAPACITY_POSITIVE)
	private Long capacity;

	private String[][] distribution;

}

