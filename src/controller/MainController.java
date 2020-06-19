package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Admin;
import model.Book;
import model.PublicUser;
import view.MainMenuGUI;
import view.MainView;

public class MainController {

	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<PublicUser> users = new ArrayList<PublicUser>();
	ArrayList<Admin> admins = new ArrayList<Admin>();
	
	MainMenuGUI mainMenu;
	
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
	
	private void register(String id, String password, String name, String phonenum, String email) {
		
		
	}
	
	
	
	
	// inner onclick event class
	
	class onClickLoginButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = mainMenu.getLoginID();
			String pass = mainMenu.getLoginPassword();
			if(loginAuth(id, pass)) {
				System.out.println("login success");
			}
			else {
				System.out.println("login fail");
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
			mainMenu.showSignUp();
		}
	}
	
}
