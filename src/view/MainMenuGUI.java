package view;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javafx.event.ActionEvent;
import model.Book;
import model.BookDB;
import model.UserDB;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainMenuGUI extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	
	private UserDB users;
	private BookDB books;
	
	
	private JPanel contentPane;
	
	private JPanel loginPanel;
	private JPanel signUpPanel;
	private JPanel userMainPanel;
	private JPanel adminMainPanel;
	private JPanel searchResultPanel;
	private JPanel registerBookPanel;
	
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
	
	private JButton registerBookButton;
	private JButton myRegisteredBookButton;
	private JButton transactionHistoryButton;
	private JButton myProfileButton;
	
	private JButton buyBookButton;
	private JButton sellBookButton;
	
	
	private JTextField idText;
	private JTextField passText;
	private JTextField nameText;
	private JTextField phoneNumText;
	private JTextField emailText;
	private JTextField searchText;
	
	private JTextField bookTitleText;
	private JTextField bookAuthorText;
	private JTextField bookISBNText;
	private JTextField bookPublishYearText;
	private JTextField bookPublisherText;
	private JRadioButton excellent, good, fair;
	private JTextField bookPriceText;
	
	
	
	private JLabel loginIDLabel;
	private JLabel loginPasswordLabel;
	
	
	
	
	public MainMenuGUI(UserDB systemUsers, BookDB marketBooks) {
		
		setTitle("Used Book Marketplace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		
		this.users = systemUsers;
		this.books = marketBooks;
		
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
		
		registerBookButton			=  new JButton("Register Book");
		myRegisteredBookButton      =  new JButton("My Books");        
		transactionHistoryButton    =  new JButton("Transaction Histroy");         
		myProfileButton                 =  new JButton("My Profile");    
		                                             
		buyBookButton 		= new JButton("Buy");
		
		sellBookButton = new JButton("Sell This Book!");
		                                       
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
		
		nameText     = new JTextField();
		phoneNumText = new JTextField();
		emailText    = new JTextField();
		
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
	
	public void showUserMainPanel() {
		
		userMainPanel = new JPanel();
		
		userMainPanel.setLayout(new BoxLayout(userMainPanel, BoxLayout.PAGE_AXIS));
		
		userMainPanel.add(new JLabel("Hello " + users.getLoginUser().getUserID() +"! Welcome Back!"));
		userMainPanel.add(new JLabel(" "));
		userMainPanel.add(new JLabel("----- Recently Added Books -----"));

		String columns[] = {"Title", "Author", "ISBN", "Publisher", "Publish Date", "Price", "Status", "Seller", "Register Date"};
		JTable recentBookTable = new JTable();
		DefaultTableModel bookModel = new DefaultTableModel(columns, 0);
		
		for(Book b: books.getRecentBookList()) {
			
			String title = b.getTitle();
			String author = b.getAuthor();
			String isbn = b.getISBN();
			String publisher = b.getPublisher();
			String publishYear = b.getPublishYear();
			String price = b.getPriceString();
			String status = b.getStatus();
			String sellerID = b.getRegisterUserId();
			String registerDate = b.getRegisterDate().toString();
			
			Object row[] = { title, author, isbn, publisher, publishYear, price, status, sellerID, registerDate};
			
			bookModel.addRow(row);
		}
		recentBookTable.setModel(bookModel);
		JScrollPane recentScrollPane = new JScrollPane(recentBookTable);
		userMainPanel.add(recentScrollPane);
		userMainPanel.add(new JLabel(" "));
		userMainPanel.add(new JLabel("----- Search What You Want!! -----"));
		userMainPanel.add(new JLabel(" "));
		
		searchText = new JTextField();
		
		userMainPanel.add(searchText);
		
		JPanel searchButtonPanel = new JPanel();
		searchButtonPanel.setLayout(new FlowLayout());
		searchButtonPanel.add(searchTitleButton);
		searchButtonPanel.add(searchAuthorButton);
		searchButtonPanel.add(searchPubliherButton);
		searchButtonPanel.add(searchISBNButton);
		searchButtonPanel.add(searchSellerButton);
		
		
		userMainPanel.add(searchButtonPanel);
		userMainPanel.add(new JLabel(" "));
		userMainPanel.add(new JLabel(" "));
		userMainPanel.add(new JLabel("----- User Space -----"));
		userMainPanel.add(new JLabel(" "));
		userMainPanel.add(new JLabel(" "));
		JPanel userSpacePanel = new JPanel();
		userSpacePanel.setLayout(new FlowLayout());
		
		userSpacePanel.add(registerBookButton);
		userSpacePanel.add(myRegisteredBookButton);
		userSpacePanel.add(transactionHistoryButton);
		userSpacePanel.add(myProfileButton);
		userMainPanel.add(userSpacePanel);
		userMainPanel.add(new JLabel(" "));
		userMainPanel.add(new JLabel(" "));
		
		
		contentPane = userMainPanel;
		refreshPane();
		System.out.println("showing user page");
	}
	
	public void showSearchResultPanel() {
		
		searchResultPanel = new JPanel();
		searchResultPanel.setLayout(new BoxLayout(searchResultPanel, BoxLayout.PAGE_AXIS));
		
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(new JLabel("----- Search Results -----"));
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(new JLabel(" "));
		// table to show search results
		// reads search result directly from BookDB instance
		
		String columns[] = {"Title", "Author", "ISBN", "Publisher", "Publish Date", "Price", "Status", "Seller"};
		JTable searchTable = new JTable();
		
		DefaultTableModel bookModel = new DefaultTableModel(columns, 0);
		searchTable.setModel(bookModel);
		
		
		JScrollPane searchScrollPane = new JScrollPane(searchTable);
		
		searchResultPanel.add(searchScrollPane);
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(buyBookButton);
		searchResultPanel.add(new JLabel(" "));
				
		
		contentPane = searchResultPanel;
		refreshPane();
		System.out.println("showing search result view page");
		
		
	}
	
	public void showRegisterBookPanel() {
		
		registerBookPanel = new JPanel();
		bookTitleText = new JTextField();
		bookAuthorText = new JTextField();
		bookISBNText = new JTextField();
		bookPublishYearText = new JTextField();
		bookPublisherText = new JTextField();
		bookPriceText = new JTextField();

		excellent = new JRadioButton("Excellent");
		good = new JRadioButton("Good");
		fair = new JRadioButton("Fair");
		
		ButtonGroup bookStatusButtonGroup = new ButtonGroup();
		bookStatusButtonGroup.add(excellent);
		bookStatusButtonGroup.add(good);
		bookStatusButtonGroup.add(fair);
		
		
		
		registerBookPanel.setLayout(new BoxLayout(registerBookPanel, BoxLayout.PAGE_AXIS));
		
		registerBookPanel.add(new JLabel("Please add Book Information"));
		registerBookPanel.add(new JLabel(" "));
		registerBookPanel.add(new JLabel("Book Title"));
		registerBookPanel.add(bookTitleText);
		registerBookPanel.add(new JLabel(" "));
		registerBookPanel.add(new JLabel("Book Author"));
		registerBookPanel.add(bookAuthorText);
		registerBookPanel.add(new JLabel(" "));
		registerBookPanel.add(new JLabel("Book ISBN"));
		registerBookPanel.add(bookISBNText);
		registerBookPanel.add(new JLabel(" "));
		registerBookPanel.add(new JLabel("Book Publish Year"));
		registerBookPanel.add(bookPublishYearText);
		registerBookPanel.add(new JLabel(" "));
		registerBookPanel.add(new JLabel("Book Publisher"));
		registerBookPanel.add(bookPublisherText);
		registerBookPanel.add(new JLabel(" "));
		registerBookPanel.add(new JLabel("Book Status"));
		registerBookPanel.add(excellent);
		registerBookPanel.add(good);
		registerBookPanel.add(fair);
		registerBookPanel.add(new JLabel(" "));
		registerBookPanel.add(new JLabel("Book Price"));
		registerBookPanel.add(bookPriceText);
		registerBookPanel.add(new JLabel(" "));
		registerBookPanel.add(new JLabel(" "));
		
		registerBookPanel.add(sellBookButton);
		
		contentPane = registerBookPanel;
		refreshPane();
		System.out.println("showing register book view page");
		
	}
	public void showBookRegisterSuccess() {
		JOptionPane.showMessageDialog(this, "Book Registered!", "Book Register Success", JOptionPane.PLAIN_MESSAGE);
	}
	public void showPriceErrorWarning() {
		JOptionPane.showMessageDialog(this, "Check Price Again");
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
	public void addSearchTitleActionListener(ActionListener e) {
		searchTitleButton.addActionListener(e);
	}
	public void addSearchISBNActionListener(ActionListener e) {
		searchISBNButton.addActionListener(e);
	}
	public void addSearchAuthorActionListener(ActionListener e) {
		searchAuthorButton.addActionListener(e);
	}
	public void addSearchYearActionListener(ActionListener e) {
		searchYearButton.addActionListener(e);
	}
	public void addSearchSellerActionListener(ActionListener e) {
		searchSellerButton.addActionListener(e);
	}
	public void addRegisterBookActionListener(ActionListener e) {
		registerBookButton.addActionListener(e);
	}
	public void addMyRegisteredBookActionListener(ActionListener e) {
		myRegisteredBookButton.addActionListener(e);
	}
	public void addTransactionHistoryActionListener(ActionListener e) {
		transactionHistoryButton.addActionListener(e);
	}
	public void addMyProfileActionListener(ActionListener e) {
		myProfileButton.addActionListener(e);
	}
	public void addSellBookActionListener(ActionListener e) {
		sellBookButton.addActionListener(e);
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
	
	public String getSearchContext() {
		return searchText.getText();
	}
	public String getBookTitle() {
		return bookTitleText.getText();
	}
	public String getBookAuthor() {
		return bookAuthorText.getText();
	}
	public String getBookISBN() {
		return bookISBNText.getText();
	}
	public String getBookPublisher() {
		return bookPublisherText.getText();
	}
	public String getBookPublishYear() {
		return bookPublishYearText.getText();
	}
	public String getBookPrice() {
		return bookPriceText.getText();
	}
	
	public char getBookStatus() {
		if(excellent.isSelected()) {
			return 'a';
		}
		if(good.isSelected()) {
			return 'b';
		}
		if(fair.isSelected()) {
			return 'c';
		}
		return 'n';
	}
	
	
	
	
	
	
	private void refreshPane() {
		this.setContentPane(contentPane);
		revalidate();
	}


	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	
		
		
	}
}


