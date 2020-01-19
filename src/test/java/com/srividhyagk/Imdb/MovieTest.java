package com.srividhyagk.Imdb;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

class MovieTest {
	@MockBean 
	private Movie movie;
	private Movie movie2;

	@Test
	void test() {
		//fail("Not yet implemented");
		movie=new Movie(1,"Angry Birds","PG");
		movie2=new Movie(2,"Angry Birds II","PG");
		assertEquals("Angry Birds",movie.getTitle());
		assertEquals(1,movie.getId());
		assertEquals(2,movie2.getId());
		assertEquals("PG",movie.getCategory());
		
	}

}
