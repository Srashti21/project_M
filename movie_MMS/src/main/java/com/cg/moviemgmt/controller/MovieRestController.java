package com.cg.moviemgmt.controller;


import com.cg.moviemgmt.dto.MovieDetails;
import com.cg.moviemgmt.util.DateUtil;
import com.cg.moviemgmt.util.MovieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.moviemgmt.dto.CreateMovieRequest;
import com.cg.moviemgmt.entities.Movie;
import com.cg.moviemgmt.exceptions.MovieNotFoundException;
import com.cg.moviemgmt.service.IMovieService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    private static final Logger Log = LoggerFactory.getLogger(MovieRestController.class);

    @Autowired
    private IMovieService movieService;

    /**
     * @param requestData for creating movie
     * @return movie details
     */
    @PostMapping("/add")
    public ResponseEntity<MovieDetails> addMovie(@RequestBody @Valid CreateMovieRequest requestData) {
        Movie movie = MovieUtil.toMovie(requestData);
        movie = movieService.save(movie);
        MovieDetails movieDetails = MovieUtil.toDetails(movie);
        ResponseEntity<MovieDetails> response = new ResponseEntity<>(movieDetails, HttpStatus.OK);
        return response;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MovieDetails> fetchById(@PathVariable("id") int movieId) {
        Movie movie = movieService.fetchById(movieId);
        MovieDetails movieDetails = MovieUtil.toDetails(movie);
        ResponseEntity<MovieDetails> response = new ResponseEntity<>(movieDetails, HttpStatus.OK);
        return response;
    }

    /***
     *
     * @return list of all movies
     */
    @GetMapping
    public ResponseEntity<List<MovieDetails>> fetchAll() {
        List<Movie> movieList = movieService.fetchAll();
        List<MovieDetails> details = MovieUtil.toDetails(movieList);
        ResponseEntity<List<MovieDetails>> response = new ResponseEntity<>(details, HttpStatus.OK);
        return response;
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int movieId) {
        String result = movieService.delete(movieId);
        ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
        return response;
    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleAll(Throwable ex) {
        Log.error("handleAll()", ex);
        String msg = ex.getMessage();
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }

}
