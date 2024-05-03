package com.carlosjpantoja.movie_theater_api.domain.service;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.Room;

import java.util.List;

public interface RoomService {

	List<Room> get();

	Room create(Room room);

	Room update(Room room);

	void delete(Long number);

}
