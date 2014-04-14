package cse360.health_tracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResetPassword {

	private JFrame frameReset;
	private JPasswordField textReset1;
	private JPasswordField textRetype1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetPassword window = new ResetPassword("admin");
					window.frameReset.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResetPassword(final String username) {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username) {
		frameReset = new JFrame();
		frameReset.setBounds(100, 100, 450, 200);
		frameReset.getContentPane().setLayout(null);
		
		JLabel lblReset1 = new JLabel("New Password:");
		lblReset1.setBounds(45, 60, 120, 20);
		frameReset.getContentPane().add(lblReset1);
		
		JLabel lblRetype1 = new JLabel("Re-type:");
		lblRetype1.setBounds(45, 90, 120, 20);
		frameReset.getContentPane().add(lblRetype1);
		
		textReset1 = new JPasswordField();
		textReset1.setBounds(170, 60, 150, 20);
		frameReset.getContentPane().add(textReset1);
		textReset1.setColumns(10);
		
		textRetype1 = new JPasswordField();
		textRetype1.setBounds(170, 90, 150, 20);
		frameReset.getContentPane().add(textRetype1);
		textRetype1.setColumns(10);
		
		JButton btnReset = new JButton("Submit");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass1 = textReset1.getText();
				String pass2 = textRetype1.getText();
				if(pass1.compareTo(pass2) != 0)
				{
					new ErrorMessage("two passwords do not match");
				}
				else
				{
					MySQLDB.changePassword(username, pass1);
					frameReset.setVisible(false);
				}
			}
		});
		btnReset.setBounds(220, 130, 100, 20);
		frameReset.getContentPane().add(btnReset);
		frameReset.setVisible(true);
	}
}
