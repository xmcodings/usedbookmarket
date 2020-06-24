package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.BookItem;
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
			testbooks.addBook(new BookItem("title"+i, "author" + i, "15-"+i, "200"+i, "pub" + i, i*50, 'a', testuser1));
		}
		for(int i = 10; i < 20; i++) {
			testbooks.addBook(new BookItem("title"+i, "author" + i, "15-"+i, "20"+i, "pub" + i, i*50, 'b', testuser2));
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
		assertEquals("author4", testbooks.getSearchResult().get(0).getAuthor());
	}
	@Test
	void testPublisherSearch() {
		testbooks.searchPublisher("pub12");
		assertEquals("pub12", testbooks.getSearchResult().get(0).getPublisher());
	}
	@Test
	void testISBNSearch() {
		testbooks.searchISBN("15-13");
		assertEquals("15-13", testbooks.getSearchResult().get(0).getISBN());
	}
	@Test
	void testYearSearch() {
		testbooks.searchYear("200");
		assertEquals("2000", testbooks.getSearchResult().get(0).getPublishYear());
		assertEquals(10, testbooks.getSearchResult().size()); // 2000~2009 => 10
	}
	@Test
	void testSellerSearch() {
		testbooks.searchSeller("test1");
		assertEquals("test1", testbooks.getSearchResult().get(0).getRegisterUserId());
		assertEquals(10, testbooks.getSearchResult().size());
	}
	
	@Test
	void testEditBook() {
		// editing books registered by "test1" user
		testbooks.searchSeller("test1");
		BookItem edit = new BookItem("edittitle", "editauthor", "19-1515", "1500", "editpub", 4000, 'c', testuser1);
		testbooks.editBook(3, edit);
		
		assertEquals("edittitle", testbooks.getSearchResult().get(3).getTitle());
		assertEquals("editauthor", testbooks.getSearchResult().get(3).getAuthor());   
		assertEquals("19-1515", testbooks.getSearchResult().get(3).getISBN());        
		assertEquals("1500", testbooks.getSearchResult().get(3).getPublishYear());    
		assertEquals("editpub", testbooks.getSearchResult().get(3).getPublisher());   
		assertEquals("4000", testbooks.getSearchResult().get(3).getPriceString());    
		assertEquals("test1", testbooks.getSearchResult().get(3).getRegisterUserId());
	}
	@Test
	void testRemoveBook() {
		
		int beforeSize = testbooks.getBookData().size();
		
		testbooks.searchSeller("test1");
		BookItem toRemove = testbooks.getSearchResult().get(4);
		testbooks.removeBook(toRemove);
		int afterSize = testbooks.getBookData().size();
		assertEquals(beforeSize-1, afterSize); // size - 1
	}
	
	
}
