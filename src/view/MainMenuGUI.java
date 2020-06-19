package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainMenuGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JPanel loginPane;
	private JPanel signUpPane;
	
	
	private JLabel welcomMessage;
	
	private JButton loginButton;
	private JButton signUpButton;
	private JButton exitButton;
	
	private JButton registerButton;
	
	
	private JTextField idText;
	private JTextField passText;
	private JTextField nameText;
	private JTextField phoneNumText;
	private JTextField emailText;
	
	
	
	private JLabel loginIDLabel;
	private JLabel loginPasswordLabel;
	
	
	
	
	public MainMenuGUI() {
		
		setTitle("Used Book Marketplace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		loginButton = new JButton("Login");
		signUpButton = new JButton("Sign Up");
		
		registerButton= new JButton("Register");
		
		
		loginIDLabel = new JLabel("ID");
		loginPasswordLabel = new JLabel("Password");
		welcomMessage = new JLabel("Welcome to Used Book Marketplace");
		welcomMessage.setSize(WIDTH, 500);
		
		idText = new JTextField();
		passText = new JTextField();
		
		this.setContentPane(contentPane);
	}
	
	
	public void showMainLogin() {
		
		loginPane = new JPanel();
		idText       = new JTextField();
		passText     = new JTextField();
		nameText     = new JTextField();
		phoneNumText = new JTextField();
		emailText    = new JTextField();
		
		loginPane.setLayout(new BoxLayout(loginPane, BoxLayout.PAGE_AXIS));
		loginPane.add(welcomMessage);
		loginPane.add(new JLabel(" "));
		loginPane.add(loginIDLabel);
		loginPane.add(idText);
		loginPane.add(new JLabel(" "));
		loginPane.add(new JLabel(" "));
		loginPane.add(loginPasswordLabel);
		loginPane.add(passText);
		loginPane.add(new JLabel(" "));
		loginPane.add(new JLabel(" "));
		loginPane.add(loginButton);
		loginPane.add(signUpButton);
	
		contentPane = loginPane; 	
		refreshPane();
		System.out.println("showing main login");
	}
	
	public void showSignUp() {
				
		signUpPane = new JPanel();
		
		
		signUpPane.setLayout(new BoxLayout(signUpPane, BoxLayout.PAGE_AXIS));
		signUpPane.add(new JLabel("Please Fill the Information Below to Sign Up"));
		signUpPane.add(new JLabel(" "));
		signUpPane.add(loginIDLabel);
		signUpPane.add(idText);
		signUpPane.add(new JLabel(" "));
		signUpPane.add(new JLabel(" "));
		signUpPane.add(loginPasswordLabel);
		signUpPane.add(passText);
		signUpPane.add(new JLabel(" "));
		signUpPane.add(new JLabel(" "));
		signUpPane.add(new JLabel("Name"));
		signUpPane.add(nameText);
		signUpPane.add(new JLabel(" "));
		signUpPane.add(new JLabel(" "));
		signUpPane.add(new JLabel("Phone Number"));
		signUpPane.add(phoneNumText);
		signUpPane.add(new JLabel(" "));
		signUpPane.add(new JLabel(" "));
		signUpPane.add(new JLabel("Email"));
		signUpPane.add(emailText);
		signUpPane.add(new JLabel(" "));
		signUpPane.add(new JLabel(" "));
		
		signUpPane.add(registerButton);
	
		contentPane = signUpPane;
		refreshPane();
		System.out.println("showing signup page");
	}
	public void showDuplicateIDWarning() {
		JOptionPane.showMessageDialog(this, "Same ID Already Exists");
	}
	public void showLoginFailWarning() {
		JOptionPane.showMessageDialog(this, "Wrong ID or Password");
	}
	
	
	
	public void addLoginActionListener(ActionListener e) {
		loginButton.addActionListener(e);
	}
	public void addSignUpActionListener(ActionListener e) {
		signUpButton.addActionListener(e);
	}
	public void addRegisterActionListener(ActionListener e) {
		registerButton.addActionListener(e);
	}
	
	
	private void refreshPane() {
		this.setContentPane(contentPane);
		revalidate();
	}
	
	public String getID() {
		return idText.getText();
	}
	public String getPassword() {
		return passText.getText();
	}
	public String getName() {
		return nameText.getText();
	}
	public String getPhoneNum() {
		return phoneNumText.getText();
	}
	public String getEmail() {
		return emailText.getText();
	}
}
