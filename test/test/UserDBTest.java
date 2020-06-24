package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Admin;
import model.Book;
import model.PublicUser;
import model.UserDB;

class UserDBTest {

	UserDB testusers;
	
	@BeforeEach
	void setUp() throws Exception {
		
		testusers = new UserDB();		
		testusers.addUserData(new Admin("admin", "nayana")); // add admin
		
		for(int i = 0; i < 10; i++) {
			testusers.addUserData(new PublicUser("testid"+i, "pass"+i, "name"+i, "0100000000"+i, "test"+i+"@lolqna.co.kr"));
		} // add PublicUsers
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddUser() {
	
		for(int i = 0; i < testusers.getPublicUserdata().size(); i++) {
			assertEquals("testid"+i, testusers.getPublicUserdata().get(i).getUserID());
			assertEquals(testusers.getPublicUserdata().get(i).getUserPassword(), "pass"+i);
		}
		
		for(int i = 0; i < testusers.getAdminUserdata().size(); i++) {
			assertEquals(testusers.getAdminUserdata().get(i).getUserID(), "admin");
		}
	}
	
	@Test
	void testCheckDuplicate() {
		
		PublicUser yesduple = new PublicUser("testid1", "pass", "name", "0100000000", "test1@lolqna.co.kr");
		PublicUser noduple = new PublicUser("nodupleid", "pass", "name", "0100000000", "test1@lolqna.co.kr");
		
		boolean yesduplevalue = testusers.checkDuplicate(yesduple);
		boolean noduplevalue = testusers.checkDuplicate(noduple);
		
		assertEquals(false, yesduplevalue);
		assertEquals(true, noduplevalue);
	}
	
	@Test
	void testLoginAuth() {
		int yeslogin = testusers.loginAuth("testid1", "pass1");
		int yesadmin = testusers.loginAuth("admin", "nayana");
		int nologin = testusers.loginAuth("noid", "nopass");
		
		assertEquals(1, yeslogin);
		assertEquals(2, yesadmin);
		assertEquals(0, nologin);
		
	}
	
	@Test
	void testLoginUser() {
		testusers.loginAuth("testid1", "pass1");
		String loginUserId = testusers.getLoginUser().getUserID();
		assertEquals("testid1", loginUserId);
		testusers.loginAuth("admin", "nayana");
		String loginAdminUserPassword = testusers.getLoginUser().getUserPassword();
		assertEquals("nayana",loginAdminUserPassword);
	}
	
	@Test
	void testToggleUserActivation() {
		
		PublicUser randomUser = testusers.getPublicUserdata().get(3); 
		
		boolean beforeToggle = randomUser.getActivationStatus(); // default toggle
		testusers.toggleUserActivation(randomUser);
		boolean afterToggle = randomUser.getActivationStatus();  // after toggle
		testusers.toggleUserActivation(randomUser);
		boolean after2Toggle = randomUser.getActivationStatus();  // after toggle x 2
		
		assertEquals(true, beforeToggle);
		assertEquals(false, afterToggle);
		assertEquals(true, after2Toggle);
	}
	
	@Test
	void testDeleteUser() {
		
		PublicUser randomUser = testusers.getPublicUserdata().get(5);
		
		boolean deleteFail = testusers.deleteUser(randomUser);
		testusers.toggleUserActivation(randomUser);
		boolean deleteSuccess = testusers.deleteUser(randomUser);
		
		assertEquals(false, deleteFail);
		assertEquals(true, deleteSuccess);
	}
	
	
	
	
}
