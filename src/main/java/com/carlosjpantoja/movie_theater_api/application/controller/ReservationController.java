package com.carlosjpantoja.movie_theater_api.application.controller;

import com.carlosjpantoja.movie_theater_api.application.api.ReservationAPI;
import com.carlosjpantoja.movie_theater_api.domain.dto.ReservationResponse;
import com.carlosjpantoja.movie_theater_api.domain.mapper.ReservationMapper;
import com.carlosjpantoja.movie_theater_api.domain.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReservationController implements ReservationAPI {

	private final ReservationService reservationService;

	public ResponseEntity<List<ReservationResponse>> get(Authentication authentication) {
		return ResponseEntity.ok(reservationService.get(authentication.getName()).stream().map(ReservationMapper.INSTANCE::reservationToReservationResponse).collect(Collectors.toList()));
	}

	public ResponseEntity<Void> delete(Authentication authentication, Long id) {
		reservationService.delete(authentication.getName(), id);
		return ResponseEntity.ok().build();
	}

}
