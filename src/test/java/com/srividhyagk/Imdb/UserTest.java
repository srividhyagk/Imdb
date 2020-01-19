package com.srividhyagk.Imdb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

class UserTest {
@MockBean
private User user1=new User(1,"Appleman");
private User user2=new User(10,"Benjamin");
	@Test
	void testUser() {
		assertEquals(user1,user1);
		assertEquals(user2,user2);
	}

	@Test
	void testSetId() {
		user1.setId(2);
		assertEquals(2,user1.getId());
	}

	@Test
	void testSetUsername() {
		user1.setUsername("Angryman");
		assertEquals("Angryman",user1.getUsername());
	}

	@Test
	void testGetId() {
		assertEquals(1,user1.getId());
	}

	@Test
	void testGetUsername() {
		assertEquals("Appleman",user1.getUsername());

	}

	@Test
	void testToString() {
		assertEquals("User [id=" + user1.getId() + ", username=" + user1.getUsername()+ "]",user1.toString());
	}

}
