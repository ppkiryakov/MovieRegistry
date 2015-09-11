package edu.pragmatic.movies.service;

import java.util.Collection;

import edu.pragmatic.movies.db.dao.model.ActorDao;
import edu.pragmatic.movies.db.dao.model.MovieDao;
import edu.pragmatic.movies.model.Actor;
import edu.pragmatic.movies.model.Movie;

public class MovieService {

	private ActorDao actorsDao;
	private MovieDao movieDao;
	
	
	public MovieService() {
		actorsDao = new ActorDao();
		movieDao = new MovieDao();
	}
	
	public Collection<Actor> findActorsForMovie(String filmName) {
		return actorsDao.findActorsForMovie(filmName);
	}
	
	public Movie getMovie(String name){
		return movieDao.getBy(name);
	}

	public Collection<Movie> getAllMovies(){
		return movieDao.getAllMovies();
	}
	
}
