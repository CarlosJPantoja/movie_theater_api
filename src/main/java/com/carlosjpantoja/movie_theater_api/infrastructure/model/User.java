package com.carlosjpantoja.movie_theater_api.infrastructure.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "APP_USER")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ENABLED")
	private boolean enabled;
	@Column(name = "ACCOUNT_EXPIRED")
	private boolean accountExpired;
	@Column(name = "ACCOUNT_LOCKED")
	private boolean accountLocked;
	@Column(name = "PASSWORD_EXPIRED")
	private boolean passwordExpired;
	@Column(name = "VERSION")
	private Long version;

}