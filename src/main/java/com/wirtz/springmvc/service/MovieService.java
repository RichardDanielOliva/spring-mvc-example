package com.wirtz.springmvc.service;

import java.math.BigDecimal;
import java.util.List;

import com.wirtz.springmvc.model.Movie;

public interface MovieService {

	public List<Movie> getMovies();
	
	public Movie getMovieById(long id);
	
	public Movie createMovie(String name, BigDecimal puntuacion, int duracion);
	
	public Movie updateMovie(long id, BigDecimal score);
	
	public double getAverage();
}
