package com.carlosjpantoja.movie_theater_api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoomResponse {

	private Long number;
	private Long capacity;
	private String[][] distribution;

}
