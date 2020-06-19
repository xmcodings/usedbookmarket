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
	
	static void refreshGUI() {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	MainMenuGUI mainGUI = new MainMenuGUI();
            }
	});
	
}


}