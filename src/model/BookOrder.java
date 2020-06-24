package model;

public class BookOrder {

	private BookItem transactionBook;
	private PublicUser BuyUser;
	
	
	public BookOrder(BookItem transBook, PublicUser buyUser) {
		this.setTransactionBook(transBook);
		this.setBuyUser(buyUser);	
	}


	public BookItem getTransactionBook() {
		return transactionBook;
	}


	public void setTransactionBook(BookItem transactionBook) {
		this.transactionBook = transactionBook;
	}


	public PublicUser getBuyUser() {
		return BuyUser;
	}


	public void setBuyUser(PublicUser buyUser) {
		BuyUser = buyUser;
	}
	public BookItem getBook() {
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
