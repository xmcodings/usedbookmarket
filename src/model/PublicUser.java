package model;

import java.util.ArrayList;

public class PublicUser extends User{
	
	private String userName;
	private String userPhoneNum;
	private String userEmail;
	
	private ArrayList<Book> registeredBooks;
	
	public PublicUser (String id, String pass, String name, String phoneNum, String email) {
		
		this.setUserID(id);
		this.setUserPassword(pass);
		this.setUserName(name);
		this.setUserPhoneNum(phoneNum);
		this.setUserEmail(email);
		this.isAdmin = false;
		registeredBooks = new ArrayList<Book>();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneNum() {
		return userPhoneNum;
	}


	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public void addToRegisterList(Book b) {
		registeredBooks.add(b);
	}

	public ArrayList<Book> getRegisteredBook(){
		return registeredBooks;
	}
	
	
	
}
