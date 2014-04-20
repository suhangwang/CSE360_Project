package cse360.health_tracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;

public class SetGoal {

	private JFrame frame;
	private JTextField txtWeightToLose;
	private JTextField txtHourToIncrease;
	private JTextField txtHourToSleep;
	private JTextField txtHourToDecrease;
	private JTextField txtDays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetGoal window = new SetGoal();
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
	public SetGoal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lose Weight");
		lblNewLabel.setBounds(34, 44, 110, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMoreRecreation = new JLabel("More recreation");
		lblMoreRecreation.setBounds(34, 73, 128, 16);
		frame.getContentPane().add(lblMoreRecreation);
		
		JLabel lblSleepMore = new JLabel("Sleep More");
		lblSleepMore.setBounds(34, 102, 128, 16);
		frame.getContentPane().add(lblSleepMore);
		
		JLabel lblLessCradioWorkout = new JLabel("less cradio workout");
		lblLessCradioWorkout.setBounds(34, 131, 128, 16);
		frame.getContentPane().add(lblLessCradioWorkout);
		
		txtWeightToLose = new JTextField();
		txtWeightToLose.setText("weight to lose");
		txtWeightToLose.setBounds(174, 41, 116, 22);
		frame.getContentPane().add(txtWeightToLose);
		txtWeightToLose.setColumns(10);
		
		txtHourToIncrease = new JTextField();
		txtHourToIncrease.setText("hour to increase");
		txtHourToIncrease.setBounds(174, 70, 116, 22);
		txtHourToIncrease.setColumns(10);
		frame.getContentPane().add(txtHourToIncrease);
		
		txtHourToSleep = new JTextField();
		txtHourToSleep.setText("hour to sleep");
		txtHourToSleep.setBounds(174, 99, 116, 22);
		txtHourToSleep.setColumns(10);
		frame.getContentPane().add(txtHourToSleep);
		
		txtHourToDecrease = new JTextField();
		txtHourToDecrease.setText("hour to decrease");
		txtHourToDecrease.setBounds(174, 128, 116, 22);
		txtHourToDecrease.setColumns(10);
		frame.getContentPane().add(txtHourToDecrease);
		
		JLabel lblNewLabel_1 = new JLabel("lb");
		lblNewLabel_1.setBounds(317, 44, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblHour = new JLabel("hour");
		lblHour.setBounds(317, 73, 56, 16);
		frame.getContentPane().add(lblHour);
		
		JLabel lblHour_1 = new JLabel("hour");
		lblHour_1.setBounds(317, 102, 56, 16);
		frame.getContentPane().add(lblHour_1);
		
		JLabel lblHour_2 = new JLabel("hour");
		lblHour_2.setBounds(317, 131, 56, 16);
		frame.getContentPane().add(lblHour_2);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(34, 348, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(143, 348, 97, 25);
		frame.getContentPane().add(btnReset);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(255, 348, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblWithin = new JLabel("within");
		lblWithin.setBounds(34, 160, 56, 16);
		frame.getContentPane().add(lblWithin);
		
		txtDays = new JTextField();
		txtDays.setText("days");
		txtDays.setBounds(174, 157, 116, 22);
		frame.getContentPane().add(txtDays);
		txtDays.setColumns(10);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(317, 166, 56, 16);
		frame.getContentPane().add(lblDays);
		
		JButton btnNewButton_1 = new JButton("View Goal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(581, 190, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextArea txtrStickToThe = new JTextArea();
		txtrStickToThe.setLineWrap(true);
		txtrStickToThe.setBackground(Color.PINK);
		txtrStickToThe.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrStickToThe.setForeground(Color.RED);
		txtrStickToThe.setText("Stick to the Goal\r\n,Be healthier");
		txtrStickToThe.setBounds(526, 235, 199, 63);
		frame.getContentPane().add(txtrStickToThe);
		
		JCheckBox chckbxOptions = new JCheckBox("options");
		chckbxOptions.setBounds(381, 40, 113, 25);
		frame.getContentPane().add(chckbxOptions);
		
		JCheckBox checkBox = new JCheckBox("options");
		checkBox.setBounds(381, 69, 113, 25);
		frame.getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("options");
		checkBox_1.setBounds(381, 98, 113, 25);
		frame.getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("options");
		checkBox_2.setBounds(381, 127, 113, 25);
		frame.getContentPane().add(checkBox_2);
		
		JTextArea txtrOnGoingGoals = new JTextArea();
		txtrOnGoingGoals.setText("On Going Goals: ");
		txtrOnGoingGoals.setLineWrap(true);
		txtrOnGoingGoals.setForeground(Color.ORANGE);
		txtrOnGoingGoals.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrOnGoingGoals.setBackground(Color.GRAY);
		txtrOnGoingGoals.setBounds(526, 41, 199, 63);
		frame.getContentPane().add(txtrOnGoingGoals);
		
		JTextArea txtrFinishedGoals = new JTextArea();
		txtrFinishedGoals.setText("Finished Goals:");
		txtrFinishedGoals.setLineWrap(true);
		txtrFinishedGoals.setForeground(Color.ORANGE);
		txtrFinishedGoals.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrFinishedGoals.setBackground(Color.GRAY);
		txtrFinishedGoals.setBounds(526, 117, 199, 63);
		frame.getContentPane().add(txtrFinishedGoals);
	}
}
