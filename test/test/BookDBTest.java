package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Book;
import model.PublicUser;
import model.BookDB;



class BookDBTest {


	PublicUser testuser1;
	PublicUser testuser2;
	BookDB testbooks;

	@BeforeEach
	void setUp() throws Exception {
		testbooks = new BookDB();
		testuser1 = new PublicUser("test1", "test1", "testname1", "01044441", "mk1@gm.co");
		testuser2 = new PublicUser("test2", "test2", "testname2", "01044442", "mk2@gm.co");
		for(int i = 0; i < 10; i++) {
			testbooks.addBook(new Book("title"+i, "author" + i, "15-"+i, "200"+i, "pub" + i, i*50, 'a', testuser1));
		}
		for(int i = 10; i < 20; i++) {
			testbooks.addBook(new Book("title"+i, "author" + i, "15-"+i, "20"+i, "pub" + i, i*50, 'b', testuser2));
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testAddBook() {
		for(int i = 0; i < testbooks.getBookData().size(); i++) {
			if(i < 10) {
				assertEquals("title"+i, testbooks.getBookData().get(i).getTitle());
				assertEquals("author"+i, testbooks.getBookData().get(i).getAuthor());
				assertEquals("15-"+i, testbooks.getBookData().get(i).getISBN());
				assertEquals("pub"+i, testbooks.getBookData().get(i).getPublisher());
				assertEquals("test1", testbooks.getBookData().get(i).getRegisterUserId());
			}
			if(i >= 10 && i < 20) {
				assertEquals("test2", testbooks.getBookData().get(i).getRegisterUserId());
			}
		}
	}
	
	@Test
	void testTitleSearch() {
		testbooks.searchTitle("title5");
		assertEquals("title5", testbooks.getSearchResult().get(0).getTitle());
	}
	@Test
	void testAuthorSearch() {
		testbooks.searchAuthor("author4");
		assertEquals(testbooks.getSearchResult().get(0).getAuthor(), "author4");
	}
	@Test
	void testPublisherSearch() {
		testbooks.searchPublisher("pub12");
		assertEquals(testbooks.getSearchResult().get(0).getPublisher(), "pub12");
	}
	@Test
	void testISBNSearch() {
		testbooks.searchISBN("15-13");
		assertEquals(testbooks.getSearchResult().get(0).getISBN(), "15-13");
	}
	@Test
	void testYearSearch() {
		testbooks.searchYear("200");
		assertEquals(testbooks.getSearchResult().get(0).getPublishYear(), "2000");
		assertEquals(testbooks.getSearchResult().size(), 10); // 2000~2009 => 10
	}
	@Test
	void testSellerSearch() {
		testbooks.searchSeller("test1");
		assertEquals(testbooks.getSearchResult().get(0).getRegisterUserId(), "test1");
		assertEquals(testbooks.getSearchResult().size(), 10);
	}
	
	@Test
	void testEditBook() {
		// editing books registered by "test1" user
		testbooks.searchSeller("test1");
		Book edit = new Book("edittitle", "editauthor", "19-1515", "1500", "editpub", 4000, 'c', testuser1);
		testbooks.editBook(3, edit);
		
		assertEquals(testbooks.getSearchResult().get(3).getTitle(), "edittitle");
		assertEquals(testbooks.getSearchResult().get(3).getAuthor(), "editauthor");
		assertEquals(testbooks.getSearchResult().get(3).getISBN(), "19-1515");
		assertEquals(testbooks.getSearchResult().get(3).getPublishYear(), "1500");
		assertEquals(testbooks.getSearchResult().get(3).getPublisher(), "editpub");
		assertEquals(testbooks.getSearchResult().get(3).getPriceString(), "4000");
		assertEquals(testbooks.getSearchResult().get(3).getRegisterUserId(), "test1");
	}
	@Test
	void testRemoveBook() {
		
		int beforeSize = testbooks.getBookData().size();
		
		testbooks.searchSeller("test1");
		Book toRemove = testbooks.getSearchResult().get(4);
		testbooks.removeBook(toRemove);
		int afterSize = testbooks.getBookData().size();
		assertEquals(afterSize, beforeSize-1); // size - 1
	}
	
	
}
