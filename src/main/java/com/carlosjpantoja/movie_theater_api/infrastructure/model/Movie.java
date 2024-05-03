package com.carlosjpantoja.movie_theater_api.infrastructure.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Table(name = "MOVIE")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Lob
	@Column(name = "COVER")
	private Blob cover;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DIRECTOR")
	private String director;
	@Column(name = "DURATION")
	private Long duration;
	@Column(name = "RELASE_DATE")
	private LocalDate relaseDate;

}
