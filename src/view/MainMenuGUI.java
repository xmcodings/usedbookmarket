package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Book;
import model.BookDB;
import model.BookOrder;
import model.PublicUser;
import model.TransactionHistory;
import model.UserDB;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class MainMenuGUI extends JFrame implements PropertyChangeListener{

	private static final long serialVersionUID = 1L;
	
	private UserDB users;
	private BookDB books;
	private TransactionHistory bookOrders;
	
	private JPanel contentPane;
	
	private JPanel loginPanel;
	private JPanel signUpPanel;
	private JPanel userMainPanel;
	private JPanel adminMainPanel;
	private JPanel searchResultPanel;
	private JPanel registerBookPanel;
	private JPanel myRegisteredBookPanel;
	private JPanel myTransactionPanel;
	private JPanel editBookPanel;
	private JPanel userManagePanel;
	
	
	private JLabel welcomMessage;
	
	private JButton loginButton;
	private JButton signUpButton;
	
	private JButton registerButton;
	
	private JButton searchTitleButton;
	private JButton searchISBNButton;
	private JButton searchAuthorButton;
	private JButton searchYearButton;
	private JButton searchPublisherButton;
	private JButton searchSellerButton;
	
	private JButton registerBookButton;
	private JButton myRegisteredBookButton;
	private JButton currentTransactionButton;
	private JButton myProfileButton;
	private JButton logoutButton;
	
	private JButton editBookButton;
	private JButton deleteBookButton;
	
	private JButton confirmEditBookButton;
	
	private JButton buyBookButton;
	private JButton sellBookButton;
	
	private JButton backButton;
	// for admins
	private JButton manageUserButton;
	private JButton deleteUserButton;
	private JButton toggleUserActivationButton;
	private JButton deleteOrderButton;
	
	
	
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
	
	private JTable searchTable;
	private ListSelectionModel selectModel; 
	
	
	private JLabel loginIDLabel;
	private JLabel loginPasswordLabel;
	private DefaultTableModel bookModel;
	private	DefaultTableModel userModel;
	private	DefaultTableModel bookOrderModel;
	

	public MainMenuGUI(UserDB systemUsers, BookDB marketBooks, TransactionHistory orders) {
		
		setTitle("Used Book Marketplace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		
		this.users = systemUsers;
		this.books = marketBooks;
		this.bookOrders = orders;
		
		books.addPropertyChangeListener(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		loginButton = new JButton("Login");
		signUpButton = new JButton("Sign Up");
		
		registerButton= new JButton("Register");
		
		
		searchTitleButton    =  new JButton("Search Title");
		searchISBNButton     =  new JButton("Search ISBN");
		searchAuthorButton   =  new JButton("Search Author");
		searchYearButton     =  new JButton("Search Publish Year");
		searchPublisherButton=  new JButton("Search Publisher");
		searchSellerButton   =  new JButton("Search Seller");
		
		registerBookButton			=  new JButton("Register Book");
		myRegisteredBookButton      =  new JButton("My Books");        
		currentTransactionButton    =  new JButton("on-going Trade");         
		myProfileButton             =  new JButton("My Profile");   
		logoutButton				=  new JButton("Log Out");
		                                             
		buyBookButton 		= new JButton("Buy");
		
		editBookButton = new JButton("edit");
		deleteBookButton = new JButton("delete");
		confirmEditBookButton = new JButton("edit confirm");
		deleteOrderButton = new JButton("Delete Order");
		
		manageUserButton = new JButton("Manage Users");
		toggleUserActivationButton = new JButton("Toggle Activation");
		deleteUserButton = new JButton("Delete User");
		
		
		
		// tabel init
		searchTable = new JTable();
		searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectModel = searchTable.getSelectionModel();
		// finish
		
		sellBookButton = new JButton("Sell This Book!");
		backButton = new JButton("Back");
		
		loginIDLabel = new JLabel("ID");             
		loginPasswordLabel = new JLabel("Password");
		welcomMessage = new JLabel("Welcome to Used Book Marketplace");
		welcomMessage.setSize(WIDTH, 500);
		
		idText = new JTextField();
		passText = new JTextField();
		
		// property change listener....
		books.addPropertyChangeListener(this);
		
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
		System.out.println(users.getLoginUser().getUserID());
		userMainPanel.add(new JLabel("Hello " + users.getLoginUser().getUserID() +"! Welcome Back!"));
		userMainPanel.add(new JLabel(" "));
		userMainPanel.add(new JLabel("----- Recently Added Books -----"));

		String columns[] = {"Title", "Author", "ISBN", "Publisher", "Publish Date", "Price", "Status", "Seller", "Register Date"};
		JTable recentBookTable = new JTable();
		
		bookModel = new DefaultTableModel(columns, 0);
		
		drawBookTable(bookModel, books.getRecentBookList());
		
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
		searchButtonPanel.add(searchISBNButton);
		searchButtonPanel.add(searchSellerButton);
		searchButtonPanel.add(searchYearButton);
		searchButtonPanel.add(searchPublisherButton);
		
		
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
		userSpacePanel.add(currentTransactionButton);
		//userSpacePanel.add(myProfileButton);
		userSpacePanel.add(logoutButton);
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
		
		String columns[] = {"Title", "Author", "ISBN", "Publisher", "Publish Date", "Price", "Status", "Seller", "Register Date"};

		bookModel = new DefaultTableModel(columns, 0);
		
		drawBookTable(bookModel, books.getSearchResult());
		
		JScrollPane searchScrollPane = new JScrollPane(searchTable);
		
		searchResultPanel.add(searchScrollPane);
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(buyBookButton);
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(backButton);
		searchResultPanel.add(new JLabel(" "));
				
		
		contentPane = searchResultPanel;
		refreshPane();
		System.out.println("showing search result view page");
	}
	public void showSearchResultAdminPanel() {
		
		searchResultPanel = new JPanel();
		searchResultPanel.setLayout(new BoxLayout(searchResultPanel, BoxLayout.PAGE_AXIS));
		
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(new JLabel("----- Search Results -----"));
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(new JLabel(" "));
		// table to show search results
		// reads search result directly from BookDB instance
		
		String columns[] = {"Title", "Author", "ISBN", "Publisher", "Publish Date", "Price", "Status", "Seller", "Register Date"};

		bookModel = new DefaultTableModel(columns, 0);

		drawBookTable(bookModel, books.getSearchResult());
		
		JScrollPane searchScrollPane = new JScrollPane(searchTable);
		
		searchResultPanel.add(searchScrollPane);
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(deleteBookButton);
		searchResultPanel.add(new JLabel(" "));
		searchResultPanel.add(backButton);
		searchResultPanel.add(new JLabel(" "));
				
		
		contentPane = searchResultPanel;
		refreshPane();
		System.out.println("showing search result view page");
	}
	
	public void showMyRegisteredBookPanel() {
		
		myRegisteredBookPanel = new JPanel();
		myRegisteredBookPanel.setLayout(new BoxLayout(myRegisteredBookPanel, BoxLayout.PAGE_AXIS));
		myRegisteredBookPanel.add(new JLabel(" "));
		myRegisteredBookPanel.add(new JLabel(" "));
		myRegisteredBookPanel.add(new JLabel("----- My Registered Books -----"));
		myRegisteredBookPanel.add(new JLabel(" "));
		myRegisteredBookPanel.add(new JLabel(" "));
		// table to show search results
		// reads search result directly from BookDB instance
		
		String columns[] = {"Title", "Author", "ISBN", "Publisher", "Publish Date", "Price", "Status", "Seller", "Register Date"};
		bookModel = new DefaultTableModel(columns, 0);
		drawBookTable(bookModel, books.getSearchResult());
		
		JScrollPane searchScrollPane = new JScrollPane(searchTable);
		
		myRegisteredBookPanel.add(searchScrollPane);
		myRegisteredBookPanel.add(new JLabel(" "));
		myRegisteredBookPanel.add(new JLabel(" "));
		myRegisteredBookPanel.add(editBookButton);
		myRegisteredBookPanel.add(new JLabel(" "));
		myRegisteredBookPanel.add(deleteBookButton);
		myRegisteredBookPanel.add(new JLabel(" "));
		myRegisteredBookPanel.add(backButton);
		myRegisteredBookPanel.add(new JLabel(" "));
				
		contentPane = myRegisteredBookPanel;
		refreshPane();
		System.out.println("showing my books view page");
		
	}
	
	public void showMyTransactionPanel() {
		
		myTransactionPanel = new JPanel();
		myTransactionPanel.setLayout(new BoxLayout(myTransactionPanel, BoxLayout.PAGE_AXIS));
		myTransactionPanel.add(new JLabel(" "));
		myTransactionPanel.add(new JLabel(" "));
		myTransactionPanel.add(new JLabel("----- My Current Transactions -----"));
		myTransactionPanel.add(new JLabel(" "));
		myTransactionPanel.add(new JLabel(" "));
		// table to show search results
		// reads search result directly from BookDB instance
		
		String columns[] = {"Title", "Price", "BuyerID", "Register Date"};
		
		bookOrderModel = new DefaultTableModel(columns, 0);
		drawBookOrderTable(bookOrderModel, bookOrders.getSellerBookOrder());
		
		JScrollPane searchScrollPane = new JScrollPane(searchTable);
		
		myTransactionPanel.add(searchScrollPane);
		myTransactionPanel.add(new JLabel(" "));
		myTransactionPanel.add(new JLabel(" "));
		myTransactionPanel.add(deleteOrderButton);
		myTransactionPanel.add(new JLabel(" "));
		myTransactionPanel.add(backButton);
		myTransactionPanel.add(new JLabel(" "));
				
		contentPane = myTransactionPanel;
		refreshPane();
		System.out.println("showing my books view page");
	}
	
	public void showAdminMainPanel() {
		
		adminMainPanel = new JPanel();
		
		adminMainPanel.setLayout(new BoxLayout(adminMainPanel, BoxLayout.PAGE_AXIS));
		
		adminMainPanel.add(new JLabel("Hello admin user <" + users.getLoginUser().getUserID() +">!  Welcome Back!"));
		adminMainPanel.add(new JLabel(" "));
		
		adminMainPanel.add(new JLabel(" "));
		adminMainPanel.add(new JLabel("----- Search What You Want!! -----"));
		adminMainPanel.add(new JLabel(" "));
		
		searchText = new JTextField();
		
		adminMainPanel.add(searchText);
		
		JPanel searchButtonPanel = new JPanel();
		searchButtonPanel.setLayout(new FlowLayout());
		searchButtonPanel.add(searchTitleButton);
		searchButtonPanel.add(searchAuthorButton);
		searchButtonPanel.add(searchISBNButton);
		searchButtonPanel.add(searchSellerButton);
		
		adminMainPanel.add(searchButtonPanel);
		adminMainPanel.add(new JLabel(" "));
		adminMainPanel.add(new JLabel(" "));
		adminMainPanel.add(new JLabel("----- Admin Space -----"));
		adminMainPanel.add(new JLabel(" "));
		adminMainPanel.add(new JLabel(" "));
		adminMainPanel.add(manageUserButton);
		adminMainPanel.add(new JLabel(" "));
		adminMainPanel.add(logoutButton);
		adminMainPanel.add(new JLabel(" "));
		
		contentPane = adminMainPanel;
		refreshPane();
		System.out.println("showing admin page");
	}
	public void showUserManagePanel() {
		
		userManagePanel = new JPanel();
		userManagePanel.setLayout(new BoxLayout(userManagePanel, BoxLayout.PAGE_AXIS));
		userManagePanel.add(new JLabel(" "));
		userManagePanel.add(new JLabel(" "));
		userManagePanel.add(new JLabel("----- User List -----"));
		userManagePanel.add(new JLabel(" "));
		userManagePanel.add(new JLabel(" "));
		// table to show search results
		// reads search result directly from BookDB instance
		
		String columns[] = {"ID", "Name", "Password", "Phone Number", "Email", "Activation Status"};

		userModel = new DefaultTableModel(columns, 0);
		
		drawUserTable(userModel, users.getPublicUserdata());
		
		searchTable.setModel(userModel);
		
		JScrollPane searchScrollPane = new JScrollPane(searchTable);
		
		userManagePanel.add(searchScrollPane);
		userManagePanel.add(new JLabel(" "));
		userManagePanel.add(new JLabel(" "));
		userManagePanel.add(toggleUserActivationButton);
		userManagePanel.add(new JLabel(" "));
		userManagePanel.add(deleteUserButton);
		userManagePanel.add(new JLabel(" "));
		userManagePanel.add(backButton);
		userManagePanel.add(new JLabel(" "));
		
		contentPane = userManagePanel;
		refreshPane();
		System.out.println("showing user manage view page");
		
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
	public void showEditBookPanel(Book editBook) {
		
		editBookPanel = new JPanel();
		
		bookTitleText = new JTextField(editBook.getTitle());
		bookAuthorText = new JTextField(editBook.getAuthor());
		bookISBNText = new JTextField(editBook.getISBN());
		bookPublishYearText = new JTextField(editBook.getPublishYear());
		bookPublisherText = new JTextField(editBook.getPublisher());
		bookPriceText = new JTextField(editBook.getPriceString());
		
		excellent = new JRadioButton("Excellent");
		good = new JRadioButton("Good");
		fair = new JRadioButton("Fair");
		
		ButtonGroup bookStatusButtonGroup = new ButtonGroup();
		bookStatusButtonGroup.add(excellent);
		bookStatusButtonGroup.add(good);
		bookStatusButtonGroup.add(fair);
		
		editBookPanel.setLayout(new BoxLayout(editBookPanel, BoxLayout.PAGE_AXIS));
		editBookPanel.add(new JLabel("Please add Book Information"));
		editBookPanel.add(new JLabel(" "));
		editBookPanel.add(new JLabel("Book Title"));
		editBookPanel.add(bookTitleText);
		editBookPanel.add(new JLabel(" "));
		editBookPanel.add(new JLabel("Book Author"));
		editBookPanel.add(bookAuthorText);
		editBookPanel.add(new JLabel(" "));
		editBookPanel.add(new JLabel("Book ISBN"));
		editBookPanel.add(bookISBNText);
		editBookPanel.add(new JLabel(" "));
		editBookPanel.add(new JLabel("Book Publish Year"));
		editBookPanel.add(bookPublishYearText);
		editBookPanel.add(new JLabel(" "));
		editBookPanel.add(new JLabel("Book Publisher"));
		editBookPanel.add(bookPublisherText);
		editBookPanel.add(new JLabel(" "));
		editBookPanel.add(new JLabel("Book Status"));
		editBookPanel.add(excellent);
		editBookPanel.add(good);
		editBookPanel.add(fair);
		editBookPanel.add(new JLabel(" "));
		editBookPanel.add(new JLabel("Book Price"));
		editBookPanel.add(bookPriceText);
		editBookPanel.add(new JLabel(" "));
		editBookPanel.add(new JLabel(" "));
		editBookPanel.add(confirmEditBookButton);
		editBookPanel.add(new JLabel(" "));
		
		contentPane = editBookPanel;
		refreshPane();
		System.out.println("showing edit book view page");
	}
	
	public void showBookRegisterSuccess() {
		JOptionPane.showMessageDialog(this, "Book Registered!", "Book Register Success", JOptionPane.PLAIN_MESSAGE);
	}
	public void showUserSignUpSuccess() {
		JOptionPane.showMessageDialog(this, "welcome!", "Sign Up Complete", JOptionPane.PLAIN_MESSAGE);
	}
	public int showUserBuyConfirm() {
		
		int n = JOptionPane.showConfirmDialog(this,
			    "Do You Want to Buy This Book?",
			    "Purchase Confirm",
			    JOptionPane.YES_NO_OPTION);
		return n;
	}
	public int showDeleteUserConfirm() {
		
		int n = JOptionPane.showConfirmDialog(this,
			    "Are You Sure You Want To Delete? All of the Registered Books Will Also be Deleted",
			    "Delete User Confirm",
			    JOptionPane.YES_NO_OPTION);
		return n;
	}
	public void showUserBuySuccess(String buyerEmail, String sellerEmail) {
		JOptionPane.showMessageDialog(this, "Email From Your Account <" + buyerEmail + "> Sent To Seller <" + sellerEmail + ">", "buy",JOptionPane.PLAIN_MESSAGE);
	}
	public void showLogOutSuccess() {
		JOptionPane.showMessageDialog(this, "Logout Successful", "logout",JOptionPane.PLAIN_MESSAGE);
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
	public void showSearchTextEmptyWarning() {
		JOptionPane.showMessageDialog(this, "Search Box is Empty!");
	}
	public void showBookNotSelectedWarning() {
		JOptionPane.showMessageDialog(this, "Book Not Selected!");
	}
	public int showUserDeleteConfirm() {
		int n = JOptionPane.showConfirmDialog(this,
			    "Do You Want To Delete This Book?",
			    "Delete Confirm",
			    JOptionPane.YES_NO_OPTION);
		return n;
	}
	public void showGeneralNotification(String message) {
		JOptionPane.showMessageDialog(this, message, "Notification", JOptionPane.PLAIN_MESSAGE);
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
	public void addSearchPublisherActionListener(ActionListener e) {
		searchPublisherButton.addActionListener(e);
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
	public void addCurrentTransactionActionListener(ActionListener e) {
		currentTransactionButton.addActionListener(e);
	}
	public void addMyProfileActionListener(ActionListener e) {
		myProfileButton.addActionListener(e);
	}
	public void addSellBookActionListener(ActionListener e) {
		sellBookButton.addActionListener(e);
	}
	public void addBackActionListener(ActionListener e) {
		backButton.addActionListener(e);
	}
	public void addLogOutActionListener(ActionListener e) {
		logoutButton.addActionListener(e);
	}
	public void addBuyBookActionListener(ActionListener e) {
		buyBookButton.addActionListener(e);
	}
	public void addSearchTableListener(ListSelectionListener l) {
		selectModel.addListSelectionListener(l);
	}
	public void addDeleteBookListener(ActionListener e) {
		deleteBookButton.addActionListener(e);
	}
	public void addEditBookListener(ActionListener e) {
		editBookButton.addActionListener(e);
	}
	public void addConfirmEditBookListener(ActionListener e) {
		confirmEditBookButton.addActionListener(e);
	}
	public void addManageUserListener(ActionListener e) {
		manageUserButton.addActionListener(e);
	}
	public void addToggleUserActivationListener(ActionListener e) {
		toggleUserActivationButton.addActionListener(e);
	}
	public void addDeleteUserListener(ActionListener e) {
		deleteUserButton.addActionListener(e);
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
	private void drawBookTable(TableModel t, ArrayList<Book> list) {

		//bookModel = new DefaultTableModel(columns, 0);
		bookModel.setRowCount(0);
		for(Book b: list) {
			String title = b.getTitle();
			String author = b.getAuthor();
			String isbn = b.getISBN();
			String publisher = b.getPublisher();
			String publishYear = b.getPublishYear();
			String price = b.getPriceString();
			String status = b.getStatus();
			String registerDate = b.getRegisterDate().toString();
			String seller = b.getRegisterUserId();
			
			Object row[] = { title, author, isbn, publisher, publishYear, price, status, seller, registerDate};
			
			((DefaultTableModel) t).addRow(row);
		}
		searchTable.setModel(t);
	}
	private void updateBookModel(ArrayList<Book> list) {
		
		bookModel.setRowCount(0);
		
		for(Book b: list) {
			String title = b.getTitle();
			String author = b.getAuthor();
			String isbn = b.getISBN();
			String publisher = b.getPublisher();
			String publishYear = b.getPublishYear();
			String price = b.getPriceString();
			String status = b.getStatus();
			String registerDate = b.getRegisterDate().toString();
			String seller = b.getRegisterUserId();
			
			Object row[] = { title, author, isbn, publisher, publishYear, price, status, seller, registerDate};
			
			bookModel.addRow(row);
		}
	}
	
	private void drawUserTable(TableModel t, ArrayList<PublicUser> list) {

		userModel.setRowCount(0);
		
		for(PublicUser u : list) {
			String id = u.getUserID();
			String name = u.getUserName();
			String pass = u.getUserPassword();
			String phonenum = u.getUserPhoneNum();
			String email = u.getUserEmail();
			String actstatus = Boolean.toString(u.getActivationStatus());
			Object row[] = {id, name, pass, phonenum, email, actstatus};	
			userModel.addRow(row);
		}
		searchTable.setModel(t);
	}
	private void updateUserModel(ArrayList<PublicUser> list) {
		
		userModel.setRowCount(0);
		for(PublicUser u : list) {
			String id = u.getUserID();
			String name = u.getUserName();
			String pass = u.getUserPassword();
			String phonenum = u.getUserPhoneNum();
			String email = u.getUserEmail();
			String actstatus = Boolean.toString(u.getActivationStatus());
			Object row[] = {id, name, pass, phonenum, email, actstatus};	
			userModel.addRow(row);
		}
	}
	
	
	private void drawBookOrderTable(TableModel t, ArrayList<BookOrder> list) {

		((DefaultTableModel) t).setRowCount(0);
		
		for(BookOrder bo : list) {
			String title = bo.getBookTitle();
			String price = bo.getBookPrice();
			String buyerID = bo.getBuyerID();
			String regdate = bo.getBook().getRegisterDate().toString();
			Object row[] = {title, price, buyerID, regdate};	
			((DefaultTableModel) t).addRow(row);
		}
		searchTable.setModel(t);
	}
	private void updateBookOrderModel(ArrayList<BookOrder> list) {
		
		bookOrderModel.setRowCount(0);
		
		for(BookOrder bo : list) {
			String title = bo.getBookTitle();
			String price = bo.getBookPrice();
			String buyerID = bo.getBuyerID();
			String regdate = bo.getBook().getRegisterDate().toString();
			Object row[] = {title, price, buyerID, regdate};	
			bookOrderModel.addRow(row);
		}
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("Book List Changed!");
		if(evt.getPropertyName().equals("removeBook")) {			
			//showMyRegisteredBookPanel();
			updateBookModel((ArrayList<Book>) evt.getNewValue());
			refreshPane();
		}
		if(evt.getPropertyName().equals("recentBookChange")) {
			updateBookModel((ArrayList<Book>) evt.getNewValue());
			refreshPane();
		}	
		if(evt.getPropertyName().equals("toggleUserActivation")) {
			System.out.println("toggle user");
			updateUserModel((ArrayList<PublicUser>)evt.getNewValue());
		}
		if(evt.getPropertyName().equals("deleteUser")) {
			System.out.println("delete user");
			updateUserModel((ArrayList<PublicUser>)evt.getNewValue());
		}
	}
	
}


