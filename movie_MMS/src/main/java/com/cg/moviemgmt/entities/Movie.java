package com.cg.moviemgmt.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;

import com.cg.moviemgmt.dto.MovieDetailsDto;

import javax.persistence.*;


@Entity
@Table(name = "Movies")
public class Movie {

	@Id
	@GeneratedValue
	private int movieId;
	private String movieName;
	private String movieDirector;
	private int movieLength;
	private LocalDate movieReleaseDate;
	private String movieGenre;

	@ElementCollection
	private List<String> languages;

	/**
	 * return the movie id
	 * 
	 */
	public int getMovieId() {
		return movieId;
	}
	/**
	 * Set the movie id
	 * 
	 * @param movieID
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * return the movie name
	 * 
	 */ 
	String getMovieName() {
		return movieName;
	}

	/**
	 * Set the movie name
	 * 
	 * @param movieName
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * return the movie director
	 * 
	 */

	public String getMovieDirector() {
		return movieDirector;
	}
	/**
	 * Set the movie director
	 * 
	 * @param movieDirector
	 */
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	/**
	 * Set the movie Length
	 *
	 */
	public int getMovieLength() {
		return movieLength;
	}
	/**
	 * Set the movieLength
	 * 
	 * @param movieLength
	 */
	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}
	/**
	 * return the movie release date
	 *
	 */
	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}
	/**
	 * Set the movie release date
	 * 
	 * @param movieReleaseDate
	 */
	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	/**
	 * return the movie Genre
	 * 
	 */
	public String getMovieGenre() {
		return movieGenre;
	}
	/**
	 * Set the movie genre
	 * 
	 * @param movieGenre
	 */
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	/**
	 * Set the movie languages
	 *
	 */
	public List<String> getLanguages() {
		return languages;
	}
	/**
	 * Set the movie Languages
	 * 
	 * @param List
	 */
	public void setLanguages(List<String> list) {
		this.languages = list;
	}
	/**
	 * check equality of moive object
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Movie movie = (Movie) o;
		return movieId == movie.movieId;
	}
	/**
	 * override hashcode
	 * 
	 * @return hashcode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(movieId);
	}

	/**
	 * @return details of movie
	 */
	@Override
	public String toString() {
		return "MovieId = " +movieId+
				" , movieName = " +movieName+
				" , movieGenre = "+movieGenre+
				" , movieDirector = "+movieDirector;
	}


}
