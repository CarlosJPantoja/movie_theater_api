package com.carlosjpantoja.movie_theater_api.infrastructure.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserRolePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "ID_USER", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "ID_ROLE", nullable = false)
	private Role role;

}
