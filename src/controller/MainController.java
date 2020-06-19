package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Book;
import model.PublicUser;
import view.MainMenuGUI;
import view.MainView;

public class MainController {

	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<PublicUser> users = new ArrayList<PublicUser>();
	
	//MainView mainMenu = new MainView();
	
	MainMenuGUI mainMenu;
	
	
	//private static final byte LOGIN = 1;
	//private static final byte SIGNUP = 2;
	//private static final byte EXIT = 3;
	
	public MainController(MainMenuGUI view) {
		this.mainMenu = view;
		
		mainMenu.addLoginActionListener(new onClickLoginButton());
		mainMenu.addSignUpActionListener(new onClickSignUpButton());
		
		
		
		
		startProgram();
	}
	
	public void startProgram() {
		mainMenu.showMainLogin();
	}
		
	
	private boolean loginAuth(String id, String pass) {
		
		for(PublicUser user : users) {
			if(user.getUserID().equals(id) && user.getUserPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	// inner onclick event class
	
	class onClickLoginButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainMenu.showSignUp();
		}
	}
	class onClickSignUpButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			mainMenu.showSignUp();
		}
	}
	
}
