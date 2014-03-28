package cse360.health_tracker;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ErrorMessage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorMessage window = new ErrorMessage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ErrorMessage(String errorMsg) {
		initialize(errorMsg);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String errorMsg) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(300, 300, errorMsg.length()*8+100, 30);
		
		JLabel errorImg = new JLabel("");
		errorImg.setBounds(0, 0, frame.getHeight(), frame.getHeight());
		ImageIcon icon = new ImageIcon(ErrorMessage.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png"));
		Image temp = icon.getImage().getScaledInstance(frame.getHeight(), frame.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		frame.getContentPane().setLayout(null);
		errorImg.setIcon(icon);
		frame.getContentPane().add(errorImg);
		
		JLabel lblNewLabel = new JLabel(errorMsg);
		lblNewLabel.setBounds(errorImg.getWidth()+5, 0, frame.getWidth()-errorImg.getWidth()-5, frame.getHeight());
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
}
