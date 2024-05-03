package com.carlosjpantoja.movie_theater_api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MovieResponse {

	private Long id;
	private byte[] cover;
	private String title;
	private String director;
	private Long duration;
	private LocalDate relaseDate;

}
