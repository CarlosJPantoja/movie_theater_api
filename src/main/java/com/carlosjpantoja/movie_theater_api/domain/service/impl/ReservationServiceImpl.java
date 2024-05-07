package com.carlosjpantoja.movie_theater_api.domain.service.impl;

import com.carlosjpantoja.movie_theater_api.domain.exception.AppError;
import com.carlosjpantoja.movie_theater_api.domain.exception.AppException;
import com.carlosjpantoja.movie_theater_api.domain.service.ReservationService;
import com.carlosjpantoja.movie_theater_api.domain.service.ScheduleService;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Reservation;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Schedule;
import com.carlosjpantoja.movie_theater_api.infrastructure.repository.ReservationRepository;
import com.carlosjpantoja.movie_theater_api.infrastructure.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.RESERVATION_01;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

	private final ScheduleService scheduleService;
	private final ReservationRepository reservationRepository;
	private final ScheduleRepository scheduleRepository;


	public List<Reservation> get(String username) {
		return reservationRepository.findByUser_Username(username);
	}

	private Reservation getByIdAndUsername(Long id, String username) {
		return reservationRepository.findByIdAndUsername(id, username).orElseThrow(
				() -> new AppException(
						HttpStatus.NOT_FOUND,
						new AppError(
								RESERVATION_01.name(),
								RESERVATION_01.getMessage(
								)
						)
				)
		);
	}

	public void delete(String username, Long id) {
		Reservation reservation = getByIdAndUsername(id, username);
		reservationRepository.deleteById(id);
		Schedule schedule = scheduleService.getById(reservation.getSchedule().getId());
		schedule.setDistribution(schedule.getDistribution().replaceAll(username + id, "active"));
		scheduleRepository.save(schedule);
	}

}
