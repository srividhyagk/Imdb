package com.srividhyagk.Imdb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ImdbApplicationTests {
@Autowired
ReviewController reviewcontroller;
@MockBean
ReviewRepository reviewrepo;

@Test
public void addNewReviewTest()
{
	//Reviews r=new Reviews(100, "Test Comment1", 4, new Movie(1,"Test Movie","PG"), 1, new User(15,"Zebra"), 15);
	when(((ReviewController) reviewrepo).addNewReview(1,15,"Test Comment1", 4)).thenReturn("Saved Review");
	assertEquals("Saved Review",((ReviewController) reviewrepo).addNewReview(1,15,"Test Comment1", 4));
	
}
/*@Before
public void setup()
{
	
        MockitoAnnotations.initMocks(this);
   
}*/

	@Test
	public void getAllReviewsTest()
	{
		int s=0;
		List<Reviews> test=new ArrayList<>();
		test.add(new Reviews(100, "Test Comment1", 4, new Movie(1,"Test Movie","PG"), 1, new User(15,"Zebra"), 15));
		test.add(new Reviews(101, "Test Comment2", 5, new Movie(2,"Test Movie2","PG-13"), 2, new User(14,"Yoyo"), 14));
		when(reviewrepo. findAll()).thenReturn(test);
		if(reviewrepo.findAll() instanceof Collection)
		{
			s=((Collection<Reviews>)reviewrepo.findAll()).size();
		}
			
	   assertEquals(2,s);
	
	}
}


