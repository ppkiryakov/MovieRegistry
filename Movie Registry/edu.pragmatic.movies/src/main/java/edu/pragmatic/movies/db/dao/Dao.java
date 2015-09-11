package edu.pragmatic.movies.db.dao;


/**
 * CRUD operations interface
 * 
 * @param <T> the entity to persist
 */
public interface Dao<T> {

	/**
	 * @param id the PK of the entity to return
	 * @return a concrete entity retrieved by the PK id 
	 */
	T get(Long id);

	/**
	 * @param id the PK of the entity to return 
	 * @return a proxy to entity searched for with the supplied PK
	 */
	T load(Long id);

	void delete(T o);

	void update(T o);

	/**
	 * The create operations. Saves a new object
	 * 
	 * @param o the object to save
	 */
	void save(T o);
	
	/**
	 * Create a new entry in the DB or update an existing one
	 * 
	 * @param o the object to update
	 */
	void saveOrUpdate(T o);
	
}
