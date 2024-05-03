package com.carlosjpantoja.movie_theater_api.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleRequest {

	private Long id;
	private LocalDateTime dateTime;
	private Long movie;
	private Long room;
	private String[][] distribution;

}
