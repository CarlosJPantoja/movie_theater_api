package com.carlosjpantoja.movie_theater_api.application.controller;

import com.carlosjpantoja.movie_theater_api.application.api.MovieAPI;
import com.carlosjpantoja.movie_theater_api.domain.dto.MovieRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.MovieResponse;
import com.carlosjpantoja.movie_theater_api.domain.mapper.MovieMapper;
import com.carlosjpantoja.movie_theater_api.domain.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class MovieController implements MovieAPI {

	private final MovieService movieService;

	public ResponseEntity<List<MovieResponse>> get() {
		return ResponseEntity.ok(
				movieService.get().stream().map(MovieMapper.INSTANCE::movieToMovieResponse).collect(toList())
		);
	}

	public ResponseEntity<MovieResponse> create(MovieRequest movieRequest) {
		return ResponseEntity.ok(
				MovieMapper.INSTANCE.movieToMovieResponse(
						movieService.create(
								MovieMapper.INSTANCE.movieRequestToMovie(movieRequest)
						)
				)
		);
	}

	public ResponseEntity<MovieResponse> update(Long id, MovieRequest movieRequest) {
		return ResponseEntity.ok(
				MovieMapper.INSTANCE.movieToMovieResponse(
						movieService.update(
								MovieMapper.INSTANCE.idAndMovieRequestToMovie(id, movieRequest)
						)
				)
		);
	}

	public ResponseEntity<Void> delete(Long id) {
		movieService.delete(id);
		return ResponseEntity.ok().build();
	}

}
