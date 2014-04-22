package cse360.health_tracker;


import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

//import java.sql.Date;

public class AddRecord extends JFrame {
	private JFrame frame;
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
	private JLabel txtrHour, txtrHour_1, txtrHour_2, txtrHour_3, txtrHour_4;
	private JLabel txtrMmhg, txtrMgdl, txtrBpm, txtrF, txtrLb;
	private String username1, password1;
	private JLabel lblPhySucc;
	private JLabel lblHealSucc;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecord frame = new AddRecord("admin","admin");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public AddRecord(final String username, String password) throws IOException {
		frame = this;
		username1 = username;
		password1 = password;
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 824, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearPhysical();
				txtEnterHere.setText("Enter Here");
				txtEnterHere_1.setText("Enter Here");
				txtEnterHere_2.setText("Enter Here");
				txtEnterHere_3.setText("Enter Here");
				txtEnterHere_4.setText("Enter Here");
				txtEnterHere_5.setText("Enter Here");
			}
		});
		btnNewButton.setBounds(40, 357, 97, 25);
		contentPane.add(btnNewButton);
		
		
		txtrHour = new JLabel();
		txtrHour.setText("Hour");
		txtrHour.setBackground(SystemColor.menu);
		txtrHour.setBounds(277, 125, 125, 22);
		contentPane.add(txtrHour);
		
		txtrHour_1 = new JLabel();
		txtrHour_1.setText("Hour");
		txtrHour_1.setBackground(SystemColor.menu);
		txtrHour_1.setBounds(277, 171, 125, 22);
		contentPane.add(txtrHour_1);
		
		txtrHour_2 = new JLabel();
		txtrHour_2.setText("Hour");
		txtrHour_2.setBackground(SystemColor.menu);
		txtrHour_2.setBounds(277, 219, 125, 22);
		contentPane.add(txtrHour_2);
		
		txtrHour_3 = new JLabel();
		txtrHour_3.setText("Hour");
		txtrHour_3.setBackground(SystemColor.menu);
		txtrHour_3.setBounds(277, 270, 125, 22);
		contentPane.add(txtrHour_3);
		
		txtrHour_4 = new JLabel();
		txtrHour_4.setText("Hour");
		txtrHour_4.setBackground(SystemColor.menu);
		txtrHour_4.setBounds(277, 322, 125, 22);
		contentPane.add(txtrHour_4);
		
		txtrMmhg = new JLabel();
		txtrMmhg.setText("mm/Hg");
		txtrMmhg.setBackground(SystemColor.menu);
		txtrMmhg.setBounds(699, 125, 125, 22);
		contentPane.add(txtrMmhg);
		
		txtrMgdl = new JLabel();
		txtrMgdl.setText("mg/dl");
		txtrMgdl.setBackground(SystemColor.menu);
		txtrMgdl.setBounds(699, 171, 125, 22);
		contentPane.add(txtrMgdl);
		
		txtrBpm = new JLabel();
		txtrBpm.setText("BPM");
		txtrBpm.setBackground(SystemColor.menu);
		txtrBpm.setBounds(699, 219, 125, 22);
		contentPane.add(txtrBpm);
		
		txtrF = new JLabel();
		txtrF.setText("F");
		txtrF.setBackground(SystemColor.menu);
		txtrF.setBounds(699, 270, 125, 22);
		contentPane.add(txtrF);
		
		txtrLb = new JLabel();
		txtrLb.setText("lb");
		txtrLb.setBackground(SystemColor.menu);
		txtrLb.setBounds(699, 322, 125, 22);
		contentPane.add(txtrLb);
		
		lblPhySucc = new JLabel("add successful");
		lblPhySucc.setForeground(SystemColor.red);
		lblPhySucc.setBounds(150, 357, 120, 22);
		lblPhySucc.setVisible(false);
		contentPane.add(lblPhySucc);
		
		lblHealSucc = new JLabel("add successfil");
		lblHealSucc.setForeground(SystemColor.red);
		lblHealSucc.setBounds(580, 357, 120, 22);
		lblHealSucc.setVisible(false);
		contentPane.add(lblHealSucc);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cardio = txtEnterHere.getText();
				String strength = txtEnterHere_1.getText();
				String work = txtEnterHere_2.getText();
				String sleep = txtEnterHere_3.getText();
				String recreation = txtEnterHere_4.getText();
				boolean errorExist = false;
				// convert to integer
				double cardioDou=0, strengthDou=0, workDou=0, sleepDou=0, recreationDou=0;
				
				if(isNumeric(cardio) && Double.parseDouble(cardio) >=0 && Double.parseDouble(cardio) < 24)
					cardioDou = Double.parseDouble(cardio);
				else
				{
					txtrHour.setText("Hour ! 0 to 24");
					txtrHour.setForeground(SystemColor.red);
					errorExist = true;
				}
				if(isNumeric(strength) && Double.parseDouble(strength) >=0 && Double.parseDouble(strength) < 24)
					strengthDou = Double.parseDouble(strength);
				else
				{
					txtrHour_1.setText("Hour ! 0 to 24");
					txtrHour_1.setForeground(SystemColor.red);
					errorExist = true;
				}
				if(isNumeric(work) && Double.parseDouble(work) >=0 && Double.parseDouble(work) < 24)
					workDou = Double.parseDouble(work);
				else
				{
					txtrHour_2.setText("Hour ! 0 to 24");
					txtrHour_2.setForeground(SystemColor.red);
					errorExist = true;
				}
				if(isNumeric(sleep) && Double.parseDouble(sleep) >=0 && Double.parseDouble(sleep) < 24)
					sleepDou = Double.parseDouble(sleep);
				else
				{
					txtrHour_3.setText("Hour ! 0 to 24");
					txtrHour_3.setForeground(SystemColor.red);
					errorExist = true;
				}
				if(isNumeric(recreation) && Double.parseDouble(recreation) >=0 && Double.parseDouble(recreation) < 24)
					recreationDou = Double.parseDouble(recreation);
				else
				{
					txtrHour_4.setText("Hour ! 0 to 24");
					txtrHour_4.setForeground(SystemColor.red);
					errorExist = true;
				}
				double totalHour = cardioDou + strengthDou + workDou + sleepDou + recreationDou;
				if(!errorExist && totalHour>24)
				{
					new ErrorMessage("total hour should not be larger than 24");
					errorExist = true;
				}
				// put the data into database
				if(errorExist==false)
				{
					/*Calendar c = Calendar.getInstance();
					c.setTime(new Date());
					String date = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DATE);
					System.out.println(date);*/
					Date time= new java.sql.Date(new java.util.Date().getTime());
					System.out.println(time);
					clearPhysical();
					boolean added = MySQLDB.addNewPhysicalActivityRecord(username1, password1, time.toString(), cardioDou, strengthDou, workDou, sleepDou, recreationDou);
					if(added)
						lblPhySucc.setText("add successful");
					else
						lblPhySucc.setText("already exist");
					lblPhySucc.setVisible(true);
				}
			}
		});
		btnSubmit.setBounds(277, 357, 97, 25);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearHealth();
				txtEnterHere_5.setText("Enter Here");
				txtEnterHere_6.setText("Enter Here");
				txtEnterHere_7.setText("Enter Here");
				txtEnterHere_8.setText("Enter Here");
				txtEnterHere_9.setText("Enter Here");
			}
		});
		btnReset.setBounds(462, 357, 97, 25);
		contentPane.add(btnReset);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pressure = txtEnterHere_5.getText();
				String suger = txtEnterHere_6.getText();
				String rate = txtEnterHere_7.getText();
				String temperature = txtEnterHere_8.getText();
				String weight = txtEnterHere_9.getText();
				double pressureDou=0, sugerDou=0, rateDou=0, temperatureDou=0, weightDou=0;
				
				boolean errorExist = false;
				
				if(isNumeric(pressure))
					pressureDou = Double.parseDouble(pressure);
				else
				{
					txtrMmhg.setText("Mn/hg ! double");
					txtrMmhg.setForeground(SystemColor.red);
					errorExist = true;
				}
				if(isNumeric(suger))
					sugerDou = Double.parseDouble(suger);
				else
				{
					txtrMgdl.setText("Mg/dl ! double");
					txtrMgdl.setForeground(SystemColor.red);
					errorExist = true;
				}
				if(isNumeric(rate))
					rateDou = Double.parseDouble(rate);
				else
				{
					txtrBpm.setText("Bpm ! double");
					txtrBpm.setForeground(SystemColor.red);
					errorExist = true;
				}
				if(isNumeric(temperature))
					temperatureDou = Double.parseDouble(temperature);
				else
				{
					txtrF.setText("F ! double");
					txtrF.setForeground(SystemColor.red);
					errorExist = true;
				}
				if(isNumeric(weight))
					weightDou = Double.parseDouble(weight);
				else
				{
					txtrLb.setText("Lb ! double");
					txtrLb.setForeground(SystemColor.red);
					errorExist = true;
				}
				if(errorExist==false)
				{
					/*Calendar c = Calendar.getInstance();
					c.setTime(new Date());
					String date = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DATE);
					System.out.println(date);*/
					clearHealth();
					Date time= new java.sql.Date(new java.util.Date().getTime());
					System.out.println(time);
					boolean added = MySQLDB.addNewHealthIndicatorRecord(username1, password1, time.toString(), pressureDou, sugerDou, rateDou, temperatureDou, weightDou);
					if(added)
						lblHealSucc.setText("add successful");
					else
						lblHealSucc.setText("already exist");
					lblHealSucc.setVisible(true);
				}
			}
		});
		btnSubmit_1.setBounds(699, 357, 97, 25);
		contentPane.add(btnSubmit_1);
		
		JLabel txtrCardioWokrout = new JLabel();
		txtrCardioWokrout.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrCardioWokrout.setBackground(new Color(250, 235, 215));
		txtrCardioWokrout.setText("Cardio Wokrout");
		txtrCardioWokrout.setBounds(0, 125, 125, 22);
		contentPane.add(txtrCardioWokrout);
		
		JLabel txtrStrengthWorkout = new JLabel();
		txtrStrengthWorkout.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrStrengthWorkout.setText("Strength Workout");
		txtrStrengthWorkout.setBackground(new Color(250, 235, 215));
		txtrStrengthWorkout.setBounds(0, 171, 125, 22);
		contentPane.add(txtrStrengthWorkout);
		
		JLabel txtrWorkHour = new JLabel();
		txtrWorkHour.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrWorkHour.setText("Work Hour");
		txtrWorkHour.setBackground(new Color(250, 235, 215));
		txtrWorkHour.setBounds(0, 219, 125, 22);
		contentPane.add(txtrWorkHour);
		
		JLabel txtrSleepHour = new JLabel();
		txtrSleepHour.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrSleepHour.setText("Sleep Hour");
		txtrSleepHour.setBackground(new Color(250, 235, 215));
		txtrSleepHour.setBounds(0, 270, 125, 22);
		contentPane.add(txtrSleepHour);
		
		JLabel txtrRecreactionHour = new JLabel();
		txtrRecreactionHour.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrRecreactionHour.setText("Recreaction Hour");
		txtrRecreactionHour.setBackground(new Color(250, 235, 215));
		txtrRecreactionHour.setBounds(0, 322, 125, 22);
		contentPane.add(txtrRecreactionHour);
		
		JLabel txtrBloodPressure = new JLabel();
		txtrBloodPressure.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrBloodPressure.setText("Blood Pressure");
		txtrBloodPressure.setBackground(new Color(250, 235, 215));
		txtrBloodPressure.setBounds(434, 125, 125, 22);
		contentPane.add(txtrBloodPressure);
		
		JLabel txtrBloodSuger = new JLabel();
		txtrBloodSuger.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrBloodSuger.setText("Blood Suger");
		txtrBloodSuger.setBackground(new Color(250, 235, 215));
		txtrBloodSuger.setBounds(434, 171, 125, 22);
		contentPane.add(txtrBloodSuger);
		
		JLabel txtrPulseRate = new JLabel();
		txtrPulseRate.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrPulseRate.setText("Pulse Rate");
		txtrPulseRate.setBackground(new Color(250, 235, 215));
		txtrPulseRate.setBounds(434, 219, 125, 22);
		contentPane.add(txtrPulseRate);
		
		JLabel txtrBodyTempreture = new JLabel();
		txtrBodyTempreture.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrBodyTempreture.setText("Body Tempreture");
		txtrBodyTempreture.setBackground(new Color(250, 235, 215));
		txtrBodyTempreture.setBounds(434, 270, 125, 22);
		contentPane.add(txtrBodyTempreture);
		
		JLabel txtrWeight = new JLabel();
		txtrWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		txtrWeight.setText("Weight");
		txtrWeight.setBackground(new Color(250, 235, 215));
		txtrWeight.setBounds(434, 322, 125, 22);
		contentPane.add(txtrWeight);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 824, 34);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnRecords = new JMenu("Records");
		menuBar.add(mnRecords);
		
		JMenuItem mntmAddRecord = new JMenuItem("Add Record");
		mntmAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: add record
			}
		});
		mnRecords.add(mntmAddRecord);
		
		JMenuItem mntmModifyRecord = new JMenuItem("Modify Record");
		mnRecords.add(mntmModifyRecord);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JRadioButtonMenuItem rdbtnmntmWeekly = new JRadioButtonMenuItem("Weekly");
		mnView.add(rdbtnmntmWeekly);
		
		JRadioButtonMenuItem rdbtnmntmMonthly = new JRadioButtonMenuItem("Monthly");
		rdbtnmntmMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						try {
							ViewReport window = new ViewReport(username);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
		});
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
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HelpInfo();
			}
		});
		mnHelp.add(mntmHelp);
		menuBar.add(mnHelp);
		
		JTextField txtrPhysicalActivity = new JTextField();
		txtrPhysicalActivity.setEditable(false);
		txtrPhysicalActivity.setHorizontalAlignment(SwingConstants.CENTER);
		txtrPhysicalActivity.setForeground(Color.RED);
		txtrPhysicalActivity.setFont(new Font("Lucida Fax", Font.BOLD, 28));
		txtrPhysicalActivity.setText("Physical Activity");
		txtrPhysicalActivity.setBackground(Color.YELLOW);
		txtrPhysicalActivity.setBounds(0, menuBar.getHeight(), 400, 72);
		contentPane.add(txtrPhysicalActivity);
		
		JTextField txtrHealthIndicator = new JTextField();
		txtrHealthIndicator.setEditable(false);
		txtrHealthIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		txtrHealthIndicator.setForeground(Color.RED);
		txtrHealthIndicator.setFont(new Font("Lucida Fax", Font.BOLD, 28));
		txtrHealthIndicator.setText("Health Indicator");
		txtrHealthIndicator.setBackground(new Color(255, 255, 0));
		txtrHealthIndicator.setBounds(434, menuBar.getHeight(), 390, 72);
		contentPane.add(txtrHealthIndicator);
		
		JLabel lblRunning = new JLabel("Running");
		lblRunning.setBounds(115, 390, 200, 200);
		File directory = new File(".");
		final String dir = directory.getCanonicalPath();
		ImageIcon iconRun = new ImageIcon(dir+"/img/running.jpg");
		Image temp = iconRun.getImage().getScaledInstance(lblRunning.getWidth(), lblRunning.getHeight(), iconRun.getImage().SCALE_DEFAULT);
		iconRun = new ImageIcon(temp);
		lblRunning.setIcon(iconRun);
		contentPane.add(lblRunning);
		
		JLabel lblEquip = new JLabel("Equip");
		lblEquip.setBounds(515, 390, 200, 200);
		ImageIcon iconEquip = new ImageIcon(dir+"/img/equipment.jpg");
		Image tempEquip = iconEquip.getImage().getScaledInstance(lblEquip.getWidth(), lblEquip.getHeight(), iconEquip.getImage().SCALE_DEFAULT);
		iconEquip = new ImageIcon(tempEquip);
		lblEquip.setIcon(iconEquip);
		contentPane.add(lblEquip);
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	private void clearPhysical()
	{
		txtrHour.setText("Hour");
		txtrHour.setForeground(SystemColor.black);
		txtrHour_1.setText("Hour");
		txtrHour_1.setForeground(SystemColor.black);
		txtrHour_2.setText("Hour");
		txtrHour_2.setForeground(SystemColor.black);
		txtrHour_3.setText("Hour");
		txtrHour_3.setForeground(SystemColor.black);
		txtrHour_4.setText("Hour");
		txtrHour_4.setForeground(SystemColor.black);
	}
	
	private void clearHealth()
	{
		txtrMmhg.setText("mm/Hg");
		txtrMmhg.setForeground(SystemColor.black);
		txtrMgdl.setText("mg/dl");
		txtrMgdl.setForeground(SystemColor.black);
		txtrBpm.setText("BPM");
		txtrBpm.setForeground(SystemColor.black);
		txtrF.setText("F");
		txtrF.setForeground(SystemColor.black);
		txtrLb.setText("lb");
		txtrLb.setForeground(SystemColor.black);
	}
}

