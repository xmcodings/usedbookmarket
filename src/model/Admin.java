package model;

public class Admin extends User{


	public Admin(String id, String pass) {
		
		this.setUserID(id);
		this.setUserPassword(pass);
		this.isAdmin = true;
		
	}
	
	
}
