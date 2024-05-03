package com.carlosjpantoja.movie_theater_api.domain.service.impl;

import com.carlosjpantoja.movie_theater_api.domain.exception.AppError;
import com.carlosjpantoja.movie_theater_api.domain.exception.AppException;
import com.carlosjpantoja.movie_theater_api.domain.service.MovieService;
import com.carlosjpantoja.movie_theater_api.domain.service.RoomService;
import com.carlosjpantoja.movie_theater_api.domain.service.ScheduleService;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Schedule;
import com.carlosjpantoja.movie_theater_api.infrastructure.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.SCHEDULE_01;
import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.SCHEDULE_02;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

	private final MovieService movieService;
	private final RoomService roomService;
	private final ScheduleRepository scheduleRepository;

	public List<Schedule> get() {
		return scheduleRepository.findAll();
	}

	private void getById(Long id) {
		scheduleRepository.findById(id).orElseThrow(
				() -> new AppException(
						HttpStatus.NOT_FOUND,
						new AppError(
								SCHEDULE_01.name(),
								SCHEDULE_01.getMessage()
						)
				)
		);
	}

	public Schedule create(Schedule schedule) {
		return save(schedule);
	}

	public Schedule update(Schedule schedule) {
		getById(schedule.getId());
		return save(schedule);
	}

	private Schedule save(Schedule schedule) {
		schedule.setMovie(movieService.getById(schedule.getMovie().getId()));
		schedule.setRoom(roomService.getById(schedule.getRoom().getNumber()));
		if (scheduleRepository.existsByRoomNumberAndDateTimeBetweenAndIdNot(
				schedule.getRoom().getNumber(),
				schedule.getDateTime().minusMinutes(schedule.getMovie().getDuration()),
				schedule.getDateTime().plusMinutes(schedule.getMovie().getDuration()),
				schedule.getId() == null ? 0L : schedule.getId()
		))
			throw new AppException(
					HttpStatus.FORBIDDEN,
					new AppError(
							SCHEDULE_02.name(),
							SCHEDULE_02.getMessage()
					)
			);
		return scheduleRepository.save(schedule);
	}

	public void delete(Long id) {
		getById(id);
		scheduleRepository.deleteById(id);
	}

}
