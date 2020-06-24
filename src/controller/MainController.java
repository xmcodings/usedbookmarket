package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Admin;
import model.Book;
import model.BookDB;
import model.BookOrder;
import model.PublicUser;
import model.TransactionHistory;
import model.User;
import model.UserDB;
import view.MainMenuGUI;

public class MainController {

	UserDB usedBookServiceUser; // = new UserDB();
	BookDB usedBook; // = new BookDB();
	MainMenuGUI mainMenu;
	User currentLoginUser;
	Book userTableSelectionBook = null;
	TransactionHistory orderHistory;
	int tableSelectIndex = -1;
	
	public MainController(MainMenuGUI view, UserDB userData, BookDB bookData, TransactionHistory markethistory) {
		this.mainMenu = view;
		this.usedBookServiceUser = userData;
		this.usedBook = bookData;
		this.orderHistory = markethistory;
		
		// for main menu
		mainMenu.addLoginActionListener(new onClickLoginButton());
		mainMenu.addSignUpActionListener(new onClickSignUpButton());
		mainMenu.addRegisterActionListener(new onClickRegisterButton());
		
		// for user panel // 
		mainMenu.addSearchTitleActionListener(new onClickSearchTitleButton());
		mainMenu.addSearchAuthorActionListener(new onClickSearchAuthorButton());
		mainMenu.addSearchISBNActionListener(new onClickSearchISBNButton());
		mainMenu.addSearchSellerActionListener(new onClickSearchSellerButton());
		mainMenu.addSearchPublisherActionListener(new onClickSearchPublisherButton());
		mainMenu.addSearchYearActionListener(new onClickSearchYearButton());
		
		mainMenu.addLogOutActionListener(new onClickLogOutButton());
		
		mainMenu.addRegisterBookActionListener(new onClickRegisterBookButton());
		mainMenu.addMyRegisteredBookActionListener(new onClickMyRegisteredBookButton());
		mainMenu.addCurrentTransactionActionListener(new onClickMyTransactionButton());
		mainMenu.addMyProfileActionListener(new onClickMyProfileButton());
		mainMenu.addSellBookActionListener(new onClickSellBookButton());
		
		mainMenu.addBackActionListener(new onClickBackButton());
		mainMenu.addBuyBookActionListener(new onClickBuyBookButton());
		mainMenu.addSearchTableListener(new onListSelect());
		
		
		mainMenu.addMyRegisteredBookActionListener(new onClickMyRegisteredBookButton());
		mainMenu.addDeleteBookListener(new onClickDeleteBookButton());
		mainMenu.addEditBookListener(new onClickEditBookButton());
		mainMenu.addConfirmEditBookListener(new onClickConfirmEditBookButton());
		//for admins
		
		mainMenu.addManageUserListener(new onClickManageUserButton());
		mainMenu.addToggleUserActivationListener(new onClickToggleUserActivationButton());
		mainMenu.addDeleteUserListener(new onClickDeleteUserButton());
		
		usedBook.addPropertyChangeListener(mainMenu);
		usedBookServiceUser.addPropertyChangeListener(mainMenu);
		
		
		// for add book panel
		startProgram();
	}
	
	public void startProgram() {
		mainMenu.showMainLogin();
		
	}
	
	
	private boolean register(String id, String password, String name, String phoneNum, String email) {
		
		PublicUser user = new PublicUser(id, password, name, phoneNum, email);
		System.out.println("checking for duplicate");
		if(!usedBookServiceUser.checkDuplicate(user)) {
			return false; // fail duplicate test => same id exist
		}
		usedBookServiceUser.addUserData(user);
		System.out.println("register success");
		usedBookServiceUser.printUserList(); // for debugging purpose
		return true;
	}
	
	// 0: login fail, 1: user, 2: admin
	private int loginAuth(String id, String pass) {
		
		return usedBookServiceUser.loginAuth(id, pass);
	}
	
	// inner onclick event class
	
	class onClickLoginButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = mainMenu.getID();
			String pass = mainMenu.getPassword();
			if(loginAuth(id, pass) == 1) {
				System.out.println("login success");
				// should go to user view
				currentLoginUser = usedBookServiceUser.getLoginUser();
				System.out.println(currentLoginUser.getUserID());
				mainMenu.showUserMainPanel();
			}
			else if(loginAuth(id, pass) == 2)
			{
				System.out.println("login success <admin>");
				// should go to admin view
				currentLoginUser = usedBookServiceUser.getLoginUser();
				mainMenu.showAdminMainPanel();
			}
			else{ // login fail
				System.out.println("login fail");
				mainMenu.showLoginFailWarning();
			}

		}
	}
	class onClickSignUpButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainMenu.showSignUp();
		}
	}
	class onClickRegisterButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!(mainMenu.getID().isEmpty() && mainMenu.getPassword().isEmpty() && mainMenu.getName().isEmpty()
					&& mainMenu.getPhoneNum().isEmpty() && mainMenu.getEmail().isEmpty()))
			{
				if(register(mainMenu.getID(), mainMenu.getPassword(), mainMenu.getName(), mainMenu.getPhoneNum(), mainMenu.getEmail())) {
					// register success
					mainMenu.showUserSignUpSuccess();
					mainMenu.showMainLogin();
				}
				else {
					// duplicate id
				mainMenu.showDuplicateIDWarning();
				}
			}
			else {
				mainMenu.showGeneralNotification("Everything Should be Filled!");
			}
		}
	}
	
	class onClickSearchTitleButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String searchText = mainMenu.getSearchContext();
			if(searchText.isEmpty()) {
				mainMenu.showSearchTextEmptyWarning();
			}
			else {
				usedBook.searchTitle(searchText);
				if(currentLoginUser.getIsAdmin()) {
					mainMenu.showSearchResultAdminPanel();
				}
				else {
					mainMenu.showSearchResultPanel();				
				}
			}

		}
	}
	class onClickSearchAuthorButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String searchText = mainMenu.getSearchContext();
			if(searchText.isEmpty()) {
				mainMenu.showSearchTextEmptyWarning();
			}
			else {
				usedBook.searchAuthor(searchText);
				if(currentLoginUser.getIsAdmin()) {
					mainMenu.showSearchResultAdminPanel();
				}
				else {
					mainMenu.showSearchResultPanel();				
				}
			}
		}
	}
	class onClickSearchISBNButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String searchText = mainMenu.getSearchContext();
			if(searchText.isEmpty()) {
				mainMenu.showSearchTextEmptyWarning();
			}
			else {
				usedBook.searchISBN(searchText);
				if(currentLoginUser.getIsAdmin()) {
					mainMenu.showSearchResultAdminPanel();
				}
				else {
					mainMenu.showSearchResultPanel();				
				}
			}
		}
	}
	class onClickSearchSellerButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String searchText = mainMenu.getSearchContext();
			if(searchText.isEmpty()) {
				mainMenu.showSearchTextEmptyWarning();
			}
			else {
				usedBook.searchSeller(searchText);
				if(currentLoginUser.getIsAdmin()) {
					mainMenu.showSearchResultAdminPanel();
				}
				else {
					mainMenu.showSearchResultPanel();				
				}
			}
		}
	}
	
	class onClickSearchPublisherButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String searchText = mainMenu.getSearchContext();
			if(searchText.isEmpty()) {
				mainMenu.showSearchTextEmptyWarning();
			}
			else {
				usedBook.searchPublisher(searchText);
				if(currentLoginUser.getIsAdmin()) {
					mainMenu.showSearchResultAdminPanel();
				}
				else {
					mainMenu.showSearchResultPanel();				
				}
			}
		}
	}
	class onClickSearchYearButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String searchText = mainMenu.getSearchContext();
			if(searchText.isEmpty()) {
				mainMenu.showSearchTextEmptyWarning();
			}
			else {
				usedBook.searchYear(searchText);
				if(currentLoginUser.getIsAdmin()) {
					mainMenu.showSearchResultAdminPanel();
				}
				else {
					mainMenu.showSearchResultPanel();				
				}
			}
		}
	}
	
	class onClickRegisterBookButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainMenu.showRegisterBookPanel();	
		}
	}
	
	class onClickBuyBookButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(tableSelectIndex > -1) {
				if(mainMenu.showUserBuyConfirm() == 0) {
					userTableSelectionBook = usedBook.getSearchResult().get(tableSelectIndex);
					BookOrder bo = new BookOrder(userTableSelectionBook, (PublicUser)currentLoginUser);
					orderHistory.addBookOrder(bo);
					mainMenu.showUserBuySuccess(((PublicUser)currentLoginUser).getUserEmail(), userTableSelectionBook.getRegisterUserEmail()); // success code 0
				}
				else {
					
				}
			}
			else {
				mainMenu.showBookNotSelectedWarning();
			}
		}
	}
	class onClickLogOutButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			currentLoginUser = null;
			usedBookServiceUser.logOut();
			mainMenu.showLogOutSuccess();
			mainMenu.showMainLogin();
		}
	}
	
	class onClickBackButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(currentLoginUser.getIsAdmin()) {
				mainMenu.showAdminMainPanel();
			}
			else {
				mainMenu.showUserMainPanel();	
			}
		}
	}
	
	class onClickMyRegisteredBookButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			usedBook.searchSeller(currentLoginUser.getUserID());
			mainMenu.showMyRegisteredBookPanel();
		}
	}
	class onClickDeleteBookButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(tableSelectIndex >-1) {
				if(mainMenu.showUserDeleteConfirm() == 0) {
					// int deleteIndex = usedBook.getSearchResult().get(tableSelectIndex).getBookNum();
					Book k = usedBook.getSearchResult().get(tableSelectIndex);
					usedBook.removeBook(k);
					mainMenu.showGeneralNotification("Book Deleted!");
				}
				else {		
				}
			}
		}
	}
	class onClickEditBookButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			usedBook.searchSeller(currentLoginUser.getUserID());
			mainMenu.showEditBookPanel(usedBook.getSearchResult().get(tableSelectIndex));		
		}
	}
	class onClickConfirmEditBookButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String title = mainMenu.getBookTitle();
			String author = mainMenu.getBookAuthor();
			String isbn = mainMenu.getBookISBN();
			String pyear = mainMenu.getBookPublishYear();
			String publisher = mainMenu.getBookPublisher();
			String price = mainMenu.getBookPrice();
			if(! title.isEmpty()) {
				
				if(price.isEmpty()) {
					price = "-999";
				}
				int intPrice;
				char status = mainMenu.getBookStatus();
				
				if(status == 'a') {
					status = 'a';
				}
				if(status == 'b') {
					status = 'b';
				}
				if(status == 'c') {
					status = 'c';
				} 
				// convert to model implementation
				
				//check if price contains letter
				try {
					intPrice = Integer.parseInt(price);
					Book editInfo = new Book(title, author, isbn, pyear, publisher, intPrice, status, (PublicUser) currentLoginUser);
					usedBook.editBook(tableSelectIndex, editInfo);
					System.out.println("book edited!!");
					usedBook.printBooks();
					mainMenu.showGeneralNotification("Book Edited");
					mainMenu.showMyRegisteredBookPanel();
				}catch(NumberFormatException ex) {
					mainMenu.showPriceErrorWarning();
				}
			}
			else {
				mainMenu.showGeneralNotification("Title Must be Typed!");
			}
		}
	}
	
	class onClickMyTransactionButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	class onClickMyProfileButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class onClickSellBookButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String title = mainMenu.getBookTitle();
			String author = mainMenu.getBookAuthor();
			String isbn = mainMenu.getBookISBN();
			String pyear = mainMenu.getBookPublishYear();
			String publisher = mainMenu.getBookPublisher();
			String price = mainMenu.getBookPrice();
			if(title.isEmpty()) {
				mainMenu.showGeneralNotification("Title Must be Typed");
			}
			else {
				if(price.isEmpty()) {
					price = "-999";
				}	
				
				int intPrice;
				char status = mainMenu.getBookStatus();
				
				if(status == 'a') {
					status = 'a';
				}
				if(status == 'b') {
					status = 'b';
				}
				if(status == 'c') {
					status = 'c';
				} 
				// convert to model implementation
				
				
				//check if price contains letter
				try {
					intPrice = Integer.parseInt(price);
					Book newbook = new Book(title, author, isbn, pyear, publisher, intPrice, status, (PublicUser) currentLoginUser);
					usedBook.addBook(newbook);
					System.out.println("book added!!");
					//((PublicUser)currentLoginUser).addToRegisterList(newbook);
					usedBook.printBooks();
					mainMenu.showBookRegisterSuccess();
					mainMenu.showUserMainPanel();
					
				}catch(NumberFormatException ex) {
					mainMenu.showPriceErrorWarning();
				}
			}
		}
	}
	
	class onClickManageUserButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainMenu.showUserManagePanel();
		}
	}
	class onClickDeleteUserButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			PublicUser selectedUser = usedBookServiceUser.getPublicUserdata().get(tableSelectIndex);
			try {
				if(mainMenu.showDeleteUserConfirm() == 0) {
					if(selectedUser.getActivationStatus()) {
						mainMenu.showGeneralNotification("Cannot Delete Activated User");
					}
					else {
						usedBook.searchSeller(selectedUser.getUserID());
						ArrayList<Book> booksToDelete = new ArrayList<Book>(usedBook.getSearchResult());
						for(Book b: booksToDelete) {
							usedBook.removeBook(b);
							System.out.println("deleting book" + b.getTitle());
						}
						usedBookServiceUser.deleteUser(selectedUser);
						mainMenu.showGeneralNotification("User Deleted!!");
					}
				}
				else{
					
				}
			}
			catch (ArrayIndexOutOfBoundsException e1) {
				mainMenu.showGeneralNotification("select user to Delete");
			}
		}
	}
	class onClickToggleUserActivationButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			try {
				PublicUser selectedUser = usedBookServiceUser.getPublicUserdata().get(tableSelectIndex);
				usedBookServiceUser.toggleUserActivation(selectedUser);
				if(selectedUser.getActivationStatus()) {
					// activated
					mainMenu.showGeneralNotification("user activated!");
				}
				else {
					//deactivated
					mainMenu.showGeneralNotification("user deactivated!");
				}
			}catch (IndexOutOfBoundsException e1) {
				mainMenu.showGeneralNotification("select user to toggle");
			}
		}
	}
	
	
	class onListSelect implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			int tableIndex = ((ListSelectionModel)e.getSource()).getAnchorSelectionIndex();
			if(tableIndex > -1) {
				System.out.println(tableIndex);
				tableSelectIndex = tableIndex;
			}
			else {
			}
//			if(tableIndex > -1) {
//				userTableSelectionBook = usedBook.getSearchResult().get(tableIndex);			
//			}
//			else {
				// 
//			}
		}
	}	
}
