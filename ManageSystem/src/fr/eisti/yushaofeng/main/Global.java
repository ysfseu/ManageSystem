package fr.eisti.yushaofeng.main;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import fr.eisti.yushaofeng.DAO.UserDAO;
import fr.eisti.yushaofeng.DAO.UserDAOImpl;
import fr.eisti.yushaofeng.model.User;
public class Global implements Executeur {
	static void a(String s) {
		System.out.println(s);
	}
	UserDAO userDAO = new UserDAOImpl();
	static Global theAppli;
	MyFrame theFrame1 = new MyFrame("Identifiez-vous !");
	JPanel theName = new JPanel();
	JLabel askName = new JLabel("Votre nom ?");
	JTextField sayName = new JTextField(30);
	JPanel thePwd = new JPanel();
	JLabel askPwd = new JLabel("Votre mot de passe ?");
	JTextField sayPwd = new JTextField(30);
	MyButton theGoNoGo = new MyButton(this, 01, "Login");

	MyFrame theFrame2 = new MyFrame("Travaillez !");
	JMenuBar theBar = new JMenuBar();
	JMenu theFile = new JMenu("File");
	MyMenuItem theQuit = new MyMenuItem(this, 11, "Exit");
	MyMenuItem theLogout = new MyMenuItem(this, 12, "Logout");
	JMenu theEdit = new JMenu("Edit");
	MyMenuItem addUser = new MyMenuItem(this, 21, "Add User");
	MyMenuItem delUser = new MyMenuItem(this, 22, "Delete User");
	MyMenuItem chgPass = new MyMenuItem(this, 23, "Change Password");
	JMenu theView = new JMenu("View");
	MyMenuItem userView = new MyMenuItem(this, 61, "User View");
	MyMenuItem metierView = new MyMenuItem(this, 62, "Metier View");
	MyMenuItem driotView = new MyMenuItem(this, 63, "Droit View");
	JMenu theHelp = new JMenu("Help");
	MyMenuItem theJavadoc = new MyMenuItem(this, 91, "Javadoc");
	MyMenuItem theAide = new MyMenuItem(this, 92, "Aide");
	MyMenuItem theAPropos = new MyMenuItem(this, 93, "APropos");
	
	//JTable
	JTable		table;
	JScrollPane scrollPane;
	JPanel		topPanel;
	
	//INSERT INTO `User`( `FirstName`, `LastName`, `UserName`, `Password`, `metierId`)
	//Frame for Add User,Delete User, Update User
	MyFrame D_addUser;
	JTextField Id;
	JTextField firstName;
	JTextField lastName;
	JTextField userName;
	JTextField password;
	JTextField metierId;
	
	MyButton ok;
	MyButton ok2;
	MyButton save;
	MyButton cancel;
	public Global(){	
		
	}
	void myGo() throws Exception {
		theFrame1.setVisible(true);
	}

	public void faireMission(int noMission) {
		try {
			switch (noMission) {
			/* --- */// traiter l'identification
			case 01: {
				//theFrame1.setVisible(false);
				//Thread.sleep(5000);
				User user;
				//userDAO = new UserDAOImpl();
				String userName=sayName.getText();
				String password=sayPwd.getText();
				user=userDAO.login(userName, password);
				if(user!=null){
					theFrame1.setVisible(false);
					theFrame2.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(theFrame1, "Password is not correct");
				}
				
			}
				break;
				
			/* --- */// menu 'Edit'
			//Add User
			case 21:{
				addUserHandle();
			}
			break;
			//Delete User
			case 22:{
				deleteUserHandle();
			}
			break;
			//Change Password
			case 23:{				
				changePasswordHandle();	
			}
			break;
			// Save User
			case 31:{	
				addUserSave();		
			}
			break;
			//Cancel
			case 32:{
				 D_addUser.dispose();
			}
			break;
			//Ok for delete
			case 41:{
				deleteUserOk();
				 
			}
			break;
			// Ok for change Password
			case 51:{
				changePasswordOk();
			}
			break;
			
			
			/* --- */// menu 'File'

			case 11: {
				System.exit(0);
			}
			break;
			case 12: {
				theFrame2.dispose();
				D_addUser.dispose();
				theFrame1.setVisible(true);
			}
			break;
			/* --- */// menu 'View'
			case 61:{
				QueryTableModel qtm=new QueryTableModel("User");
		        table.setModel(qtm);
			}
			break;
			//Display Metier
			case 62:{
				QueryTableModel qtm=new QueryTableModel("Metier");
		        table.setModel(qtm);
			}
			break;
			case 63:{
				QueryTableModel qtm=new QueryTableModel("Droit");
		        table.setModel(qtm);
			}
			break;
			/* --- */// menu 'Help'
			
			case 91: {
			}
				break;
			case 92: {
			}
				break;
			case 93: {
			}
				break;

			/* --- */// ???

			default: {
				a("\tMISSION INCONNUE !! " + noMission);
			}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	void addUserHandle(){
		//D_addUser=new JDialog(theFrame2,"Create User",true);
		D_addUser=new MyFrame("Create User");
		// Set size
		D_addUser.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		D_addUser.setSize(400,400);
		//D_addUser.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        // Set some layout
		D_addUser.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		D_addUser.addWindowListener(new WindowAdapter() {    
			public void windowClosing(WindowEvent evt) {
				//D_addUser.dispose();
			    } });
		
		D_addUser.add(new JLabel("First Name"));
		firstName=new JTextField(20);
		D_addUser.add(firstName);
		
		D_addUser.add(new JLabel("Last Name"));
		lastName=new JTextField(20);
		D_addUser.add(lastName);
		D_addUser.add(new JLabel("UserName"));
		userName=new JTextField(20);
		D_addUser.add(userName);
		D_addUser.add(new JLabel("Password"));
		password=new JTextField(20);
		D_addUser.add(password);
		D_addUser.add(new JLabel("MetierId"));
		metierId=new JTextField(20);
		D_addUser.add(metierId);
		save=new MyButton(this,31,"Save");
		cancel=new MyButton(this,32,"Cancel");
		D_addUser.add(save);
		D_addUser.add(cancel);
		D_addUser.setSize(400,400);
		D_addUser.setVisible(true);
	}
	void addUserSave(){
		User user=new User();
        user.setFirstName(firstName.getText());
        user.setLastName(lastName.getText());
        user.setUsername(userName.getText());
        user.setPassword(password.getText());
        user.setMetierId(Integer.parseInt(metierId.getText()));
        try {
			userDAO.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(D_addUser, "Add User failed, Please fill all the fields");
		}
        QueryTableModel qtm=new QueryTableModel("User");
        table.setModel(qtm);
        //D_addUser.setVisible(false);
        D_addUser.dispose();
	}
	void deleteUserHandle(){
		D_addUser=new MyFrame("Delete User");
		// Set size
		D_addUser.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		D_addUser.setSize(400,200);
		//D_addUser.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        // Set some layout
		D_addUser.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		D_addUser.addWindowListener(new WindowAdapter() {    
			public void windowClosing(WindowEvent evt) {
			    } });
		D_addUser.add(new JLabel("Input Id   "));
		Id=new JTextField(20);
		D_addUser.add(Id);
		
		D_addUser.add(new JLabel("OR UserName"));
		userName=new JTextField(20);
		D_addUser.add(userName);
		ok=new MyButton(this,41,"OK");
		cancel=new MyButton(this,32,"Cancel");
		D_addUser.add(ok);
		D_addUser.add(cancel);
		D_addUser.setSize(400,400);
		D_addUser.setVisible(true);
	}
	void deleteUserOk(){
		User user=new User();
		if((Id.getText()!=null)&&(!Id.getText().equals("")))
		{
			
			//user.setUsername(userName.getText());
			try{
				user.setId(Integer.parseInt(Id.getText()));
				userDAO.deleteUser(user);
			}catch(Exception e){
				JOptionPane.showMessageDialog(D_addUser, "User doesn't exist");
			}
			QueryTableModel qtm=new QueryTableModel("User");
			table.setModel(qtm);
			D_addUser.dispose();
		}else if(userName.getText()!=null){
			user.setId(-1);
			user.setUsername(userName.getText());
			try{
				userDAO.deleteUser(user);
			}catch(Exception e){
				JOptionPane.showMessageDialog(D_addUser, "User doesn't exist");
			}
			QueryTableModel qtm=new QueryTableModel("User");
			table.setModel(qtm);
			D_addUser.dispose();
		}else{
			JOptionPane.showMessageDialog(D_addUser, "Please Input Id or Username");
		}
	}
	void changePasswordHandle(){
		D_addUser=new MyFrame("Change Password");
		// Set size
		D_addUser.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		D_addUser.setSize(400,200);
		//D_addUser.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        // Set some layout
		D_addUser.setLayout(new FlowLayout(FlowLayout.LEADING,25,25));
		D_addUser.addWindowListener(new WindowAdapter() {    
			public void windowClosing(WindowEvent evt) {
			    } });
		D_addUser.add(new JLabel("Input Id   "));
		Id=new JTextField(20);
		D_addUser.add(Id);
		D_addUser.add(new JLabel("OR UserName"));
		userName=new JTextField(20);
		D_addUser.add(userName);
		D_addUser.add(new JLabel("Password"));
		password=new JTextField(20);
		D_addUser.add(password);
		ok2=new MyButton(this,51,"OK");
		cancel=new MyButton(this,32,"Cancel");
		D_addUser.add(ok2);
		D_addUser.add(cancel);
		D_addUser.setSize(400,400);
		D_addUser.setVisible(true);
	}
	void changePasswordOk(){
		User user=new User();
		if((Id.getText()!=null)&&(!Id.getText().equals("")))
		{
			
			//user.sExceptionetUsername(userName.getText());
			try{
				user.setId(Integer.parseInt(Id.getText()));
				user.setPassword(password.getText());
				userDAO.updateUser(user);
			}catch(Exception e){
				JOptionPane.showMessageDialog(D_addUser, "User doesn't exist");
			}
			QueryTableModel qtm=new QueryTableModel("User");
			table.setModel(qtm);
			D_addUser.dispose();
		}else if(userName.getText()!=null){
			try{
				user.setId(-1);
				user.setUsername(userName.getText());
				user.setPassword(password.getText());
				userDAO.updateUser(user);
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(D_addUser, "User doesn't exist");
			}
			QueryTableModel qtm=new QueryTableModel("User");
			table.setModel(qtm);
			D_addUser.dispose();
		}else{
			JOptionPane.showMessageDialog(D_addUser, "Please Input Id or Username");
		}
	}
	void faireIHM() throws Exception {
		theName.add(askName);
		theName.add(sayName);
		theFrame1.add(theName, BorderLayout.NORTH);
		thePwd.add(askPwd);
		thePwd.add(sayPwd);
		theFrame1.add(thePwd, BorderLayout.CENTER);
		theFrame1.add(theGoNoGo, BorderLayout.SOUTH);
		theFrame1.setSize(600, 250);
		theFrame1.validate();
		theFrame1.setVisible(true);
		
		/* --- */

		theFrame2.setJMenuBar(theBar);
		theBar.add(theFile);
		theBar.add(theEdit);
		theBar.add(theView);
		theBar.add(theHelp);
		theEdit.add(addUser);
		theEdit.add(delUser);
		theEdit.add(chgPass);
		theFile.add(theQuit);
		theFile.add(theLogout);
		theView.add(userView);
		theView.add(metierView);
		theView.add(driotView);
		theHelp.add(theJavadoc);
		theHelp.add(theAPropos);
		theHelp.add(theAide);
		theFrame2.setSize(800, 300);
		theFrame2.validate();
		QueryTableModel qtm=new QueryTableModel("User"); 
		table = new JTable(qtm);
		table.setEnabled(false);
		scrollPane = new JScrollPane(table);
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		topPanel.add( scrollPane, BorderLayout.CENTER );
		//qtm.setQuery();
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		theFrame2.getContentPane().add( topPanel );
		
	}
	public static void main(String[] args) throws Exception {
		a(" ");
		a("-------------------------------");
		a(" Exemple destine aux ADEO 2014 ");
		a("-------------------------------");
		a("\nB.M.G. Version 2014 Automne ");
		a("\nligne de commande: ");
		UserDAO userDAO = new UserDAOImpl();
		User user= userDAO.getUser(1);
		System.out.println(user.getUsername());
		for (int w = 0; w < args.length; w++) {
			a("\t" + w + "\t" + args[w]);
		}

		theAppli = new Global();
		theAppli.faireIHM();
		theAppli.myGo();
	}
	
}
