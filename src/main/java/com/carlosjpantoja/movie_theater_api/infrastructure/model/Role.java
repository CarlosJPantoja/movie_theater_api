package com.carlosjpantoja.movie_theater_api.infrastructure.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "APP_ROLE")
@Getter
@NoArgsConstructor
@Where(clause = "project = 'MOVIE_THEATER'")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "AUTHORITY")
	private String authority;

	@Column(name = "PROJECT")
	private String project;

}