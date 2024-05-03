package com.carlosjpantoja.movie_theater_api.domain.service;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.Schedule;

import java.util.List;

public interface ScheduleService {

	List<Schedule> get();

	Schedule create(Schedule schedule);

	Schedule update(Schedule schedule);

	void delete(Long id);

}
