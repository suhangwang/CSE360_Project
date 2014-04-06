package cse360.health_tracker;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;

public class ViewReport {

	private JFrame frmViewReport;
	private JTextArea txtMonthly;
	private JTextArea txtrnMonthlynHistogram;
	private JButton btnPrintToPdf;
	private JButton btnPrintToPrinter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReport window = new ViewReport();
					window.frmViewReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public ViewReport() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmViewReport = new JFrame();
		frmViewReport.getContentPane().setBackground(new Color(245, 245, 220));
		frmViewReport.setResizable(false);
		frmViewReport.setTitle("View Report");
		frmViewReport.setBounds(100, 100, 900, 720);
		frmViewReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewReport.getContentPane().setLayout(null);
		
		JLabel lblLineChart = new JLabel("Line Chart");
		lblLineChart.setBounds(0, 0, 600, frmViewReport.getHeight()/2);
		File directory = new File(".");
		final String dir = directory.getCanonicalPath();
		ImageIcon iconLine = new ImageIcon(dir+"/img/LineChart.png");
		Image tempLine = iconLine.getImage().getScaledInstance(lblLineChart.getWidth(), lblLineChart.getHeight(), iconLine.getImage().SCALE_DEFAULT);
		iconLine = new ImageIcon(tempLine);
		lblLineChart.setIcon(iconLine);
		frmViewReport.getContentPane().add(lblLineChart);
		
		JLabel lblHistogram = new JLabel("New label");
		lblHistogram.setBounds(0, frmViewReport.getHeight()/2, 600, frmViewReport.getHeight()/2);
		ImageIcon iconHistogram = new ImageIcon(dir+"/img/Histogram.jpg");
		Image tempHistogram = iconHistogram.getImage().getScaledInstance(lblHistogram.getWidth(), lblHistogram.getHeight(), iconHistogram.getImage().SCALE_DEFAULT);
		iconHistogram = new ImageIcon(tempHistogram);
		lblHistogram.setIcon(iconHistogram);
		frmViewReport.getContentPane().add(lblHistogram);
		
		txtMonthly = new JTextArea();
		txtMonthly.setFont(new Font("Dialog", Font.PLAIN, 36));
		txtMonthly.setBackground(new Color(250, 235, 215));
		//txtMonthly.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonthly.setForeground(Color.RED);
		txtMonthly.setEditable(false);
		txtMonthly.setText("\n       Montly \n    LineChart");
		txtMonthly.setBounds(lblLineChart.getWidth(), 0, frmViewReport.getWidth()-lblLineChart.getWidth(), 200);
		frmViewReport.getContentPane().add(txtMonthly);
		txtMonthly.setColumns(10);
		
		JButton btnSwitchToWeekly = new JButton("Switch to Weekly");
		btnSwitchToWeekly.setBounds(667, 236, 176, 25);
		frmViewReport.getContentPane().add(btnSwitchToWeekly);
		
		txtrnMonthlynHistogram = new JTextArea();
		txtrnMonthlynHistogram.setFont(new Font("Dialog", Font.PLAIN, 36));
		txtrnMonthlynHistogram.setBackground(new Color(250, 235, 215));
		txtrnMonthlynHistogram.setForeground(new Color(255, 0, 0));
		txtrnMonthlynHistogram.setText("\n      Monthly\n     Histogram");
		txtrnMonthlynHistogram.setEditable(false);
		txtrnMonthlynHistogram.setBounds(lblLineChart.getWidth(), frmViewReport.getHeight()/2, frmViewReport.getWidth()-lblLineChart.getWidth(), 200);
		frmViewReport.getContentPane().add(txtrnMonthlynHistogram);
		
		btnPrintToPdf = new JButton("Print to pdf");
		btnPrintToPdf.setBounds(686, 603, 117, 25);
		frmViewReport.getContentPane().add(btnPrintToPdf);
		
		btnPrintToPrinter = new JButton("Print to printer");
		btnPrintToPrinter.setBounds(674, 640, 147, 25);
		frmViewReport.getContentPane().add(btnPrintToPrinter);
	}
}
