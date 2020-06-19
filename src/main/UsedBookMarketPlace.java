package main;



import javax.swing.SwingUtilities;

import controller.MainController;

import view.MainMenuGUI;

public class UsedBookMarketPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainMenuGUI mainGUI = new MainMenuGUI();
		
		MainController marketMainController = new MainController(mainGUI);
		
		
		mainGUI.setVisible(true);
		
	}
	


}