package com.cg.moviemgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.moviemgmt.dao.MovieDao;
import com.cg.moviemgmt.entities.Movie;
import com.cg.moviemgmt.exceptions.InvalidArgumentException;
import com.cg.moviemgmt.exceptions.*;

@Service
@Transactional
public class MovieServiceimpl implements IMovieService {
	private MovieDao dao;

	public MovieDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(MovieDao dao) {
		this.dao = dao;
	}

	/**
	 * @param movie 
	 * validates the movie and add
	 * 
	 * @return movie
	 */
	
	
	
	
	
	@Override
	public Movie save(Movie movie) {

		if (movie == null) {
			throw new InvalidArgumentException("Movie can't be Null");
		}

		 movie =dao.save(movie);
		return movie;
	}

	/**
	 * @return list of movies
	 */
	@Override
	public List<Movie> fetchAll() {

		List<Movie> movies = dao.findAll();
		return movies;
	}

	/**
	 * @param movieId
	 * validating and finding the movie with id number
	 * @return movie
	 */

	@Override
	public Movie fetchById(int movieId) {

		Optional<Movie> optional = dao.findById(movieId);
		if (optional.isPresent()) {
			Movie movie = optional.get();
			return movie;
		}
		throw new MovieNotFoundException("Movie not found for id=" + movieId);
	}
	/**
	 * @param movieid
	 * deletes the movie
	 * @return true/false
	 * 
	 */
	@Override
	public String delete(int movieId) {

		Movie movie = fetchById(movieId);
		dao.delete(movie);
		return "Deleted Succesully";
	}

}
