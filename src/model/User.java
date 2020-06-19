package model;

public abstract class User {

	private String userID;
	private String userPassword;
	
	public User (String id, String pass) {
		
		this.setUserID(id);
		this.setUserPassword(pass);
	
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
	
}

class Admin extends User{

	public Admin(String id, String pass) {
		super(id, pass);
		// TODO Auto-generated constructor stub
	}
}


