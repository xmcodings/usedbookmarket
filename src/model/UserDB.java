package model;

import java.util.ArrayList;

import javafx.util.Pair;

public class UserDB {

	private ArrayList<User> userdata = new ArrayList<User>();
	
	private ArrayList<Pair<String, String>> adminInfoList = new ArrayList<Pair<String,String>>();
	
	
	
	public UserDB() {
		
	
		
	}
	
	
	public ArrayList<User> getUserdata() {
		return userdata;
	}

	public void setUserdata(ArrayList<User> userdata) {
		this.userdata = userdata;
	}
	
	public void addUserData(User user) {
		
		userdata.add(user);
	}
	
	
	// return true if it passes duplicate test
	public boolean checkDuplicate(User checkUser) {
		
		for(User user : userdata) {
			if(user.getUserID().equals(checkUser.getUserID())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkAdmin(User user) {
		
		for(Pair<String, String> adminInfo : adminInfoList) {
			if(adminInfo.getKey().equals(user.getUserID()) && adminInfo.getValue().equals(user.getUserPassword()) ) {
				return true;
			}
		}
		return false;
	}

	public void makeAdmin(User user) {
		adminInfoList.add(new Pair<String, String>(user.getUserID(), user.getUserPassword()));
	}
	
	// 0: login fail, 1: login user, 2: login admin
	public int loginAuth(String id, String pass) {
		for(User user : userdata) {
			if(user.getUserID().equals(id) && user.getUserPassword().equals(pass)) {
				if(user.getIsAdmin()) {
					return 2;
				}
				return 1;
			}
		}
		return 0;
	}
	
	public void printUserList() {
		
		for(User user : userdata) {
		
			System.out.println("id : " + user.getUserID() + " pass : " + user.getUserPassword());
			
		}
	}
	
	
}
