package com.carlosjpantoja.movie_theater_api.domain.service;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.Reservation;

import java.util.List;

public interface ReservationService {

	List<Reservation> get(String username);

	void delete(String username, Long id);

}
