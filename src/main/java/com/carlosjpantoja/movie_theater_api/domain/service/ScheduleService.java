package com.carlosjpantoja.movie_theater_api.domain.service;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.Schedule;

import java.util.List;

public interface ScheduleService {

	List<Schedule> get();

	List<Schedule> active();

	Schedule create(Schedule schedule);

	Schedule reservate(Schedule schedule);

	Schedule update(Schedule schedule);

	void delete(Long id);

}
