package com.wirtz.springmvc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wirtz.springmvc.model.Movie;
import com.wirtz.springmvc.model.MovieDAO;
import com.wirtz.springmvc.model.MovieDAOHashmapImpl;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieDAO productDAO;
	
	@Autowired
	MovieServiceImpl(MovieDAO productDAO){
		this.productDAO=productDAO;
	}

	@Override
	public List<Movie> getMovies() {

		return productDAO.getMovies();
	}

	@Override
	public Movie getMovieById(long id) {

		return productDAO.getMovieById(id);
	}

	@Override
	public Movie updateMovie(long id, BigDecimal score) {
		Movie m = productDAO.getMovieById(id);
		m.setPuntuacion(score);
		return productDAO.update(m);
	}

	@Override
	public double getAverage() {
		return productDAO.getMovies()
						.stream()
						.mapToDouble(Movie::getPuntuacionDouble)
						.average()
						.getAsDouble();
	}

	@Override
	public Movie createMovie(String name, BigDecimal puntuacion, int duracion) {
		// TODO Auto-generated method stub
		return productDAO.createMovie(name, puntuacion, duracion);
	}

}
