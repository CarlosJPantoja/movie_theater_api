package com.carlosjpantoja.movie_theater_api.application.api;

import com.carlosjpantoja.movie_theater_api.domain.dto.ReservationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppEndpoint.RESERVATION;

@RequestMapping(RESERVATION)
public interface ReservationAPI {

	@GetMapping
	ResponseEntity<List<ReservationResponse>> get(Authentication authentication);

	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(Authentication authentication, @PathVariable Long id);

}
