package edu.pragmatic.movies.db.dao;

/**
 * Common persistent entity methods
 */
public interface PersistentEntity {

	/**
	 * @return the primary key of this entity
	 */
	Long getId();
	
	/**
	 * @param id the entity's primary key 
	 */
	void setId(Long id);
	
}
