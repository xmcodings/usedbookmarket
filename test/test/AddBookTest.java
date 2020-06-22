package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.MainController;
import model.Book;
import model.PublicUser;




class AddBookTest {

	Book s;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		s = new Book("title", "author", "isbn1234", "1234", "jpus", 5000, 'b', new PublicUser("ijk", "pass", "name", "01044441", "mk@gm.co"));
//		testuser = new PublicUser("ijk", "pass", "name", "01044441", "mk@gm.co");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddBook() {
		assertEquals(s.getTitle(), "title");
		assertEquals(s.getAuthor(), "author");
		assertEquals(s.getISBN(), "isbn1234");
		assertEquals(s.getPublisher(), "jpus");
	}

}
