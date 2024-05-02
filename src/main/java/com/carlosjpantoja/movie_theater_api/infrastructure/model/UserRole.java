package com.carlosjpantoja.movie_theater_api.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USER_ROLE")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

	@Id
	private UserRolePK id;

}
