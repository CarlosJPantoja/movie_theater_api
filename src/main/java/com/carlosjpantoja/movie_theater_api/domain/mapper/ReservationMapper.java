package com.carlosjpantoja.movie_theater_api.domain.mapper;

import com.carlosjpantoja.movie_theater_api.domain.dto.ReservationResponse;
import com.carlosjpantoja.movie_theater_api.domain.dto.ScheduleResponse;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Reservation;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

	ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

	ReservationResponse reservationToReservationResponse(Reservation reservation);

	default ScheduleResponse map(Schedule schedule) {
		return ScheduleMapper.INSTANCE.scheduleToScheduleResponse(schedule);
	}

}
