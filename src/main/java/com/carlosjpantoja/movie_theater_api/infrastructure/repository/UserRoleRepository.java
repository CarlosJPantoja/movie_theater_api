package com.carlosjpantoja.movie_theater_api.infrastructure.repository;

import com.carlosjpantoja.movie_theater_api.infrastructure.model.UserRole;
import com.carlosjpantoja.movie_theater_api.infrastructure.model.UserRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK> {

	@Query("select ur from UserRole ur where ur.id.user.id = :id and ur.id.role.project = 'MOVIE_THEATER'")
	List<UserRole> findAllById_User_Id(Long id);

}
