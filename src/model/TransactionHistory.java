package model;

import java.util.ArrayList;

public class TransactionHistory {

	private ArrayList<BookOrder> bookOrders;
	private ArrayList<BookOrder> searchedBuyerBookOrders;
	private ArrayList<BookOrder> searchedSellerBookOrders;
	
	
	public TransactionHistory() {
		bookOrders = new ArrayList<BookOrder>();
		
		
		
	}

	public ArrayList<BookOrder> getBookOrders() {
		return bookOrders;
	}

	public void setBookOrders(ArrayList<BookOrder> bookOrders) {
		this.bookOrders = bookOrders;
	}
	public void addBookOrder(BookOrder b) {
		bookOrders.add(b);
	}
	
	public void removeTransaction(Book rm) {
		for(BookOrder bo : bookOrders) {
			if(bo.getBook().equals(rm)) {
				bookOrders.remove(bo);
			}
		}
	}
	
	public void searchTransactionBuyerID(String buyerID) {
		for(BookOrder bo : bookOrders) {
			if(bo.getBuyerID().equals(buyerID)) {
				searchedBuyerBookOrders.add(bo);			
			}
		}
	}
	public void searchTransactionSellerID(String sellerID) {
		for(BookOrder bo : bookOrders) {
			if(bo.getSellerID().equals(sellerID)) {
				searchedSellerBookOrders.add(bo);			
			}
		}
	}
	
	public ArrayList<BookOrder> getBuyerBookOrder(){
		return searchedBuyerBookOrders;
	}
	public ArrayList<BookOrder> getSellerBookOrder(){
		return searchedSellerBookOrders;
	}	
	
}
