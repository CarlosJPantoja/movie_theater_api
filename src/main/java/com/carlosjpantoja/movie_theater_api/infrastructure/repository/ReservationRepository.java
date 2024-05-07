package com.carlosjpantoja.movie_theater_api.infrastructure.repository;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("SELECT r FROM Reservation r WHERE r.username = ?1")
	List<Reservation> findByUser_Username(String username);

	Optional<Reservation> findByIdAndUsername(Long id, String username);

}
