package com.wirtz.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wirtz.springmvc.model.Movie;
import com.wirtz.springmvc.service.MovieService;

@Controller
@RequestMapping("/Movies")
public class MovieController {
	private static final String ATT_MOVIE="movie";
	private static final String ATT_MOVIES_LIST="movies";
	
	private static final String VIEW_MOVIES="Movies";
	private static final String VIEW_MOVIE_DETAILS="MovieDetails";
	private static final String VIEW_EDIT_MOVIE = "MovieDetailsEditForm";
	private static final String VIEW_NEW_MOVIE = "NewMovieForm";
	
	private static final String VIEW_MOVIES_REDIRECT="redirect:/Movies/";
	
	private final MovieService movieService;
	
	@Autowired
	MovieController(MovieService movieService){
		this.movieService = movieService;
	}
	
	@GetMapping({"/", ""})
	public String getMovies(Model model) {
		List<Movie> movies = movieService.getMovies();
		model.addAttribute(ATT_MOVIES_LIST, movies);
		return VIEW_MOVIES;
	}
	
	@GetMapping({"/{id}"})
	public String getMovie(@PathVariable("id") long movieId, Model model) {
		
		if(movieId != 0) {
			Movie movie = movieService.getMovieById(movieId);
			model.addAttribute(ATT_MOVIE, movie);
			return VIEW_MOVIE_DETAILS;
		
		}else 
			return VIEW_MOVIES_REDIRECT;
	}
	
	@GetMapping({"/edit/{id}"})
	public String editMovie(@PathVariable("id") long movieId, Model model) {
		
		if(movieId != 0) {
			Movie movie = movieService.getMovieById(movieId);
			model.addAttribute(ATT_MOVIE, movie);
			return VIEW_EDIT_MOVIE;
		
		}else 
			return VIEW_MOVIES_REDIRECT;
	}
	
	@PostMapping({"/edit/{id}"})
	public String saveEditMovie(@Valid @ModelAttribute(ATT_MOVIE) Movie movie, BindingResult result) {
		
		if(result.hasErrors()) 
			return VIEW_EDIT_MOVIE;
		
		movieService.updateMovie(movie.getId(), movie.getPuntuacion());
		return VIEW_MOVIES_REDIRECT;
	}
	
	@GetMapping({"/create"})
	public String createMovie(@ModelAttribute(ATT_MOVIE) Movie movie) {
		return VIEW_NEW_MOVIE;
	}
	
	@PostMapping({"/create"})
	public String saveNewMovie(@Valid @ModelAttribute(ATT_MOVIE) Movie movie, BindingResult result) {
		
		if(result.hasErrors()) 
			return VIEW_NEW_MOVIE;
		
		movieService.createMovie(movie.getName(),
				movie.getPuntuacion(),
				movie.getDuracion());
		return VIEW_MOVIES_REDIRECT;
	}

}
