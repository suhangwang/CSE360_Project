package cse360.health_tracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgetPassword {

	private JFrame frame;
	private JFrame frameShowQuestion;
	private JTextField textField, textFieldQuestion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPassword window = new ForgetPassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ForgetPassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 120);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(20,frame.getHeight()/2-10, 100, 20);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(lblUsername .getWidth()+5, frame.getHeight()/2-10, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				if(!MySQLDB.userExist(username))
				{
					new ErrorMessage("user not exist");
				}
				else
				{
					String userinfo = MySQLDB.getQuestionInd(username);
					int number = userinfo.charAt(0)-'0';
					String answer = userinfo.substring(1);
					String question = "";
					switch (number)
					{
					case 1:
						question = "In which city were your born?";
						break;
					case 2:
						question = "What's your favorite pet?";
						break;
					case 3:
						question = "What's yhe last name of your first teacher?";
						break;
					case 4:
						question = "What's your favorite sports?";
						break;
					}
					frame.setVisible(false);
					System.out.println(answer);
					showQuestion(username, question, answer);
				}
			}
		});
		btnSubmit.setBounds(220, frame.getHeight()/2-10, 100, 20);
		frame.getContentPane().add(btnSubmit);
		frame.setVisible(true);
	}
	
	private void showQuestion(final String username, String question, final String answer)
	{
		frameShowQuestion = new JFrame();
		frameShowQuestion.setBounds(100, 100, 450, 200);
		frameShowQuestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameShowQuestion.getContentPane().setLayout(null);
		
		JLabel lblSecurityQuestion = new JLabel("Question:"+question);
		lblSecurityQuestion.setBounds(40, 40, 400, 20);
		frameShowQuestion.getContentPane().add(lblSecurityQuestion);
		
		textFieldQuestion = new JTextField();
		textFieldQuestion.setBounds(40, 70, 300, 20);
		frameShowQuestion.getContentPane().add(textFieldQuestion);
		textFieldQuestion.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldQuestion.getText().compareTo(answer) != 0)
				{
					new ErrorMessage("answer not correct");
				}
				else
				{
					frameShowQuestion.setVisible(false);
					new ResetPassword(username);
				}
			}
		});
		btnNewButton.setBounds(220, 100, 100, 20);
		frameShowQuestion.getContentPane().add(btnNewButton);
		frameShowQuestion.setVisible(true);
	}
}
