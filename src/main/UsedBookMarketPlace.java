package main;



import javax.swing.SwingUtilities;

import controller.MainController;
import model.BookDB;
import model.PublicUser;
import model.UserDB;
import view.MainMenuGUI;

public class UsedBookMarketPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDB marketUsers = new UserDB();
		BookDB marketBooks = new BookDB();
		
		// test codes//
		PublicUser jinwon = new PublicUser("jin", "won", "jinwon", "sdfsdf", "sdfsdf");
		marketUsers.addUserData(jinwon);
		
		MainMenuGUI mainGUI = new MainMenuGUI(marketUsers, marketBooks);
		
		MainController marketMainController = new MainController(mainGUI, marketUsers, marketBooks);
		
		mainGUI.setVisible(true);
		
	}
	


}