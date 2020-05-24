package com.cg.moviemgmt.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class CreateMovieRequest {

    @NotBlank
    private String movieName;

    @NotBlank
    private String movieDirector;
    @Min(1)
    private int movieLength;
    @NotBlank
    private String movieReleaseDate;

    @NotBlank
    private String movieGenre;

    @Size(min = 1)
    private List<String> languages;

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }


    public void setMovieReleaseDate(String movieReleadeDate) {
        this.movieReleaseDate = movieReleadeDate;
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
