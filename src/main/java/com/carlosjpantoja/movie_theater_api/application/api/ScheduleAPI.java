package com.carlosjpantoja.movie_theater_api.application.api;

import com.carlosjpantoja.movie_theater_api.domain.dto.ScheduleRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.ScheduleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppEndpoint.SCHEDULE;

@RequestMapping(SCHEDULE)
public interface ScheduleAPI {

	@GetMapping
	ResponseEntity<List<ScheduleResponse>> get();

	@PostMapping
	ResponseEntity<ScheduleResponse> create(@Valid @RequestBody ScheduleRequest scheduleRequest);

	@PutMapping("/{id}")
	ResponseEntity<ScheduleResponse> update(@PathVariable Long id, @Valid @RequestBody ScheduleRequest scheduleRequest);

	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(@PathVariable Long id);

}
