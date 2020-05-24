package com.cg.moviemgmt.util;

import com.cg.moviemgmt.dto.CreateMovieRequest;
import com.cg.moviemgmt.dto.MovieDetails;
import com.cg.moviemgmt.entities.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MovieUtil {

    public static Movie toMovie(CreateMovieRequest requestData) {
        Movie movie = new Movie();
        LocalDate movieReleaseDate = DateUtil.toLocalDate(requestData.getMovieReleaseDate());
        movie.setMovieReleaseDate(movieReleaseDate);
        movie.setMovieName(requestData.getMovieName());
        movie.setMovieGenre(requestData.getMovieGenre());
        movie.setMovieDirector(requestData.getMovieDirector());
        movie.setMovieLength(requestData.getMovieLength());
        List<String> languageList = requestData.getLanguages();
        movie.setLanguages(languageList);
        return movie;
    }

    public static MovieDetails toDetails(Movie movie) {
        MovieDetails details = new MovieDetails();
        details.setMovieId(movie.getMovieId());
        String releaseDate = DateUtil.toString(movie.getMovieReleaseDate());
        details.setMovieReleaseDate(releaseDate);
        details.setMovieLength(movie.getMovieLength());
        details.setLanguages(movie.getLanguages());
        details.setMovieGenre(movie.getMovieGenre());
        details.setMovieDirector(movie.getMovieDirector());
        details.setMovieName(movie.getMovieName());
        return details;
    }

    public static List<MovieDetails> toDetails(Collection<Movie> movies) {
        List<MovieDetails> desired = new ArrayList<>();
        for (Movie movie : movies) {
            MovieDetails details = toDetails(movie);
            desired.add(details);
        }
        return desired;
    }

}
