package com.carlosjpantoja.movie_theater_api.infrastructure.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "SCHEDULE")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "DATE_TIME")
	private LocalDateTime dateTime;
	@ManyToOne
	@JoinColumn(name = "MOVIE")
	private Movie movie;
	@ManyToOne
	@JoinColumn(name = "ROOM")
	private Room room;
	@Column(name = "DISTRIBUTION")
	private String distribution;

}
