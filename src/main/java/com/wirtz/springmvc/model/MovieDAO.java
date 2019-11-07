package com.wirtz.springmvc.model;

import java.math.BigDecimal;
import java.util.List;

public interface MovieDAO {

	public List<Movie> getMovies();
	
	public Movie getMovieById(long id);

	public Movie update(Movie m);

	public Movie createMovie(String name, BigDecimal puntuacion, int duracion);
}
