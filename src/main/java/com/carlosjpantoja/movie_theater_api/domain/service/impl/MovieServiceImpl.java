package com.carlosjpantoja.movie_theater_api.domain.service.impl;

import com.carlosjpantoja.movie_theater_api.domain.service.MovieService;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Movie;
import com.carlosjpantoja.movie_theater_api.infrastructure.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;

	public List<Movie> get() {
		return movieRepository.findAll();
	}

	public Movie create(Movie movie) {
		return movieRepository.save(movie);
	}

	public Movie update(Movie movie) {
		return movieRepository.save(movie);
	}

	public void delete(Long id) {
		movieRepository.deleteById(id);
	}

}
