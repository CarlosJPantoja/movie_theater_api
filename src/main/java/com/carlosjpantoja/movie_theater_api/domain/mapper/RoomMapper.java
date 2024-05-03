package com.carlosjpantoja.movie_theater_api.domain.mapper;

import com.carlosjpantoja.movie_theater_api.domain.dto.RoomRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.RoomResponse;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;

@Mapper(componentModel = "spring")
public interface RoomMapper {

	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

	Room roomRequestToRoom(RoomRequest roomRequest);

	Room idAndRoomRequestToRoom(Long id, RoomRequest roomRequest);

	RoomResponse roomToRoomResponse(Room room);

	default String map(String[][] distribution) {
		return Arrays.stream(distribution)
				.map(row -> String.join(",", row))
				.reduce((row1, row2) -> row1 + ";" + row2)
				.orElse("");
	}

	default String[][] map(String distribution) {
		return Arrays.stream(distribution.split(";"))
				.map(row -> row.split(","))
				.toArray(String[][]::new);
	}

}
