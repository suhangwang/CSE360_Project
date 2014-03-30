package cse360.health_tracker;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Panel;
import java.awt.Font;

public class addRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterHere;
	private JTextField txtEnterHere_2;
	private JTextField txtEnterHere_1;
	private JTextField txtEnterHere_3;
	private JTextField txtEnterHere_4;
	private JTextField txtEnterHere_5;
	private JTextField txtEnterHere_6;
	private JTextField txtEnterHere_7;
	private JTextField txtEnterHere_8;
	private JTextField txtEnterHere_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addRecord frame = new addRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterHere = new JTextField();
		txtEnterHere.setText("Enter Here");
		txtEnterHere.setBounds(149, 125, 116, 22);
		contentPane.add(txtEnterHere);
		txtEnterHere.setColumns(10);
		
		txtEnterHere_2 = new JTextField();
		txtEnterHere_2.setText("Enter Here");
		txtEnterHere_2.setColumns(10);
		txtEnterHere_2.setBounds(149, 219, 116, 22);
		contentPane.add(txtEnterHere_2);
		
		txtEnterHere_1 = new JTextField();
		txtEnterHere_1.setText("Enter Here");
		txtEnterHere_1.setColumns(10);
		txtEnterHere_1.setBounds(149, 171, 116, 22);
		contentPane.add(txtEnterHere_1);
		
		txtEnterHere_3 = new JTextField();
		txtEnterHere_3.setText("Enter Here");
		txtEnterHere_3.setColumns(10);
		txtEnterHere_3.setBounds(149, 270, 116, 22);
		contentPane.add(txtEnterHere_3);
		
		txtEnterHere_4 = new JTextField();
		txtEnterHere_4.setText("Enter Here");
		txtEnterHere_4.setColumns(10);
		txtEnterHere_4.setBounds(149, 322, 116, 22);
		contentPane.add(txtEnterHere_4);
		
		txtEnterHere_5 = new JTextField();
		txtEnterHere_5.setText("Enter Here");
		txtEnterHere_5.setColumns(10);
		txtEnterHere_5.setBounds(571, 125, 116, 22);
		contentPane.add(txtEnterHere_5);
		
		txtEnterHere_6 = new JTextField();
		txtEnterHere_6.setText("Enter Here");
		txtEnterHere_6.setColumns(10);
		txtEnterHere_6.setBounds(571, 171, 116, 22);
		contentPane.add(txtEnterHere_6);
		
		txtEnterHere_7 = new JTextField();
		txtEnterHere_7.setText("Enter Here");
		txtEnterHere_7.setColumns(10);
		txtEnterHere_7.setBounds(571, 219, 116, 22);
		contentPane.add(txtEnterHere_7);
		
		txtEnterHere_8 = new JTextField();
		txtEnterHere_8.setText("Enter Here");
		txtEnterHere_8.setColumns(10);
		txtEnterHere_8.setBounds(571, 270, 116, 22);
		contentPane.add(txtEnterHere_8);
		
		txtEnterHere_9 = new JTextField();
		txtEnterHere_9.setText("Enter Here");
		txtEnterHere_9.setColumns(10);
		txtEnterHere_9.setBounds(571, 322, 116, 22);
		contentPane.add(txtEnterHere_9);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBounds(40, 357, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(277, 357, 97, 25);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(462, 357, 97, 25);
		contentPane.add(btnReset);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.setBounds(699, 357, 97, 25);
		contentPane.add(btnSubmit_1);
		
		JTextArea txtrCardioWokrout = new JTextArea();
		txtrCardioWokrout.setBackground(SystemColor.menu);
		txtrCardioWokrout.setText("Cardio Wokrout");
		txtrCardioWokrout.setBounds(0, 125, 125, 22);
		contentPane.add(txtrCardioWokrout);
		
		JTextArea txtrStrengthWorkout = new JTextArea();
		txtrStrengthWorkout.setText("Strength Workout");
		txtrStrengthWorkout.setBackground(SystemColor.menu);
		txtrStrengthWorkout.setBounds(0, 171, 125, 22);
		contentPane.add(txtrStrengthWorkout);
		
		JTextArea txtrWorkHour = new JTextArea();
		txtrWorkHour.setText("Work Hour");
		txtrWorkHour.setBackground(SystemColor.menu);
		txtrWorkHour.setBounds(0, 219, 125, 22);
		contentPane.add(txtrWorkHour);
		
		JTextArea txtrSleepHour = new JTextArea();
		txtrSleepHour.setText("Sleep Hour");
		txtrSleepHour.setBackground(SystemColor.menu);
		txtrSleepHour.setBounds(0, 270, 125, 22);
		contentPane.add(txtrSleepHour);
		
		JTextArea txtrRecreactionHour = new JTextArea();
		txtrRecreactionHour.setText("Recreaction Hour");
		txtrRecreactionHour.setBackground(SystemColor.menu);
		txtrRecreactionHour.setBounds(0, 322, 125, 22);
		contentPane.add(txtrRecreactionHour);
		
		JTextArea txtrBloodPressure = new JTextArea();
		txtrBloodPressure.setText("Blood Pressure");
		txtrBloodPressure.setBackground(SystemColor.menu);
		txtrBloodPressure.setBounds(434, 125, 125, 22);
		contentPane.add(txtrBloodPressure);
		
		JTextArea txtrBloodSuger = new JTextArea();
		txtrBloodSuger.setText("Blood Suger");
		txtrBloodSuger.setBackground(SystemColor.menu);
		txtrBloodSuger.setBounds(434, 171, 125, 22);
		contentPane.add(txtrBloodSuger);
		
		JTextArea txtrPulseRate = new JTextArea();
		txtrPulseRate.setText("Pulse Rate");
		txtrPulseRate.setBackground(SystemColor.menu);
		txtrPulseRate.setBounds(434, 219, 125, 22);
		contentPane.add(txtrPulseRate);
		
		JTextArea txtrBodyTempreture = new JTextArea();
		txtrBodyTempreture.setText("Body Tempreture");
		txtrBodyTempreture.setBackground(SystemColor.menu);
		txtrBodyTempreture.setBounds(434, 270, 125, 22);
		contentPane.add(txtrBodyTempreture);
		
		JTextArea txtrWeight = new JTextArea();
		txtrWeight.setText("Weight");
		txtrWeight.setBackground(SystemColor.menu);
		txtrWeight.setBounds(434, 322, 125, 22);
		contentPane.add(txtrWeight);
		
		JTextArea txtrHour = new JTextArea();
		txtrHour.setText("Hour");
		txtrHour.setBackground(SystemColor.menu);
		txtrHour.setBounds(277, 125, 125, 22);
		contentPane.add(txtrHour);
		
		JTextArea txtrHour_1 = new JTextArea();
		txtrHour_1.setText("Hour");
		txtrHour_1.setBackground(SystemColor.menu);
		txtrHour_1.setBounds(277, 171, 125, 22);
		contentPane.add(txtrHour_1);
		
		JTextArea txtrHour_2 = new JTextArea();
		txtrHour_2.setText("Hour");
		txtrHour_2.setBackground(SystemColor.menu);
		txtrHour_2.setBounds(277, 219, 125, 22);
		contentPane.add(txtrHour_2);
		
		JTextArea txtrHour_3 = new JTextArea();
		txtrHour_3.setText("Hour");
		txtrHour_3.setBackground(SystemColor.menu);
		txtrHour_3.setBounds(277, 270, 125, 22);
		contentPane.add(txtrHour_3);
		
		JTextArea txtrHour_4 = new JTextArea();
		txtrHour_4.setText("Hour");
		txtrHour_4.setBackground(SystemColor.menu);
		txtrHour_4.setBounds(277, 322, 125, 22);
		contentPane.add(txtrHour_4);
		
		JTextArea txtrMmhg = new JTextArea();
		txtrMmhg.setText("mm/Hg");
		txtrMmhg.setBackground(SystemColor.menu);
		txtrMmhg.setBounds(699, 125, 125, 22);
		contentPane.add(txtrMmhg);
		
		JTextArea txtrMgdl = new JTextArea();
		txtrMgdl.setText("mg/dl");
		txtrMgdl.setBackground(SystemColor.menu);
		txtrMgdl.setBounds(699, 171, 125, 22);
		contentPane.add(txtrMgdl);
		
		JTextArea txtrBpm = new JTextArea();
		txtrBpm.setText("BPM");
		txtrBpm.setBackground(SystemColor.menu);
		txtrBpm.setBounds(699, 219, 125, 22);
		contentPane.add(txtrBpm);
		
		JTextArea txtrF = new JTextArea();
		txtrF.setText("F");
		txtrF.setBackground(SystemColor.menu);
		txtrF.setBounds(699, 270, 125, 22);
		contentPane.add(txtrF);
		
		JTextArea txtrLb = new JTextArea();
		txtrLb.setText("lb");
		txtrLb.setBackground(SystemColor.menu);
		txtrLb.setBounds(699, 322, 125, 22);
		contentPane.add(txtrLb);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 824, 34);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnRecords = new JMenu("Records");
		menuBar.add(mnRecords);
		
		JMenuItem mntmAddRecord = new JMenuItem("Add Record");
		mnRecords.add(mntmAddRecord);
		
		JMenuItem mntmModifyRecord = new JMenuItem("Modify Record");
		mnRecords.add(mntmModifyRecord);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JRadioButtonMenuItem rdbtnmntmWeekly = new JRadioButtonMenuItem("Weekly");
		mnView.add(rdbtnmntmWeekly);
		
		JRadioButtonMenuItem rdbtnmntmMonthly = new JRadioButtonMenuItem("Monthly");
		mnView.add(rdbtnmntmMonthly);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Table");
		mnView.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmGraph = new JRadioButtonMenuItem("Graph");
		mnView.add(rdbtnmntmGraph);
		
		JMenu mnMygoal = new JMenu("MyGoal");
		menuBar.add(mnMygoal);
		
		JMenuItem mntmSetGoal = new JMenuItem("Set Goal");
		mnMygoal.add(mntmSetGoal);
		
		JMenuItem mntmViewGoal = new JMenuItem("View Goal");
		mnMygoal.add(mntmViewGoal);
		
		JMenu mnPrint = new JMenu("Print");
		menuBar.add(mnPrint);
		
		JMenuItem mntmPrintToPdf = new JMenuItem("Print to PDF");
		mnPrint.add(mntmPrintToPdf);
		
		JMenuItem mntmPrintToPrinter = new JMenuItem("Print to Printer");
		mnPrint.add(mntmPrintToPrinter);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JTextArea txtrPhysicalActivity = new JTextArea();
		txtrPhysicalActivity.setForeground(Color.RED);
		txtrPhysicalActivity.setFont(new Font("Lucida Fax", Font.BOLD, 28));
		txtrPhysicalActivity.setText("Physical Activity");
		txtrPhysicalActivity.setBackground(SystemColor.info);
		txtrPhysicalActivity.setBounds(0, 40, 374, 72);
		contentPane.add(txtrPhysicalActivity);
		
		JTextArea txtrHealthIndicator = new JTextArea();
		txtrHealthIndicator.setForeground(Color.RED);
		txtrHealthIndicator.setFont(new Font("Lucida Fax", Font.BOLD, 28));
		txtrHealthIndicator.setText("Health Indicator");
		txtrHealthIndicator.setBackground(SystemColor.info);
		txtrHealthIndicator.setBounds(434, 40, 390, 72);
		contentPane.add(txtrHealthIndicator);
		
		
	}
}

