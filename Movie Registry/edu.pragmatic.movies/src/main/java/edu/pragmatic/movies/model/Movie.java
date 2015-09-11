package edu.pragmatic.movies.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE")
public class Movie implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="YEAR_PUBLISHED_ON")
	private String yearPublishedOn;
	
	@Column(name="DIRECTED_BY")
	private String directedBy;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="movie_actors",
			joinColumns=@JoinColumn(name="MOVIE_ID"),
			inverseJoinColumns=@JoinColumn(name="ACTOR_ID")
	)
	private Collection<Actor> actors;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYearPublishedOn() {
		return yearPublishedOn;
	}

	public void setYearPublishedOn(String yearPublishedOn) {
		this.yearPublishedOn = yearPublishedOn;
	}

	public String getDirectedBy() {
		return directedBy;
	}

	public void setDirectedBy(String directedBy) {
		this.directedBy = directedBy;
	}

	public Collection<Actor> getActors() {
		return actors;
	}

	public void setActors(Collection<Actor> actors) {
		this.actors = actors;
	}
	
}
