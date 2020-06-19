package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.User;
import model.PublicUser;


public class MainView {


	// about users
	
	private String bookName;
	private String bookISBN;
	private String bookAuthor;
	private String publishDate;
	//about books
	private Scanner scanner = new Scanner(System.in);
	private String userInput;
	//user input
	
	
	
	public int mainView() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Used Book Marketplace");
		
		System.out.println("please choose followings");
		System.out.println("1. login    2. sign up    3. exit");
		
		int input = scanner.nextInt();
		
		return input;
	}
	
	
	public PublicUser signUp() {
		
		String userID;
		String userPassword;
		String userName;
		String userPhoneNum;
		String userEmail;
		
		
		System.out.println("hello lets sign you up!");
		System.out.println("write ID you want to use!");
		userID = scanner.nextLine();
		System.out.println("write password you want to use!");
		userPassword = scanner.nextLine();
		System.out.println("write your name");
		userName = scanner.nextLine();
		System.out.println("write your phone number");
		userPhoneNum = scanner.nextLine();
		System.out.println("write your email address");
		userEmail = scanner.nextLine();
		
		PublicUser newUser = new PublicUser(userID, userPassword, userName, userPhoneNum,  userEmail);
		
		return newUser;
	}
	public ArrayList<String> login() {
		
		ArrayList<String >loginInfo = new ArrayList<String>();
		String userID;
		String userPassword;
		
		System.out.println("write ID you want to use!");
		userID = scanner.nextLine();
		System.out.println("write password you want to use!");
		userPassword = scanner.nextLine();
		loginInfo.add(userID);
		loginInfo.add(userPassword);
		
		return loginInfo;
	}
	
	
	
}
