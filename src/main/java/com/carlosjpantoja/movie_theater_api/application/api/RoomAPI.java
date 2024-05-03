package com.carlosjpantoja.movie_theater_api.application.api;

import com.carlosjpantoja.movie_theater_api.domain.dto.RoomRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.RoomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppEndpoint.ROOM;

@RequestMapping(ROOM)
public interface RoomAPI {

	@GetMapping
	ResponseEntity<List<RoomResponse>> get();

	@PostMapping
	ResponseEntity<RoomResponse> create(@Valid @RequestBody RoomRequest roomRequest);

	@PutMapping("/{number}")
	ResponseEntity<RoomResponse> update(@PathVariable Long number, @Valid @RequestBody RoomRequest roomRequest);

	@DeleteMapping("/{number}")
	ResponseEntity<Void> delete(@PathVariable Long number);

}
