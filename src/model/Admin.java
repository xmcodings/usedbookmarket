package model;

public class Admin extends User{

	
	private String userName;
	private String userPhoneNum;
	private String userEmail;
	
	public Admin(String id, String pass) {
		
		this.setUserID(id);
		this.setUserPassword(pass);
		this.isAdmin = true;
		
	}
	
	
	
	
}
