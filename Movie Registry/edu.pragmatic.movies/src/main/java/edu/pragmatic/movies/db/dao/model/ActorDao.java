package edu.pragmatic.movies.db.dao.model;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import edu.pragmatic.movies.db.dao.hibernate.HibernateDao;
import edu.pragmatic.movies.model.Actor;

public class ActorDao extends HibernateDao<Actor> {

	public ActorDao(Class<? extends Actor> persistentClass) {
		super(persistentClass);
	}
	
	public ActorDao() {
		super(Actor.class);
	}

	@SuppressWarnings("unchecked")
	public Collection<Actor> findActorsForMovie(String filmName) {
		Criteria cr = getSession().createCriteria(getPersistentClass());
		cr.createAlias("movies", "movies")
		  .add(Restrictions.eq("movies.name", filmName));
		
		return cr.list();
	}

	
	
}
