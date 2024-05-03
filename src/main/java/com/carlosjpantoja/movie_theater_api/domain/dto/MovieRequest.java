package com.carlosjpantoja.movie_theater_api.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
public class MovieRequest {

	public static final String TITLE_NOT_NULL = "El título de la pelicula no puede ser nulo";
	public static final String TITLE_NOT_BLANK = "El título de la pelicula no puede estar vacío";
	public static final String DIRECTOR_NOT_NULL = "El director de la pelicula no puede ser nulo";
	public static final String DIRECTOR_NOT_BLANK = "El director de la pelicula no puede estar vacío";
	public final static String DURATION_NOT_NULL = "La duración de la pelicula no puede ser nula";
	public final static String DURATION_POSITIVE = "La duración de la pelicula debe ser mayor a cero";
	public final static String RELACE_DATE_NOT_NULL = "La fecha de lanzamiento de la pelicula no puede ser nula";

	private byte[] cover;
	@NotNull(message = TITLE_NOT_NULL)
	@NotBlank(message = TITLE_NOT_BLANK)
	private String title;
	@NotNull(message = DIRECTOR_NOT_NULL)
	@NotBlank(message = DIRECTOR_NOT_BLANK)
	private String director;
	@NotNull(message = DURATION_NOT_NULL)
	@Positive(message = DURATION_POSITIVE)
	private Long duration;
	@NotNull(message = RELACE_DATE_NOT_NULL)
	private LocalDate relaseDate;

}

