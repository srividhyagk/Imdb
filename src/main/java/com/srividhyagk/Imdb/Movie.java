package com.srividhyagk.Imdb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {
	@Id 
	private int id;
	private String title;
	private String category;

	// constructors
	protected Movie() {
	}

	public Movie(int id,String title, String category)  {
		super();
		if(id<=0)
				throw new IllegalArgumentException("ID must be greater than 0");
		this.id = id;
		this.title = title;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", category=" + category + "]";
	}

	public String getCategory() {
		return this.category;
	}
}

