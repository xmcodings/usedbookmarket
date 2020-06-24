package model;

import java.util.ArrayList;

import javafx.util.Pair;

public class PublicUser extends User{
	
	private String userName;
	private String userPhoneNum;
	private String userEmail;
	private boolean isActivated;
	
	//private ArrayList<Pair<Integer, Book>> registeredBooks;
	
	public PublicUser (String id, String pass, String name, String phoneNum, String email) {
		
		this.setUserID(id);
		this.setUserPassword(pass);
		this.setUserName(name);
		this.setUserPhoneNum(phoneNum);
		this.setUserEmail(email);
		this.isAdmin = false;
		this.isActivated = true;
		//registeredBooks = new ArrayList<Pair<Integer, Book>>();
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
	
	public void toggleActivation() {
		if(isActivated) {
			isActivated = false;
		}
		else {
			isActivated = true;
		}
	}
	
	public boolean getActivationStatus() {
		return isActivated;
	}
	
	public ArrayList<BookItem> getRegisteredBook(){
		ArrayList<BookItem> regBook = new ArrayList<BookItem>();
		
		
		return regBook;
	}
	
}
