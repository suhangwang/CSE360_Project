package cse360.health_tracker;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuBar {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBar window = new MenuBar();
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
	public MenuBar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// add JMenuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, frame.getWidth(), 22);
		frame.getContentPane().add(menuBar);
		
		// add JMenu to menuBar
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setBounds(0, 0, 40, 22);
		menuBar.add(mnFile);
		
		JMenu mnRecords = new JMenu("Records");
		mnRecords.setMnemonic('R');
		mnRecords.setBounds(40, 0, 40, 22);
		menuBar.add(mnRecords);
		
		JMenu mnView = new JMenu("View");
		mnView.setMnemonic('V');
		mnView.setBounds(80, 0, 40, 22);
		menuBar.add(mnView);
		
		JMenu mnMygoal = new JMenu("MyGoal");
		mnMygoal.setMnemonic('G');
		mnMygoal.setBounds(120, 0, 40, 22);
		menuBar.add(mnMygoal);
		
		JMenu mnPrint = new JMenu("Print");
		mnPrint.setMnemonic('P');
		mnPrint.setBounds(160, 0, 40, 22);
		menuBar.add(mnPrint);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		mnHelp.setBounds(200, 0, 40, 22);
		menuBar.add(mnHelp);
		
		// add JMenuItem to JMenu: File
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setMnemonic('S');
		mntmSave.setBounds(0, 0, 40, 22);
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic('E');
		mntmExit.setBounds(0, 0, 40, 22);
		mnFile.add(mntmExit);
		
		// add JMenuItem to JMenu: Records
		JMenuItem mntmAddRecord = new JMenuItem("Add Record");
		mntmAddRecord.setMnemonic('A');
		mntmAddRecord.setBounds(40, 0, 40, 22);
		mnRecords.add(mntmAddRecord);
		
		JMenuItem mntmModifyRecord = new JMenuItem("Modify Record");
		mntmModifyRecord.setMnemonic('M');
		mntmModifyRecord.setBounds(40, 0, 40, 22);
		mnRecords.add(mntmModifyRecord);
		
		// add JMenuItem to JMenu: View
		ButtonGroup timeButtonGroup = new ButtonGroup();		
		
		JRadioButtonMenuItem rdbtnmntmWeekly = new JRadioButtonMenuItem("Weekly");
		rdbtnmntmWeekly.setMnemonic('W');
		rdbtnmntmWeekly.setBounds(80, 0, 40, 22);
		timeButtonGroup.add(rdbtnmntmWeekly);
		mnView.add(rdbtnmntmWeekly);
		
		JRadioButtonMenuItem rdbtnmntmMonthly = new JRadioButtonMenuItem("Monthly");
		rdbtnmntmMonthly.setMnemonic('W');
		rdbtnmntmMonthly.setBounds(80, 0, 40, 22);
		timeButtonGroup.add(rdbtnmntmMonthly);
		mnView.add(rdbtnmntmMonthly);
		
		mnView.addSeparator();
		
		ButtonGroup tableButtonGroup = new ButtonGroup();
		JRadioButtonMenuItem rdbtnmntmTable = new JRadioButtonMenuItem("Table");
		rdbtnmntmTable.setMnemonic('T');
		rdbtnmntmTable.setBounds(80, 0, 40, 22);
		tableButtonGroup.add(rdbtnmntmTable);
		mnView.add(rdbtnmntmTable);
		
		JRadioButtonMenuItem rdbtnmntmGraph = new JRadioButtonMenuItem("Graph");
		rdbtnmntmGraph.setMnemonic('G');
		rdbtnmntmGraph.setBounds(80, 0, 40, 22);
		tableButtonGroup.add(rdbtnmntmGraph);
		mnView.add(rdbtnmntmGraph);
		
		// add JMenuItem to JMenu: Goal
		JMenuItem mntmSetGoal = new JMenuItem("Set Goal");
		mntmSetGoal.setMnemonic('S');
		mntmSetGoal.setBounds(120, 0, 40, 22);
		mnMygoal.add(mntmSetGoal);
		
		JMenuItem mntmViewGoal = new JMenuItem("View Goal");
		mntmViewGoal.setMnemonic('E');
		mntmViewGoal.setBounds(120, 0, 40, 22);
		mnMygoal.add(mntmViewGoal);
		
		// add JMenuItem to JMenu: Printer
		JMenuItem mntmPdf = new JMenuItem("Print to PDF");
		mntmPdf.setMnemonic('D');
		mntmPdf.setBounds(160, 0, 40, 22);
		mnPrint.add(mntmPdf);
		
		JMenuItem mntmPrinter = new JMenuItem("Print to Printer");
		mntmPrinter.setMnemonic('R');
		mntmPrinter.setBounds(160, 0, 40, 22);
		mnPrint.add(mntmPrinter);
	}
}
