package com.carlosjpantoja.movie_theater_api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponse {

	private Long id;
	private LocalDateTime dateTime;
	private MovieResponse movie;
	private RoomResponse room;

}
