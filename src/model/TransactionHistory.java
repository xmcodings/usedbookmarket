package model;

import java.util.ArrayList;

public class TransactionHistory {

	private ArrayList<BookOrder> bookOrders;
	private ArrayList<BookOrder> searchedBuyerBookOrders;
	private ArrayList<BookOrder> searchedSellerBookOrders;
	
	
	public TransactionHistory() {
		bookOrders = new ArrayList<BookOrder>();
		searchedSellerBookOrders = new ArrayList<BookOrder>();
		searchedBuyerBookOrders = new ArrayList<BookOrder>();
		
		
	}

	public ArrayList<BookOrder> getBookOrders() {
		return bookOrders;
	}

	public void addBookOrder(BookOrder b) {
		bookOrders.add(b);
	}
	
	public void removeTransaction(Book rm) {
		int index = 0;
		int arraySize = bookOrders.size();
		while(true) {
			if(bookOrders.get(index).getBook().equals(rm)) {
				bookOrders.remove(index);
				arraySize--;
			}
			else {
				index++;
			}
			if(index == arraySize) {
				break;
			}
		}
	}
	
	public void searchTransactionBuyerID(String buyerID) {
		searchedBuyerBookOrders.clear();
		for(BookOrder bo : bookOrders) {
			if(bo.getBuyerID().equals(buyerID)) {
				searchedBuyerBookOrders.add(bo);			
			}
		}
	}
	public void searchTransactionSellerID(String sellerID) {
		searchedSellerBookOrders.clear();
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
