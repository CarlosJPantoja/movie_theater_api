package com.carlosjpantoja.movie_theater_api.application.controller;

import com.carlosjpantoja.movie_theater_api.application.api.RoomAPI;
import com.carlosjpantoja.movie_theater_api.domain.dto.RoomRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.RoomResponse;
import com.carlosjpantoja.movie_theater_api.domain.mapper.RoomMapper;
import com.carlosjpantoja.movie_theater_api.domain.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomAPI {

	private final RoomService roomService;

	public ResponseEntity<List<RoomResponse>> get() {
		return ResponseEntity.ok(
				roomService.get().stream().map(RoomMapper.INSTANCE::roomToRoomResponse).collect(toList())
		);
	}

	public ResponseEntity<RoomResponse> create(RoomRequest roomRequest) {
		return ResponseEntity.ok(
				RoomMapper.INSTANCE.roomToRoomResponse(
						roomService.create(
								RoomMapper.INSTANCE.roomRequestToRoom(roomRequest)
						)
				)
		);
	}

	public ResponseEntity<RoomResponse> update(Long number, RoomRequest roomRequest) {
		return ResponseEntity.ok(
				RoomMapper.INSTANCE.roomToRoomResponse(
						roomService.update(
								RoomMapper.INSTANCE.idAndRoomRequestToRoom(number, roomRequest)
						)
				)
		);
	}

	public ResponseEntity<Void> delete(Long number) {
		roomService.delete(number);
		return ResponseEntity.ok().build();
	}

}
