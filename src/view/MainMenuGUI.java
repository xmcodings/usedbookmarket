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
import java.awt.TextField;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainMenuGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JPanel loginPanel;
	private JPanel signUpPanel;
	private JPanel userMainPanel;
	private JPanel adminMainPanel;
	
	private JLabel welcomMessage;
	
	private JButton loginButton;
	private JButton signUpButton;
	
	private JButton registerButton;
	
	private JButton searchTitleButton;
	private JButton searchISBNButton;
	private JButton searchPubliherButton;
	private JButton searchAuthorButton;
	private JButton searchYearButton;
	private JButton searchSellerButton;
	
	private JTextField idText;
	private JTextField passText;
	private JTextField nameText;
	private JTextField phoneNumText;
	private JTextField emailText;
	private JTextField searchText;
	
	
	
	
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
		
		
		searchTitleButton    =  new JButton("Search Title");
		searchISBNButton     =  new JButton("Search ISBN");
		searchPubliherButton =  new JButton("Search Publisher");
		searchAuthorButton   =  new JButton("Author Search");
		searchYearButton     =  new JButton("Publish Year Search");
		searchSellerButton   =  new JButton("Seller Search");
		
		
		
		loginIDLabel = new JLabel("ID");
		loginPasswordLabel = new JLabel("Password");
		welcomMessage = new JLabel("Welcome to Used Book Marketplace");
		welcomMessage.setSize(WIDTH, 500);
		
		idText = new JTextField();
		passText = new JTextField();
		
		this.setContentPane(contentPane);
	}
	
	
	public void showMainLogin() {
		
		loginPanel = new JPanel();
		idText       = new JTextField();
		passText     = new JTextField();
		nameText     = new JTextField();
		phoneNumText = new JTextField();
		emailText    = new JTextField();
		
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));
		loginPanel.add(welcomMessage);
		loginPanel.add(new JLabel(" "));
		loginPanel.add(loginIDLabel);
		loginPanel.add(idText);
		loginPanel.add(new JLabel(" "));
		loginPanel.add(new JLabel(" "));
		loginPanel.add(loginPasswordLabel);
		loginPanel.add(passText);
		loginPanel.add(new JLabel(" "));
		loginPanel.add(new JLabel(" "));
		loginPanel.add(loginButton);
		loginPanel.add(signUpButton);
	
		contentPane = loginPanel; 	
		refreshPane();
		System.out.println("showing main login");
	}
	
	public void showSignUp() {
				
		signUpPanel = new JPanel();
		
		signUpPanel.setLayout(new BoxLayout(signUpPanel, BoxLayout.PAGE_AXIS));
		signUpPanel.add(new JLabel("Please Fill the Information Below to Sign Up"));
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(loginIDLabel);
		signUpPanel.add(idText);
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(loginPasswordLabel);
		signUpPanel.add(passText);
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(new JLabel("Name"));
		signUpPanel.add(nameText);
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(new JLabel("Phone Number"));
		signUpPanel.add(phoneNumText);
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(new JLabel("Email"));
		signUpPanel.add(emailText);
		signUpPanel.add(new JLabel(" "));
		signUpPanel.add(new JLabel(" "));
		
		signUpPanel.add(registerButton);
	
		contentPane = signUpPanel;
		refreshPane();
		System.out.println("showing signup page");
	}
	
	
	
	public void showUserMainPanel(String userName) {
		
		userMainPanel = new JPanel();
		
		userMainPanel.setLayout(new BoxLayout(userMainPanel, BoxLayout.PAGE_AXIS));
		
		userMainPanel.add(new JLabel("Hello " + userName +"! Welcome Back!"));
		userMainPanel.add(new JLabel(" "));
		userMainPanel.add(new JLabel(" "));
		
		userMainPanel.add(searchText);
		JPanel searchButtonPanel = new JPanel();
		searchButtonPanel.setLayout(new FlowLayout());
		searchButtonPanel.add(comp)
		
		userMainPanel.add(searchButtonPanel);
		
		
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
