package com.carlosjpantoja.movie_theater_api.application.api;

import com.carlosjpantoja.movie_theater_api.domain.dto.MovieRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.MovieResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppEndpoint.MOVIE;

@RequestMapping(MOVIE)
public interface MovieAPI {

	@GetMapping
	ResponseEntity<List<MovieResponse>> get();

	@PostMapping
	ResponseEntity<MovieResponse> create(@Valid @RequestBody MovieRequest movieRequest);

	@PutMapping("/{id}")
	ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest movieRequest);

	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(@PathVariable Long id);

}
