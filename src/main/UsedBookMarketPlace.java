package main;



import java.nio.file.Paths;

import javax.swing.SwingUtilities;

import controller.MainController;
import model.Admin;
import model.BookDB;
import model.PublicUser;
import model.UserDB;
import view.MainMenuGUI;

public class UsedBookMarketPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "books.csv";
		System.out.println(filename);
		UserDB marketUsers = new UserDB();
		BookDB marketBooks = new BookDB(filename);
		Admin admin = new Admin("admin", "nayana"); 
		marketUsers.addUserData(admin);  // initialize first admin with id: admin and password: nayana
		
		
		
		// test codes//
		PublicUser jinwon = new PublicUser("jin", "won", "jinwon", "sdfsdf", "sdfsdf");
		marketUsers.addUserData(jinwon);
		
		MainMenuGUI mainGUI = new MainMenuGUI(marketUsers, marketBooks);
		
		MainController marketMainController = new MainController(mainGUI, marketUsers, marketBooks);
		
		mainGUI.setVisible(true);
		
	}
	


}