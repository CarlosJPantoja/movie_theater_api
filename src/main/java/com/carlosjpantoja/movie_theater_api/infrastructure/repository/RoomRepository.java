package com.carlosjpantoja.movie_theater_api.infrastructure.repository;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
