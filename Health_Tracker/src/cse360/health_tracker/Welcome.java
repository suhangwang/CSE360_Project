package cse360.health_tracker;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Welcome {

	private JFrame frmHealthTracker;
	private JTextField txtHealthTracker;
	private JTextField txtYourPersoalDoctor;
	private JPasswordField pwdEnterPasswordHere;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtEnterUsernameHere;
	private JButton btnCreateAccount;
	private Scanner input;
	private int userID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frmHealthTracker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmHealthTracker = new JFrame();
		frmHealthTracker.setBackground(Color.WHITE);
		frmHealthTracker.setResizable(false);
		frmHealthTracker.getContentPane().setBackground(new Color(253, 245, 230));
		frmHealthTracker.setTitle("Health Tracker");
		frmHealthTracker.setBounds(100, 100, 854, 521);
		frmHealthTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHealthTracker.getContentPane().setLayout(null);
		
		// added JLabel for logo image
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, frmHealthTracker.getHeight(), frmHealthTracker.getHeight());
		File directory = new File(".");
		final String dir = directory.getCanonicalPath();
		ImageIcon icon = new ImageIcon(dir+"/img/logo.jpg");
		Image temp = icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		lblNewLabel.setIcon(icon);
		frmHealthTracker.getContentPane().add(lblNewLabel);
		
		txtHealthTracker = new JTextField();
		txtHealthTracker.setHorizontalAlignment(SwingConstants.CENTER);
		txtHealthTracker.setForeground(new Color(255, 0, 0));
		txtHealthTracker.setFont(new Font("DejaVu Sans", Font.BOLD, 36));
		txtHealthTracker.setBackground(new Color(255, 250, 240));
		txtHealthTracker.setEditable(false);
		txtHealthTracker.setText("Health Tracker");
		txtHealthTracker.setBounds(lblNewLabel.getWidth()-1, 0, frmHealthTracker.getWidth()-lblNewLabel.getWidth()+1, 90);
		frmHealthTracker.getContentPane().add(txtHealthTracker);
		txtHealthTracker.setColumns(10);
		
		txtYourPersoalDoctor = new JTextField();
		txtYourPersoalDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		txtYourPersoalDoctor.setText("Your Persoal Doctor at Home");
		txtYourPersoalDoctor.setForeground(new Color(0, 0, 255));
		txtYourPersoalDoctor.setFont(new Font("cmmi10", Font.BOLD, 20));
		txtYourPersoalDoctor.setEditable(false);
		txtYourPersoalDoctor.setColumns(10);
		txtYourPersoalDoctor.setBackground(new Color(255, 250, 240));
		txtYourPersoalDoctor.setBounds(lblNewLabel.getWidth()-1, txtHealthTracker.getHeight()-1, frmHealthTracker.getWidth()-lblNewLabel.getWidth()+1, 60);
		frmHealthTracker.getContentPane().add(txtYourPersoalDoctor);
		
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(lblNewLabel.getWidth()+10, 266, 80, 15);
		frmHealthTracker.getContentPane().add(lblUsername);
		
		txtEnterUsernameHere = new JTextField();
		txtEnterUsernameHere.setText("Enter Username Here");
		txtEnterUsernameHere.setBounds(lblNewLabel.getWidth()+10+lblUsername.getWidth(), 266, 145, 20);
		frmHealthTracker.getContentPane().add(txtEnterUsernameHere);
		txtEnterUsernameHere.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(lblNewLabel.getWidth()+10, 296, 80, 15);
		frmHealthTracker.getContentPane().add(lblPassword);
		
		pwdEnterPasswordHere = new JPasswordField();
		pwdEnterPasswordHere.setText("Enter Password Here");
		pwdEnterPasswordHere.setBounds(lblNewLabel.getWidth()+10+lblUsername.getWidth(), 296, 145, 20);
		frmHealthTracker.getContentPane().add(pwdEnterPasswordHere);
		
		// submit username and password
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("submit clicked");
				String username = txtEnterUsernameHere.getText();
				String password = pwdEnterPasswordHere.getText();
				System.out.println(username + " " + password);
				// check if username and password are valid
				/*boolean userValid = false;
				try {
					input = new Scanner(new File(dir+"/passwordList.txt"));
					while(input.hasNextLine() && !userValid)
					{
						if(username.compareTo(input.next())==0 &&
							password.compareTo(input.next())==0)
						{
							userValid = true;
							input.next();
							input.next();
							userID = input.nextInt();
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}*/
				// if valid call main screen
				if(MySQLDB.userValid(username, password))
				{
					//call main screen
					System.out.println("find");
					//TODO //////////////////////////////////////////////////////////////////
					try {
						frmHealthTracker.setVisible(false);
						AddRecord frameAddRecord = new AddRecord(username, password);
						frameAddRecord.setVisible(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					// pop up not correct
					try {
						new ErrorMessage("invalid username or passwrod");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(lblNewLabel.getWidth()+160+lblUsername.getWidth(), 296, 90, 20);
		frmHealthTracker.getContentPane().add(btnNewButton);
		
		// forget password
		JLabel lblForgetPassword = new JLabel("Forget password?");
		lblForgetPassword.setBounds(lblNewLabel.getWidth()+10, 326, 137, 15);
		frmHealthTracker.getContentPane().add(lblForgetPassword);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// call GetPwdBack
				// TODO
			}
		});
		btnHelp.setBounds(lblNewLabel.getWidth()+160+lblUsername.getWidth(), 328, 90, 20);
		frmHealthTracker.getContentPane().add(btnHelp);
		
		JLabel label = new JLabel("New user?");
		label.setBounds(lblNewLabel.getWidth()+10, 356, 137, 15);
		frmHealthTracker.getContentPane().add(label);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// call CreateAccount
				try {
					new CreateAccount();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCreateAccount.setBounds(685, 358, 169, 20);
		frmHealthTracker.getContentPane().add(btnCreateAccount);
		
	}
}
