package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class BookDB{

	
	ArrayList<Book> bookdata = new ArrayList<Book>();
	ArrayList<Book> searchResult = new ArrayList<Book>();
	private final PropertyChangeSupport support = new PropertyChangeSupport(this);
	
	
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
	}
	public void editBook(int index, Book b) {
		Book editBook = bookdata.get(index);
		editBook.setTitle(b.getTitle());
		editBook.setAuthor(b.getAuthor());
		editBook.setISBN(b.getISBN());
		editBook.setPublishYear(b.getPublishYear());		
		editBook.setPublisher(b.getPublisher());
		editBook.setStatus(b.getStatusChar());
		editBook.setPriceString(b.getPrice());
	}
	
	
	public void printBooks() {
		
		for(Book b: bookdata) {
			System.out.println("book " + b.getTitle() + ", " + b.getAuthor() + ", " + b.getISBN() + ", " + b.getStatus() + ", " + b.getRegisterUserId() + ", " + b.getRegisterDate());
		}
	}
	
	private void makeRecentBookList() {

		searchResult.clear();
		for(int i = bookdata.size()-1; i > bookdata.size()-6; i--) {
			searchResult.add(bookdata.get(i));
		}
		Collections.sort(searchResult);
	}
	
	public ArrayList<Book> getRecentBookList() {
		makeRecentBookList();
		return searchResult;
	}
	public ArrayList<Book> getSortByDate(ArrayList<Book> toSortArray) {
		
		ArrayList<Book> temp = toSortArray;
		Collections.sort(temp);
		return temp;
	}
	
	public void removeBook(int index) {
		ArrayList<Book> oldList = new ArrayList<Book>(bookdata);
		bookdata.remove(index);
		support.firePropertyChange("remove book", oldList, bookdata);
		updateBookIndex();
	}
	private void updateBookIndex() {
		for (int i = 0; i < bookdata.size(); i++) {
			bookdata.get(i).setBookNum(i);
		}
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.removePropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
	
}
