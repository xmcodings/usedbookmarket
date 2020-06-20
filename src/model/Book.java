package model;

import java.util.Calendar;
import java.util.Date;


public class Book {

	private String title;
	private String author;
	private String publishYear;
	private Date registerDate;
	
	private String publisher;
	private String ISBN;
	private int price;
	private String priceString;
	private String genre;
	private char status; // 3 book status : a : Excellent, b : Good c : Fair 
	private PublicUser registerUser;
	

	public Book(String title, String author, String isbn, String publishyear, String publisher,int price, char status, PublicUser user) {
		setTitle(title);
		setAuthor(author);
		this.registerUser = user;
		setISBN(isbn);
		setPrice(price);
		setPublishYear(publishyear);
		setPublisher(publisher);
		setStatus(status);
		setPriceString(price);
		
		this.registerDate = Calendar.getInstance().getTime();
	}
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		if(author.isEmpty()) {
			this.author = "not defined";
		}
		else {
			this.author = author;
		}
	}
	public String getPublishYear() {
		return publishYear;
	}
	
	public void setPublishYear(String publishYear) {
		if(publishYear.isEmpty()) {
			this.publishYear = "not defined";
		}
		else {
			this.publishYear = publishYear;			
		}

	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		if(publisher.isEmpty()) {
			this.publisher = "not defined";
		}
		else {
			this.publisher = publisher;	
		}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		if(status == 'a') {
			return "Excellent";
		}
		else if(status == 'b') {
			return "Good";
		}
		else if(status == 'c') {
			return "Fair";
		}
		else {
			return "Not Defined";
		}
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegisterDate() {
		
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		if(iSBN.isEmpty()) {
			this.ISBN = "not defined";
		}
		else {
			this.ISBN = iSBN;			
		}
	}
	
	public String getRegisterUserId() {
		return registerUser.getUserID();
	}
	public String getRegisterUserEmail() {
		return registerUser.getUserEmail();
	}

	public String getPriceString() {
		return priceString;
	}
	
	public void setPriceString(int price) {
		if(price < 0) {
			this.priceString = "Not Defined";
		}
		else {
			priceString = Integer.toString(price);
		}

	}
}
