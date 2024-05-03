package com.carlosjpantoja.movie_theater_api.domain.mapper;

import com.carlosjpantoja.movie_theater_api.domain.dto.ScheduleRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.ScheduleResponse;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Movie;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Room;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.sql.Blob;
import java.util.Arrays;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

	ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

	Schedule scheduleRequestToSchedule(ScheduleRequest scheduleRequest);

	Schedule idAndScheduleRequestToSchedule(Long id, ScheduleRequest scheduleRequest);

	ScheduleResponse scheduleToScheduleResponse(Schedule schedule);

	default byte[] map(Blob value) {
		return BlobMapper.INSTANCE.map(value);
	}

	default String[][] map(String distribution) {
		return Arrays.stream(distribution.split(";"))
				.map(row -> row.split(","))
				.toArray(String[][]::new);
	}

	default Movie createMovie(Long movie){
		return Movie.builder().id(movie).build();
	}

	default Room createRoom(Long room){
		return Room.builder().number(room).build();
	}

}
