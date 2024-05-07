package com.carlosjpantoja.movie_theater_api.infrastructure.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "QUANTITY")
	private Long quantity;
	@Column(name = "USERNAME")
	private String username;
	@ManyToOne
	@JoinColumn(name = "SCHEDULE")
	private Schedule schedule;

}
