package com.cg.moviemgmt.dto;

import java.time.LocalDate;
import java.util.List;

public class MovieDetailsDto {
	
	private int movieId;
	private String movieName;
	private String movieDirector;
	private int movieLength;
	private String movieReleaseDate;
    public String getMovieReleaseDate() {
		return movieReleaseDate;
	}


	public void setMovieReleaseDate(String movieReleadeDate) {
		this.movieReleaseDate = movieReleadeDate;
	}


	private String movieGenre;
	
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


	public int getMovieLength() {
		return movieLength;
	}


	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
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


	


}
