package com.carlosjpantoja.movie_theater_api.domain.service.impl;

import com.carlosjpantoja.movie_theater_api.domain.exception.AppError;
import com.carlosjpantoja.movie_theater_api.domain.exception.AppException;
import com.carlosjpantoja.movie_theater_api.domain.service.RoomService;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Room;
import com.carlosjpantoja.movie_theater_api.infrastructure.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.ROOM_01;
import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.ROOM_02;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

	private final RoomRepository roomRepository;

	public List<Room> get() {
		return roomRepository.findAll();
	}

	public Room getById(Long number) {
		return roomRepository.findById(number).orElseThrow(
				() -> new AppException(
						HttpStatus.NOT_FOUND,
						new AppError(
								ROOM_01.name(),
								ROOM_01.getMessage()
						)
				)
		);
	}

	public Room create(Room room) {
		if (roomRepository.existsById(room.getNumber()))
			throw new AppException(
					HttpStatus.FORBIDDEN,
					new AppError(
							ROOM_02.name(),
							ROOM_02.getMessage()
					)
			);
		return roomRepository.save(room);
	}

	public Room update(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public void delete(Long number) {
		roomRepository.deleteById(number);
	}

}
