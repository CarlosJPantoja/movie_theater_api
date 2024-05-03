package com.carlosjpantoja.movie_theater_api.domain.mapper;

import com.carlosjpantoja.movie_theater_api.domain.dto.MovieRequest;
import com.carlosjpantoja.movie_theater_api.domain.dto.MovieResponse;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.sql.Blob;

@Mapper(componentModel = "spring")
public interface MovieMapper {

	MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

	Movie movieRequestToMovie(MovieRequest movieRequest);

	Movie idAndMovieRequestToMovie(Long id, MovieRequest movieRequest);

	MovieResponse movieToMovieResponse(Movie movie);

	default Blob map(byte[] value) {
		return BlobMapper.INSTANCE.map(value);
	}

	default byte[] map(Blob value) {
		return BlobMapper.INSTANCE.map(value);
	}

}
