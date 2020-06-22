package model;

import java.util.ArrayList;

import javafx.util.Pair;

public abstract class User {

	private String userID;
	private String userPassword;
	protected boolean isAdmin;
	private int userNum;
	private static int totalUser = 0;
	
	public User() {
		this.userNum = totalUser;
		totalUser++;
	}
	
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
	
	public boolean getIsAdmin() {
		return isAdmin;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	
	
}




