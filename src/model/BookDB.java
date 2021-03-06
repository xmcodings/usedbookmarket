package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BookDB{

	
	ArrayList<BookItem> bookdata = new ArrayList<BookItem>();
	ArrayList<BookItem> searchResult = new ArrayList<BookItem>();
	private PropertyChangeSupport support = new PropertyChangeSupport(this);
	
	public BookDB() {
		
	}
	public BookDB(String filename, UserDB marketUser) {
		
		BufferedReader br = null;
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println("retrieving Directory = " + filename);
		try {
	            br = new BufferedReader(new FileReader(filename));
	            String line;
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	            	String[] bookData = line.split(",");
	                for(User u: marketUser.getAllUserdata()) {
	                	if(u.getUserID().equals(bookData[7])) {
	                		addBook(new BookItem(bookData[0], bookData[1], bookData[2], bookData[3], bookData[4], Integer.parseInt(bookData[5]), bookData[6].charAt(0), (PublicUser)u));
	                	}
	                }
	            	
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
	
	public ArrayList<BookItem> getSearchResult() {
		return searchResult;
	}
	
	public void searchTitle(String searchText) {
		
		searchResult.clear();
		for(BookItem book : bookdata) {
			if(book.getTitle().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
	
	public void searchAuthor(String searchText) {		
		searchResult.clear();
		for(BookItem book : bookdata) {
			if(book.getAuthor().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
		
	public void searchISBN(String searchText) {
		
		searchResult.clear();
		for(BookItem book : bookdata) {
			if(book.getISBN().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
	public void searchYear(String searchText) {
		
		searchResult.clear();
		for(BookItem book : bookdata) {
			if(book.getPublishYear().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
	public void searchPublisher(String searchText) {
		
		searchResult.clear();
		for(BookItem book : bookdata) {
			if(book.getPublisher().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
	
	public void searchSeller(String searchText) {
		
		searchResult.clear();
		for(BookItem book : bookdata) {
			if(book.getRegisterUserId().contains(searchText)) {
				searchResult.add(book);
			}
		}
	}
	
	public void addBook(BookItem b) {
		bookdata.add(b);
		makeRecentBookList();
		//support.firePropertyChange("addBook", oldList, bookdata);
	}
	public void editBook(int index, BookItem b) {
		ArrayList<BookItem> oldList = new ArrayList<BookItem>(searchResult);
		BookItem editBook = searchResult.get(index);
		editBook.setTitle(b.getTitle());
		editBook.setAuthor(b.getAuthor());
		editBook.setISBN(b.getISBN());
		editBook.setPublishYear(b.getPublishYear());		
		editBook.setPublisher(b.getPublisher());
		editBook.setStatus(b.getStatusChar());
		editBook.setPriceString(b.getPrice());
		support.firePropertyChange("editBook", oldList, editBook);
	}
	
	public ArrayList<BookItem> getBookData(){

		return bookdata;
	}
	
	public void printBooks() {
		
		for(BookItem b: bookdata) {
			System.out.println("book " + b.getTitle() + ", " + b.getAuthor() + ", " + b.getISBN() + ", " + b.getStatus() + ", " + b.getRegisterUserId() + ", " + b.getRegisterDate());
		}
	}
	
	private void makeRecentBookList() {
		ArrayList<BookItem> oldList = new ArrayList<BookItem>(searchResult);
		searchResult.clear();
		
		for(int i = bookdata.size()-1; i > bookdata.size()-6; i--) {
			if(i < 0) {
				break;
			}
			searchResult.add(bookdata.get(i));
		}
		Collections.sort(searchResult);
		
		support.firePropertyChange("recentBookChange", oldList, searchResult);
	}
	
	public ArrayList<BookItem> getRecentBookList() {
		makeRecentBookList();
		return searchResult;
	}
	public ArrayList<BookItem> getSortByDate(ArrayList<BookItem> toSortArray) {
		
		ArrayList<BookItem> temp = toSortArray;
		Collections.sort(temp);
		return temp;
	}
	
	public void removeBook(BookItem b) {
		ArrayList<BookItem> oldList = new ArrayList<BookItem>(searchResult);
		bookdata.remove(b);
		searchResult.remove(b);
		
		support.firePropertyChange("removeBook", oldList, searchResult);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
	
}
