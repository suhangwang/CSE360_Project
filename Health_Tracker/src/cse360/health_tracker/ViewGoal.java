package cse360.health_tracker;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;

public class ViewGoal extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewGoal dialog = new ViewGoal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewGoal() {
		setBounds(100, 100, 480, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblOngingGoals = new JLabel("Onging Goals");
		lblOngingGoals.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOngingGoals.setForeground(new Color(0, 0, 0));
		lblOngingGoals.setBounds(10, 10, 113, 54);
		contentPanel.add(lblOngingGoals);
		
		JLabel lblFinishedGoals = new JLabel("Finished Goals");
		lblFinishedGoals.setForeground(Color.BLACK);
		lblFinishedGoals.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFinishedGoals.setBounds(10, 173, 113, 54);
		contentPanel.add(lblFinishedGoals);
		
		JButton btnProgress = new JButton("Progress");
		btnProgress.setBounds(127, 173, 97, 25);
		contentPanel.add(btnProgress);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBounds(232, 173, 97, 25);
		contentPanel.add(btnModify);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(335, 173, 97, 25);
		contentPanel.add(btnDelete);
		
		JButton btnDetails = new JButton("Details");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDetails.setBounds(232, 334, 97, 25);
		contentPanel.add(btnDetails);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(335, 334, 97, 25);
		contentPanel.add(btnDelete_1);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("");
		chckbxmntmNewCheckItem.setBackground(new Color(255, 255, 255));
		chckbxmntmNewCheckItem.setBounds(135, 55, 257, 105);
		contentPanel.add(chckbxmntmNewCheckItem);
		
		JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("New check item");
		checkBoxMenuItem.setBackground(Color.WHITE);
		checkBoxMenuItem.setBounds(127, 211, 257, 105);
		contentPanel.add(checkBoxMenuItem);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(150, 55, 113, 25);
		contentPanel.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("New check box");
		checkBox.setBounds(150, 85, 113, 25);
		contentPanel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("New check box");
		checkBox_1.setBounds(150, 118, 113, 25);
		contentPanel.add(checkBox_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
