package com.carlosjpantoja.movie_theater_api.infrastructure.repository;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	@Query("select case when count(s) > 0 then true else false end from Schedule s where s.room.number = ?1 and s.id <> ?4 and s.dateTime between ?2 and ?3")
	boolean existsByRoomNumberAndDateTimeBetweenAndIdNot(Long number, LocalDateTime from, LocalDateTime to, Long id);

}
