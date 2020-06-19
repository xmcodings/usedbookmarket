package model;

public class PublicUser extends User{
	
	private String userID;
	private String userPassword;
	private String userName;
	private String userPhoneNum;
	private String userEmail;
	
	public PublicUser (String id, String pass, String name, String phoneNum, String email) {
	
		this.setUserID(id);
		this.setUserPassword(pass);
		this.setUserName(name);
		this.setUserPhoneNum(phoneNum);
		this.setUserEmail(email);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPhoneNum() {
		return userPhoneNum;
	}


	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}


	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
