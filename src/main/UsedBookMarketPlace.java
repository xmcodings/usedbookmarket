package main;


import controller.MainController;
import model.Admin;
import model.BookDB;
import model.PublicUser;
import model.TransactionHistory;
import model.UserDB;
import view.MainMenuGUI;

public class UsedBookMarketPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "books.csv";
		System.out.println(filename);
		UserDB marketUsers = new UserDB();
		PublicUser jinwon = new PublicUser("jin", "won", "jinwon", "01046151764", "x@coogle.gom");
		marketUsers.addUserData(jinwon);
		marketUsers.addUserData(new PublicUser("dong", "ju", "dongju", "01046151750", "d@coogle.gom"));
		marketUsers.addUserData(new PublicUser("soft", "ware", "software", "01046151750", "d@coogle.gom"));
		marketUsers.addUserData(new PublicUser("theuserid", "password", "thename", "01044951750", "d@coogle.gom"));
		
		
		BookDB marketBooks = new BookDB(filename, marketUsers);
		Admin admin = new Admin("admin", "nayana");
		TransactionHistory markethistory = new TransactionHistory();
		
		marketUsers.addUserData(admin);  // initialize first admin with id: admin and password: nayana		
		// test codes//

		MainMenuGUI mainGUI = new MainMenuGUI(marketUsers, marketBooks, markethistory);
		MainController marketMainController = new MainController(mainGUI, marketUsers, marketBooks, markethistory);
		mainGUI.setVisible(true);
	}
	


}