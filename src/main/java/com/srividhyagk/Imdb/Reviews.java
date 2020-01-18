package com.srividhyagk.Imdb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String comment;
	private int rating;
	
	//Foreign keys
	
	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "id",insertable = false, updatable = false)

	private Movie movie;
	private int movie_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id",insertable = false, updatable = false)
	private User user;
	private int user_id;
	public Reviews(int id, String comment, int rating, Movie movie, int movie_id, User user, int user_id) {
		super();
		this.id = id;
		this.comment = comment;
		this.rating = rating;
		this.movie = movie;
		this.movie_id = movie_id;
		this.user = user;
		this.user_id = user_id;
	}
	
	public Reviews() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", comment=" + comment + ", rating=" + rating + ", movie=" + movie + ", movie_id="
				+ movie_id + ", user=" + user + ", user_id=" + user_id + "]";
	}
	
	
		
}

