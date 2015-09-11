package edu.pragmatic.movies.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.pragmatic.movies.model.Actor;
import edu.pragmatic.movies.model.Movie;
import edu.pragmatic.movies.service.MovieService;

@WebServlet("/film")
public class MovieInfoController extends HttpServlet {

	private static final long serialVersionUID = -5556462481624967645L;
	private MovieService movieSerice;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.movieSerice = new MovieService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filmName = request.getParameter("name");
		if (filmName == null || filmName.isEmpty()){
			response.getOutputStream().println("Please provide the name param in the url");
			return;
		}
		Movie movie = movieSerice.getMovie(filmName);
		
		// Collection<Actor> actors =  movieSerice.findActorsForMovie(filmName);
		// if (actors == null || actors.isEmpty()){
		if (movie == null){
			response.getOutputStream().println("Sorry no information found for movie named " + filmName);
			return;
		}
		
		response.getOutputStream().println(String.format("Cast of %s (%s)", filmName, movie.getYearPublishedOn() ));
		response.getOutputStream().println(String.format("Directed by %s", movie.getDirectedBy()));
		for (Actor actor : movie.getActors()) {
			response.getOutputStream().println(actor.getName() + " " + actor.getLastName());
		}
	}

}
