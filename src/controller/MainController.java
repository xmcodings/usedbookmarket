package controller;

import java.util.ArrayList;

import model.Book;
import model.PublicUser;
import view.MainView;

public class MainController {

	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<PublicUser> users = new ArrayList<PublicUser>();
	
	MainView mainMenu = new MainView();
	
	private static final byte LOGIN = 1;
	private static final byte SIGNUP = 2;
	private static final byte EXIT = 3;
	
	public void startProgram() {
	
	}
		
	
	private boolean loginAuth(String id, String pass) {
		
		for(PublicUser user : users) {
			if(user.getUserID().equals(id) && user.getUserPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
