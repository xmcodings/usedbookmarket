package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Admin;
import model.BookItem;
import model.BookDB;
import model.BookOrder;
import model.PublicUser;
import model.TransactionHistory;
import model.UserDB;

class TransactionHistoryTest {

	UserDB testusers;
	BookDB testbooks;
	TransactionHistory transactions;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		testusers = new UserDB();		
		testbooks = new BookDB();
		transactions = new TransactionHistory();
		
		for(int i = 0; i < 3; i++) {
			testusers.addUserData(new PublicUser("testid"+i, "pass"+i, "name"+i, "0100000000"+i, "test"+i+"@lolqna.co.kr"));
		}
		for(int i = 0; i < 3; i++) {
			testbooks.addBook(new BookItem("title"+i, "author" + i, "15-"+i, "200"+i, "pub" + i, i*50, 'a', testusers.getPublicUserdata().get(i)));
		}
		
		BookOrder bo0 = new BookOrder(testbooks.getBookData().get(0), testusers.getPublicUserdata().get(1)); // testuser 1 ordered title0 book from testuser 0
		BookOrder bo1 = new BookOrder(testbooks.getBookData().get(0), testusers.getPublicUserdata().get(2)); // testuser 2 ordered title0 book from testuser 0

		transactions.addBookOrder(bo0);
		transactions.addBookOrder(bo1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void addBookOrderTest() {
		int beforeAdd = transactions.getBookOrders().size();
		BookOrder newOrder = new BookOrder(testbooks.getBookData().get(1), testusers.getPublicUserdata().get(0)); // testuser 0 ordered title1 book from testuser 1
		transactions.addBookOrder(newOrder);
		int afterAdd = transactions.getBookOrders().size();
		assertEquals(beforeAdd+1, afterAdd);
	}
	
	@Test
	void removeTransactionTest() {
		int beforeAdd = transactions.getBookOrders().size();
		BookItem toRemove = testbooks.getBookData().get(0);
		transactions.removeTransaction(toRemove); // 2 transactions should be removed!!
		int afterAdd = transactions.getBookOrders().size();
		
		assertEquals(beforeAdd-2, afterAdd); // -2 size
	}
	
	@Test
	void searchSellerTest() {
		// 2 book orders for testuser 0 exists
		// search testuser0 in book order
		
		transactions.searchTransactionSellerID("testid0");
		
		int searchItemElements = transactions.getSellerBookOrder().size();
		assertEquals(2, searchItemElements);
	}
	
	
	
	
}
