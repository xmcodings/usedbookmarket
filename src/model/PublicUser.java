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
	
	public void addToRegisterList(int index, Book b) {
		Pair<Integer, Book> newBook = new Pair<Integer, Book>(index,b);
		//registeredBooks.add(newBook);
	}
	public void editRegisterListBook(int index, Book b) {
		//Book editBook = registeredBooks.get(index).getValue();
		//		editBook.setTitle(b.getTitle());
		//editBook.setAuthor(b.getAuthor());
		//editBook.setISBN(b.getISBN());
		//editBook.setPublishYear(b.getPublishYear());		
		//editBook.setPublisher(b.getPublisher());
		//editBook.setStatus(b.getStatusChar());
		//editBook.setPriceString(b.getPrice());
	}
	public void removeRegisterListBook(int index) {
		//registeredBooks.remove(index);
	}
	
	public ArrayList<Book> getRegisteredBook(){
		ArrayList<Book> regBook = new ArrayList<Book>();
		//for(Pair<Integer, Book> b : registeredBooks) {
		//	regBook.add(b.getValue());			
		//}
		return regBook;
	}
	
}
