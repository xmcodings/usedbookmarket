package model;

import java.util.Calendar;
import java.util.Date;


public class Book implements Comparable<Book>{

	private String title;
	private String author;
	private String publishYear;
	private Date registerDate;
	private static int bookTotalNum = 0;
	private String publisher;
	private String ISBN;
	private int price;
	private int bookNum;
	private String priceString;
	private String genre;
	private char status; // 3 book status : a : Excellent, b : Good c : Fair 
	private PublicUser registerUser;
	

	public Book(String title, String author, String isbn, String publishyear, String publisher,int price, char status, PublicUser user) {
		setTitle(title);
		setAuthor(author);
		this.registerUser = user;
		setISBN(isbn);
		setPublishYear(publishyear);
		setPublisher(publisher);
		setStatus(status);
		setPriceString(price);
		bookNum = bookTotalNum;
		bookTotalNum++;
		
		this.registerDate = Calendar.getInstance().getTime();
	}
	
	public Book(Book b) {
		setTitle(b.getTitle());
		setAuthor(b.getAuthor());
		this.registerUser = b.getRegisterUser();
		setISBN(b.getISBN());
		setPublisher(b.getPublisher());
		setPublishYear(b.getPublishYear());
		setStatus(b.getStatusChar());
		setPriceString(b.getPrice());
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
	public char getStatusChar() {
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

	//returns price as string(includes not defined)
	public String getPriceString() {
		return priceString;
	}
	
	// sets price as string. saves not defined if less than 0
	public void setPriceString(int price) {
		if(price < 0) {
			this.priceString = "Not Defined";
		}
		else {
			priceString = Integer.toString(price);
			this.price = price;
		}

	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public int getBookNum() {
		return bookNum;
	}
	
	public PublicUser getRegisterUser() {
		return registerUser;
	}
	
	// default sort
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return getRegisterDate().compareTo(o.getRegisterDate());
	}
	
	
	
}
