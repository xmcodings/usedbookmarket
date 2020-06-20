package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
		mainMenu.addSearchYearActionListener(new onClickSearchYearButton());
		mainMenu.addSearchSellerActionListener(new onClickSearchSellerButton());
		
		mainMenu.addRegisterBookActionListener(new onClickRegisterBookButton());
		mainMenu.addMyRegisteredBookActionListener(new onClickMyRegisteredBookButton());
		mainMenu.addTransactionHistoryActionListener(new onClickMyTransactionButton());
		mainMenu.addMyProfileActionListener(new onClickMyProfileButton());
		mainMenu.addSellBookActionListener(new onClickSellBookButton());
		
		// for add book panel
		
		Admin admin = new Admin("admin", "nayana"); 
		usedBookServiceUser.addUserData(admin);  // initialize first admin with id: admin and password: nayana
		
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
			mainMenu.showSearchResultPanel();
		}
	}
	class onClickSearchAuthorButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainMenu.showSearchResultPanel();
		}
	}	
	class onClickSearchISBNButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	class onClickSearchYearButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	class onClickSearchSellerButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class onClickRegisterBookButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainMenu.showRegisterBookPanel();
			
			
		}
	}
	class onClickMyRegisteredBookButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
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
				usedBook.addBook(new Book(title, author, isbn, pyear, publisher, intPrice, status, (PublicUser) currentLoginUser));
				System.out.println("book added!!");
				usedBook.printBooks();
				mainMenu.showBookRegisterSuccess();
				mainMenu.showUserMainPanel();
				
			}catch(NumberFormatException ex) {
				mainMenu.showPriceErrorWarning();
			}
		}
	}
	
	
	
	
}
