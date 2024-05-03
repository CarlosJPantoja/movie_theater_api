package com.carlosjpantoja.movie_theater_api.application.controller;

import com.carlosjpantoja.movie_theater_api.application.api.ScheduleAPI;
import com.carlosjpantoja.movie_theater_api.domain.dto.ScheduleRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.ScheduleResponse;
import com.carlosjpantoja.movie_theater_api.domain.mapper.ScheduleMapper;
import com.carlosjpantoja.movie_theater_api.domain.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class ScheduleController implements ScheduleAPI {

	private final ScheduleService scheduleService;


	public ResponseEntity<List<ScheduleResponse>> get() {
		return ResponseEntity.ok(
				scheduleService.get().stream().map(ScheduleMapper.INSTANCE::scheduleToScheduleResponse).collect(toList())
		);
	}

	public ResponseEntity<List<ScheduleResponse>> active() {
		return ResponseEntity.ok(
				scheduleService.active().stream().map(ScheduleMapper.INSTANCE::scheduleToScheduleResponse).collect(toList())
		);
	}

	public ResponseEntity<ScheduleResponse> create(ScheduleRequest scheduleRequest) {
		return ResponseEntity.ok(
				ScheduleMapper.INSTANCE.scheduleToScheduleResponse(
						scheduleService.create(ScheduleMapper.INSTANCE.scheduleRequestToSchedule(scheduleRequest))
				)
		);
	}

	public ResponseEntity<ScheduleResponse> reservate(ScheduleRequest scheduleRequest) {
		return ResponseEntity.ok(
				ScheduleMapper.INSTANCE.scheduleToScheduleResponse(
						scheduleService.reservate(ScheduleMapper.INSTANCE.scheduleRequestToSchedule(scheduleRequest))
				)
		);
	}

	public ResponseEntity<ScheduleResponse> update(Long id, ScheduleRequest scheduleRequest) {
		return ResponseEntity.ok(
				ScheduleMapper.INSTANCE.scheduleToScheduleResponse(
						scheduleService.update(ScheduleMapper.INSTANCE.idAndScheduleRequestToSchedule(id, scheduleRequest))
				)
		);
	}

	public ResponseEntity<Void> delete(Long id) {
		scheduleService.delete(id);
		return ResponseEntity.ok().build();
	}

}
