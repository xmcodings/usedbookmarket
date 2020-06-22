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
import model.PublicUser;
import model.User;
import model.UserDB;
import view.MainMenuGUI;
import view.MainView;

public class MainController {

	UserDB usedBookServiceUser; // = new UserDB();
	BookDB usedBook; // = new BookDB();
	MainMenuGUI mainMenu;
	User currentLoginUser;
	Book userTableSelectionBook = null;
	int tableSelectIndex = -1;
	
	public MainController(MainMenuGUI view, UserDB userData, BookDB bookData) {
		this.mainMenu = view;
		this.usedBookServiceUser = userData;
		this.usedBook = bookData;
		
		
		// for main menu
		mainMenu.addLoginActionListener(new onClickLoginButton());
		mainMenu.addSignUpActionListener(new onClickSignUpButton());
		mainMenu.addRegisterActionListener(new onClickRegisterButton());
		
		// for user panel // 
		mainMenu.addSearchTitleActionListener(new onClickSearchTitleButton());
		mainMenu.addSearchAuthorActionListener(new onClickSearchAuthorButton());
		mainMenu.addSearchISBNActionListener(new onClickSearchISBNButton());
		mainMenu.addSearchSellerActionListener(new onClickSearchSellerButton());
		mainMenu.addLogOutActionListener(new onClickLogOutButton());
		
		mainMenu.addRegisterBookActionListener(new onClickRegisterBookButton());
		mainMenu.addMyRegisteredBookActionListener(new onClickMyRegisteredBookButton());
		mainMenu.addTransactionHistoryActionListener(new onClickMyTransactionButton());
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
		usedBook.addPropertyChangeListener(mainMenu);
		
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
					int deleteIndex = usedBook.getSearchResult().get(tableSelectIndex).getBookNum();
					usedBook.removeBook(deleteIndex);
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
			if(title.isEmpty()) {
				
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
					int editIndex = usedBook.getSearchResult().get(tableSelectIndex).getBookNum();
					Book editInfo = new Book(title, author, isbn, pyear, publisher, intPrice, status, (PublicUser) currentLoginUser);
					usedBook.editBook(editIndex, editInfo);
					
					System.out.println("book edited!!");
					usedBook.printBooks();
					mainMenu.showGeneralNotification("Book Edited");
					mainMenu.showUserMainPanel();
					
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
			
			int deleteIndex = usedBookServiceUser.getPublicUserdata().get(tableSelectIndex).getUserNum();
			usedBookServiceUser.deleteUser(deleteIndex);
		}
	}
	class onClickToggleUserActivationButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int editIndex = usedBookServiceUser.getPublicUserdata().get(tableSelectIndex).getUserNum();
			usedBookServiceUser.toggleUserActivation(editIndex);
			
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
