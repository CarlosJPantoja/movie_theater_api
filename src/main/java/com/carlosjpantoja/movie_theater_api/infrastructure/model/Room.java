package com.carlosjpantoja.movie_theater_api.infrastructure.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {

	@Id
	@Column(name = "NUMBER")
	private Long number;

	@Column(name = "CAPACITY")
	private Long capacity;

	@Column(name = "DISTRIBUTION")
	private String distribution;

}
