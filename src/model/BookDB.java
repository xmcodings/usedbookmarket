package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class BookDB implements Observable{

	
	ArrayList<Book> bookdata = new ArrayList<Book>();
	ArrayList<Book> searchResult = new ArrayList<Book>();
	ArrayList<Book> recentList = new ArrayList<Book>();
	
	public BookDB() {
		
	}
	public BookDB(String filename) {
		PublicUser dummy = new PublicUser("dummy", "dummy", "dummy", "0000000", "dummy@d.d");
		BufferedReader br = null;
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println("retrieving Directory = " + filename);
		try {
	            br = new BufferedReader(new FileReader(filename));
	            String line;
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] bookData = line.split(",");
	                addBook(new Book(bookData[0], bookData[1], bookData[2], bookData[3], bookData[4], Integer.parseInt(bookData[5]), bookData[6].charAt(0),
	                		dummy));
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
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
	public void searchYear(String searchText) {
		
		searchResult.clear();
		for(Book book : bookdata) {
			if(book.getPublishYear().contains(searchText)) {
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
