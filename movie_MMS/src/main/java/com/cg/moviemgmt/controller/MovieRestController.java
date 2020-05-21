package com.cg.moviemgmt.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.moviemgmt.dto.MovieDetailsDto;
import com.cg.moviemgmt.entities.Movie;
import com.cg.moviemgmt.exceptions.MovieNotFoundException;
import com.cg.moviemgmt.service.IMovieService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

	private static final Logger Log = LoggerFactory.getLogger(MovieRestController.class);


	@Autowired
	private IMovieService movieService;
	
	
	@PostConstruct
	public void addMovie() {
		Movie movie=new Movie();
		movie.setMovieId(1);
		movie.setMovieName("Avengers");
		movie.setMovieDirector("Stan lee");
		movie.setMovieLength(3);
		movie.setMovieGenre("Action");
	
		movieService.save(movie);
	}
	/***
	 * for adding the details
	 * 
	 * @param movieDto
	 * @return whether added or not
	 */
	
	

	@PostMapping("/add")
	private ResponseEntity<Movie> addMovie(@RequestBody MovieDetailsDto movieDto){
		Movie movie = convertToDetailsDto(movieDto);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
		LocalDate movieReleaseDate = LocalDate.parse(movieDto.getMovieReleaseDate(),formatter);

		movie.setMovieReleaseDate(movieReleaseDate);
		movie.setMovieId(movieDto.getMovieId());
		movie.setMovieName(movieDto.getMovieName());
		movie.setMovieGenre(movieDto.getMovieGenre());
		movie.setMovieDirector(movieDto.getMovieDirector());
		


		List<String> languageList=setLanguages(movieDto);
		movie.setLanguages(movieDto.getLanguages());
		
		movieService.save(movie);
		
		ResponseEntity<Movie> response = new ResponseEntity<>(movie, HttpStatus.OK);
		return response;
	}
	/**
	 * to get the details by id
	 * 
	 * @param movieid
	 *  
	 */
	@GetMapping("/get/{id}")
	private ResponseEntity<Movie> fetchById(@PathVariable("id") int movieId){;
	Movie movie = movieService.fetchById(movieId);
	ResponseEntity<Movie> response = new ResponseEntity<Movie>(movie, HttpStatus.OK);
	return response;
	}
	/***
	 * 
	 * @return list of all movies
	 */
	@GetMapping
	ResponseEntity<List<Movie>> fetchAll(){
		List<Movie> movieList = movieService.fetchAll();
		ResponseEntity<List<Movie>> response = new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
		return response;
	}
	/**
	 * deletes the movie details
	 * 
	 * @param movieDto 
	 * @return whether the movie data is deleted
	 */
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> delete(@PathVariable("id") int movieId)
	{
		String result  = movieService.delete(movieId);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;
	}

	private List<String> setLanguages(MovieDetailsDto moviedto){
		List<String> languageList = new ArrayList<>();
		List<String> movieLanguageList = moviedto.getLanguages();
		for(String language:movieLanguageList) {
			languageList.add(language);
		}
	return languageList;
	}
	
		

	private Movie convertToDetailsDto(MovieDetailsDto movieDetailsDto) {
		Movie movie = new Movie();
		movie.setMovieId(movieDetailsDto.getMovieId());
		movie.setMovieName(movieDetailsDto.getMovieName());
		movie.setMovieGenre(movieDetailsDto.getMovieGenre());
		movie.setMovieDirector(movieDetailsDto.getMovieDirector());
		movie.setMovieLength(movieDetailsDto.getMovieLength());
		
		List<String> List=setLanguages(movieDetailsDto);
		movie.setLanguages(List);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate movieReleaseDate=LocalDate.parse(movieDetailsDto.getMovieReleaseDate());
		movie.setMovieReleaseDate(movieReleaseDate);

		return movie;

	}

	/**
	 * 
	 * @param ex
	 * 
	 */
	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFound(MovieNotFoundException ex) {
		Log.error("handleMovieNotFound()", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return response;
	}
	/**
	 * blanket exception handler
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleAll(Throwable ex) {
		Log.error("handleAll()", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

}
