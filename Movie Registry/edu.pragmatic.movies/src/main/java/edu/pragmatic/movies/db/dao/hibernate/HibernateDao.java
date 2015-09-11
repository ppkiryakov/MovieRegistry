package edu.pragmatic.movies.db.dao.hibernate;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.pragmatic.movies.db.dao.Dao;
import edu.pragmatic.movies.db.hibernate.config.HibernateUtils;

/**
 * A utility class providing simple CRUD operations in a more generic way
 * 
 * @param <T> the persistent object class. It should be class annotated with the {@link Entity} annotation
 */
@SuppressWarnings("unchecked")
public class HibernateDao<T extends Serializable> implements Dao<T> {
	
	private Class<? extends T> persistentClass;
	private Session session = null;
	
	public HibernateDao(Class<? extends T> persistentClass, Session session) {
		if (persistentClass == null){
			throw new IllegalArgumentException("HibernateDao wasn't correctly configured");
		}
		this.persistentClass = persistentClass;
		this.session = session;
	}
	
	public HibernateDao(Class<? extends T> persistentClass) {
		this(persistentClass, HibernateUtils.openSession());
	}
	
	/**
	 * Persist an object to the db
	 * @param o the object to persist
	 */
	@Override
	public void save(T o){
		Transaction t = getSession().beginTransaction();
		getSession().save(o);
		t.commit();
	} 
	
	/**
	 * Update a persistent object
	 * 
	 * @param o
	 */
	@Override
	public void update(T o){
		Transaction t = getSession().beginTransaction();
		getSession().update(o);
		t.commit();
	} 
	
	
	/**
	 * Remove an object from the DB
	 * 
	 * @param o the object to remove
	 */
	@Override
	public void delete(T o) {
		Transaction t = getSession().beginTransaction();
		getSession().delete(o);
		t.commit();
	} 
	
	/** 
	 * @param id the object identifier ( the PK from the DB)
	 * @return a proxy to the object. To initialised it you can use 
	 *           {@link Hibernate#initialize(Object)} or simply call a method of the model object
	 *           However be careful as the method works only with hibernate proxies.   
	 */
	@Override
	public T load(Long id) {
		 return (T) getSession().load(this.persistentClass, id);
	}
	
	/**
	 * @param id the object identifier ( the PK from the DB)
	 * @return the actual initialized object, the object is detached
	 */
	@Override
	public T get(Long id) {
		Transaction t = getSession().beginTransaction();
		Object o = getSession().get(this.persistentClass, id);
		t.commit();
		return (T) o;
	}

	protected Session getSession() {
		return this.session;
	}

	@Override
	public void saveOrUpdate(T o) {
		Transaction transaction = getSession().beginTransaction();
		getSession().saveOrUpdate(o);
		transaction.commit();
	}

	protected Class<? extends T> getPersistentClass() {
		return persistentClass;
	}
	
}
