package com.carlosjpantoja.movie_theater_api.domain.mapper;

import com.carlosjpantoja.movie_theater_api.domain.exception.AppError;
import com.carlosjpantoja.movie_theater_api.domain.exception.AppException;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.BASE_64;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Mapper(componentModel = "spring")
public interface BlobMapper {

	BlobMapper INSTANCE = Mappers.getMapper(BlobMapper.class);

	default Blob map(byte[] value) {
		try {
			if (value.length == 0) throw new SQLException();
			return new SerialBlob(value);
		} catch (SQLException e) {
			throw new AppException(
					BAD_REQUEST,
					new AppError(
							BASE_64.name(),
							BASE_64.getMessage()
					)
			);
		}
	}

	default byte[] map(Blob value) {
		try {
			return value.getBytes(1, (int) value.length());
		} catch (SQLException e) {
			return new byte[0];
		}
	}

}
