package model;

import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class BookDB implements Observable{

	
	ArrayList<Book> bookdata = new ArrayList<Book>();
	ArrayList<Book> searchResult = new ArrayList<Book>();
	ArrayList<Book> recentList = new ArrayList<Book>();
	
	public BookDB() {
		
	}
	
	
	public ArrayList<Book> getSearchResult() {
		return searchResult;
	}
	
	public void searchTitle(String searchText) {
		
		searchResult.clear();
		for(Book book : bookdata) {
			if(book.getTitle().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
	
	
	public void searchAuthor(String searchText) {
			
		searchResult.clear();
		for(Book book : bookdata) {
			if(book.getAuthor().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
		
	public void searchISBN(String searchText) {
		
		searchResult.clear();
		for(Book book : bookdata) {
			if(book.getISBN().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
	
	public void searchSeller(String searchText) {
		
		searchResult.clear();
		for(Book book : bookdata) {
			if(book.getRegisterUserId().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
	
	public void addBook(Book b) {
		bookdata.add(b);
		addToRecentBookList(b);
	}
	
	public void printBooks() {
		
		for(Book b: bookdata) {
			System.out.println("book " + b.getTitle() + ", " + b.getAuthor() + ", " + b.getISBN() + ", " + b.getStatus() + ", " + b.getRegisterUserId() + ", " + b.getRegisterDate());
		}
	}
	
	private void addToRecentBookList(Book b) {
		if(recentList.size() > 5) {
			recentList.remove(0);
		}
		recentList.add(b);
	}
	public ArrayList<Book> getRecentBookList(){
		return recentList;
	}
	
	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
