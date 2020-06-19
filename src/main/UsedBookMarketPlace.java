package main;

import java.awt.EventQueue;
import java.util.Calendar;

import controller.MainController;
import model.Book;
import view.MainMenuGUI;

public class UsedBookMarketPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainController marketMainController = new MainController();
			
		marketMainController.startProgram();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuGUI frame = new MainMenuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
}