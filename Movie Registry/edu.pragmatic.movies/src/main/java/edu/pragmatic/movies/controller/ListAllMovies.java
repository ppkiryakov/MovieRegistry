package edu.pragmatic.movies.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.pragmatic.movies.model.Movie;
import edu.pragmatic.movies.service.MovieService;

@WebServlet("/all")
public class ListAllMovies extends HttpServlet {

	private static final long serialVersionUID = -1L;
	private MovieService movieSerice;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.movieSerice = new MovieService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Movie> movies = movieSerice.getAllMovies();
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("/page/allmovies.jsp").forward(request, response);
	}
	
}
