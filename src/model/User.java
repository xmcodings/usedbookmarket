package model;

import java.util.ArrayList;

import javafx.util.Pair;

public abstract class User {

	private String userID;
	private String userPassword;
	private boolean isAdmin;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	
	
}




