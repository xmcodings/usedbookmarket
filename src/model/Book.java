package model;

import java.util.Calendar;


public class Book {

	private String title;
	private String author;
	private Calendar publishDate;
	private Calendar registerDate;
	private String publisher;
	private int price;
	private String genre;
	private char status; // 3 book status : a : Excellent, b : Good c : Fair 
	
	
	public Book() {
		
	}
	public Book(String title) {
		super();
		this.title = title;
	}
	public Book(String title, String author) {
		super();
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishDate() {
		
		String date;
		date = publishDate.get(Calendar.YEAR) + "/" + publishDate.get(Calendar.MONTH) + "/" + publishDate.get(Calendar.DATE);
		return date;
	}
	
	public void setPublishDate(Calendar publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public char getStatus() {
		return status;
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

	public Calendar getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Calendar registerDate) {
		this.registerDate = registerDate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	
	
	
	
}
