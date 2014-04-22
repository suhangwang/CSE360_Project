package cse360.health_tracker;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class HelpInfo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpInfo window = new HelpInfo();
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
	public HelpInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JTextArea lblNewLabel = new JTextArea("Health Tracker v1.1 \n\n" + "CSE360 Group Project\n\n" +
				"Authors: \n    Suhang Wang: swang187@asu.edu \n    Abdulmajeed AlMudarres: "
				+ "majoodmud@gmail.com \n    Mohamed Alameri: mohamed.alameri90@gmail.com \n\nAll rights reserved");
		lblNewLabel.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel.setEditable(false);
		lblNewLabel.setBounds(40, 60, 390, 180);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}
