package com.srividhyagk.Imdb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")

public class User {
	@Id	
	private int id;
	private String username;
	

//constructors
	protected User() {
	}

	public User(int id,String username) {
		super();
		if(id<=0)
			throw new IllegalArgumentException("ID has to be greater than 0");
		
		this.id = id;
		this.username = username;
	}

//setters
	
	  public void setId(int id) {
		  this.id = id;
		  } 
	  
	  public void setUsername(String
			  username) { this.username = username; }
	 

	//getters
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username+ "]";
	}

}

