package com.carlosjpantoja.movie_theater_api.domain.service.impl;

import com.carlosjpantoja.movie_theater_api.domain.exception.AppError;
import com.carlosjpantoja.movie_theater_api.domain.exception.AppException;
import com.carlosjpantoja.movie_theater_api.domain.service.MovieService;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Movie;
import com.carlosjpantoja.movie_theater_api.infrastructure.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.MOVIE_01;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;

	public List<Movie> get() {
		return movieRepository.findAll();
	}

	public Movie getById(Long id) {
		return movieRepository.findById(id).orElseThrow(
				() -> new AppException(
						HttpStatus.NOT_FOUND,
						new AppError(
								MOVIE_01.name(),
								MOVIE_01.getMessage()
						)
				)
		);
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
