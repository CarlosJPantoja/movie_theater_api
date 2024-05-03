package com.carlosjpantoja.movie_theater_api.domain.service;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.Movie;

import java.util.List;

public interface MovieService {

	List<Movie> get();

	Movie getById(Long id);

	Movie create(Movie movie);

	Movie update(Movie movie);

	void delete(Long id);

}
