package com.carlosjpantoja.movie_theater_api.infrastructure.repository;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
