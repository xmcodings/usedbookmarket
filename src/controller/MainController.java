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

	UserDB usedBookServiceUser = new UserDB();
	BookDB usedBook = new BookDB();
	
	
	
	MainMenuGUI mainMenu;
	
	public MainController(MainMenuGUI view) {
		this.mainMenu = view;
		
		mainMenu.addLoginActionListener(new onClickLoginButton());
		mainMenu.addSignUpActionListener(new onClickSignUpButton());
		
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
	
	private boolean loginAuth(String id, String pass) {
		
		return usedBookServiceUser.loginAuth(id, pass);
		
	}
	
	
	// inner onclick event class
	
	class onClickLoginButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = mainMenu.getID();
			String pass = mainMenu.getPassword();
			if(loginAuth(id, pass)) {
				System.out.println("login success");
			}
			else {
				System.out.println("login fail");
			}
			// should go to user view
			
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
			mainMenu.showSignUp();
		}
	}
	
}
