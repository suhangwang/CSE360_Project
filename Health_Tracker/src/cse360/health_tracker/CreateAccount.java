package cse360.health_tracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount {

	private JFrame frmCreateAccount;
	private JPasswordField passwordField;
	private JTextField textUsername;
	private JPasswordField passwordEnter;
	private JPasswordField passwordVerify;
	private JTextField textAnswer;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
					window.frmCreateAccount.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateAccount = new JFrame();
		frmCreateAccount.setTitle("Create Account");
		frmCreateAccount.setResizable(false);
		frmCreateAccount.setAlwaysOnTop(true);
		frmCreateAccount.setBounds(100, 100, 375, 377);
		frmCreateAccount.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(44, 69, 97, 15);
		frmCreateAccount.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(44, 99, 97, 15);
		frmCreateAccount.getContentPane().add(lblPassword);
		
		JLabel lblVerifyPassword = new JLabel("Verify Password:");
		lblVerifyPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVerifyPassword.setBounds(12, 129, 129, 15);
		frmCreateAccount.getContentPane().add(lblVerifyPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Choose Question:");
		lblSecurityQuestion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecurityQuestion.setBounds(12, 159, 129, 16);
		frmCreateAccount.getContentPane().add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnswer.setBounds(12, 189, 129, 16);
		frmCreateAccount.getContentPane().add(lblAnswer);
		
		textUsername = new JTextField();
		textUsername.setBounds(159, 69, 136, 19);
		frmCreateAccount.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		passwordEnter = new JPasswordField();
		passwordEnter.setBounds(159, 99, 136, 19);
		frmCreateAccount.getContentPane().add(passwordEnter);
		
		passwordVerify = new JPasswordField();
		passwordVerify.setBounds(159, 129, 136, 19);
		frmCreateAccount.getContentPane().add(passwordVerify);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"In which city were your born?", "What's your favorite pet?", "What's yhe last name of your first teacher?", "What's your favorite sports?"}));
		comboBox.setBounds(159, 159, 180, 19);
		frmCreateAccount.getContentPane().add(comboBox);
		
		textAnswer = new JTextField();
		textAnswer.setColumns(10);
		textAnswer.setBounds(159, 189, 136, 19);
		frmCreateAccount.getContentPane().add(textAnswer);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCreateAccount.setVisible(false);
			}
		});
		btnSubmit.setBounds(222, 264, 117, 20);
		frmCreateAccount.getContentPane().add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCreateAccount.setVisible(false);
			}
		});
		btnCancel.setBounds(70, 264, 117, 20);
		frmCreateAccount.getContentPane().add(btnCancel);
		frmCreateAccount.setVisible(true);
	}
}
