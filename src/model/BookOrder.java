package model;

public class BookOrder {

	private Book transactionBook;
	private PublicUser BuyUser;
	
	
	public BookOrder(Book transBook, PublicUser buyUser) {
		this.setTransactionBook(transBook);
		this.setBuyUser(buyUser);	
	}


	public Book getTransactionBook() {
		return transactionBook;
	}


	public void setTransactionBook(Book transactionBook) {
		this.transactionBook = transactionBook;
	}


	public PublicUser getBuyUser() {
		return BuyUser;
	}


	public void setBuyUser(PublicUser buyUser) {
		BuyUser = buyUser;
	}
	public Book getBook() {
		return transactionBook;
	}
	public String getBookTitle() {
		return transactionBook.getTitle();
	}
	
	public String getBuyerID() {
		return BuyUser.getUserID();
	}
	
	public String getSellerID() {
		return transactionBook.getRegisterUserId();
	}
	public String getBookPrice() {
		return transactionBook.getPriceString();
	}
	
	
	
	
}
