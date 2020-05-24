package com.cg.moviemgmt.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;

import javax.persistence.*;


@Entity
@Table(name = "Movies")
public class Movie {

	@Id
	@GeneratedValue
	private int movieId;
	private String movieName;
	private String movieDirector;
	private double movieLength;
	private LocalDate movieReleaseDate;
	private String movieGenre;

	@ElementCollection
	private List<String> languages;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public double getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(double movieLength) {
		this.movieLength = movieLength;
	}

	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> list) {
		this.languages = list;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Movie movie = (Movie) o;
		return movieId == movie.movieId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId);
	}


	@Override
	public String toString() {
		return "MovieId = " +movieId+
				" , movieName = " +movieName+
				" , movieGenre = "+movieGenre+
				" , movieDirector = "+movieDirector;
	}


}
