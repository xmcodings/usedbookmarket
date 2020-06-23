package model;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import javafx.util.Pair;

public class UserDB{

	private ArrayList<User> userdata = new ArrayList<User>();
	private ArrayList<Pair<String, String>> adminInfoList = new ArrayList<Pair<String,String>>();
	private User loginUser;
	private PropertyChangeSupport support = new PropertyChangeSupport(this);
	
	public UserDB() {
		
	}
	
	public ArrayList<User> getAllUserdata() {
		return userdata;
	}
	
	public ArrayList<PublicUser> getPublicUserdata() {
		ArrayList<PublicUser> temp = new ArrayList<PublicUser>();
		for(User u : userdata) {
			if(! u.getIsAdmin()) {
				temp.add((PublicUser)u);
			}
		}
		return temp;
	}
	public ArrayList<Admin> getAdminUserdata(){
		ArrayList<Admin> temp = new ArrayList<Admin>();
		for(User u : userdata) {
			if(u.getIsAdmin()) {
				temp.add((Admin)u);
			}
		}
		return temp;
	}
	
	public void addUserData(User user) {
		ArrayList<User> oldData = new ArrayList<User>(userdata);
		userdata.add(user);
		support.firePropertyChange("addUser", oldData, userdata);
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
	
	public void toggleUserActivation(PublicUser user) {
		ArrayList<User> oldData = new ArrayList<User>(userdata);
		user.toggleActivation();
		support.firePropertyChange("toggleUserActivation", oldData, getPublicUserdata());
	}
	
	public boolean deleteUser(PublicUser user) {
		if(user.getActivationStatus()) {
			return false;
		}
		else {
			ArrayList<User> oldData = new ArrayList<User>(userdata);
			userdata.remove(user);
			support.firePropertyChange("deleteUser", oldData, getPublicUserdata());
			return true;
		}
	}
	public void makeAdmin(Admin user) {
		adminInfoList.add(new Pair<String, String>(user.getUserID(), user.getUserPassword()));
		user.isAdmin = true;
	}
	
	// 0: login fail, 1: login user, 2: login admin
	public int loginAuth(String id, String pass) {
		for(User user : userdata) {
			if(user.getUserID().equals(id) && user.getUserPassword().equals(pass)) {
				if(user.getIsAdmin()) {
					loginUser = user;
					return 2;
				}
				else {
					if(((PublicUser)user).getActivationStatus()) {
						loginUser = user;
						return 1;	
					}
				}
			}
		}
		return 0;
	}
	
	public void printUserList() {
		for(User user : userdata) {
			System.out.println("id : " + user.getUserID() + " pass : " + user.getUserPassword());
		}
	}
	public User getLoginUser() {
		return loginUser;
	}
	public void logOut() {
		loginUser = null;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

}
