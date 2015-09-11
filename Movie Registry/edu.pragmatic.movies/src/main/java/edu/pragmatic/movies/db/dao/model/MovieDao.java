package edu.pragmatic.movies.db.dao.model;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import edu.pragmatic.movies.db.dao.hibernate.HibernateDao;
import edu.pragmatic.movies.model.Movie;

public class MovieDao extends HibernateDao<Movie> {

	public MovieDao(Class<? extends Movie> persistentClass) {
		super(persistentClass);
	}
	
	public MovieDao() {
		super(Movie.class);
	}

	public Movie getBy(String name) {
		Criteria cr = getSession().createCriteria(getPersistentClass());
		cr.add(Restrictions.eq("name", name));
		return (Movie) cr.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Movie> getAllMovies(){
		Criteria cr = getSession().createCriteria(getPersistentClass());
		return cr.list();
	}

}
