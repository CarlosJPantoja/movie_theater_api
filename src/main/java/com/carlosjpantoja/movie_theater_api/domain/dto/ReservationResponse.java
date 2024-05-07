package com.carlosjpantoja.movie_theater_api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationResponse {

	private Long id;
	private ScheduleResponse schedule;
	private Long quantity;
	private String username;

}
