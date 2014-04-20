package cse360.health_tracker;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class ViewReport {

	private JFrame frmViewReport;
	private JTextArea txtMonthly;
	private JTextArea txtrnMonthlynHistogram;
	private JButton btnPrintToPdf;
	private JButton btnPrintToPrinter;
	private JLabel lblHealthHist;
	private JLabel lblLineChart;
	private JLabel lblHealthLine;
	boolean current = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReport window = new ViewReport("admin");
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
	public ViewReport(final String username) throws IOException {
		initialize(username);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize(final String username) throws IOException {
		frmViewReport = new JFrame();
		frmViewReport.getContentPane().setBackground(new Color(245, 245, 220));
		frmViewReport.setResizable(false);
		frmViewReport.setTitle("View Report");
		frmViewReport.setBounds(100, 100, 1500, 720);
		frmViewReport.getContentPane().setLayout(null);
		
		// generate the figures
		GenerateFigures.generateFigures(); 
		
		lblLineChart = new JLabel("Line Chart");
		lblLineChart.setBounds(0, 0, 600, frmViewReport.getHeight()/2);
		File directory = new File(".");
		final String dir = directory.getCanonicalPath();
		ImageIcon iconLine = new ImageIcon(dir+"/img/LineChart_physical.png");
		Image tempLine = iconLine.getImage().getScaledInstance(lblLineChart.getWidth(), lblLineChart.getHeight(), iconLine.getImage().SCALE_DEFAULT);
		iconLine = new ImageIcon(tempLine);
		lblLineChart.setIcon(iconLine);
		frmViewReport.getContentPane().add(lblLineChart);
		
		JLabel lblHistogram = new JLabel("New label");
		lblHistogram.setBounds(0, frmViewReport.getHeight()/2, 600, frmViewReport.getHeight()/2);
		ImageIcon iconHistogram = new ImageIcon(dir+"/img/Histogram_physical.png");
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
		txtMonthly.setText("\n       Monthly \n    LineChart");
		txtMonthly.setBounds(lblLineChart.getWidth(), 0, 300, 200);
		frmViewReport.getContentPane().add(txtMonthly);
		txtMonthly.setColumns(10);
		
		JButton btnTable = new JButton("Switch Foramt");
		btnTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(current == true)
				{
					current = false;
					ImageIcon iconLine = new ImageIcon(dir+"/img/table_physical.png");
					Image tempLine = iconLine.getImage();//.getScaledInstance(lblLineChart.getWidth(), lblLineChart.getHeight(), iconLine.getImage().SCALE_DEFAULT);
					iconLine = new ImageIcon(tempLine);
					lblLineChart.setIcon(iconLine);
					
					lblHealthLine.setBounds(lblLineChart.getWidth()+txtMonthly.getWidth(), 0, 600, frmViewReport.getHeight()/2);
					ImageIcon iconHealthLine = new ImageIcon(dir+"/img/table_health.png");
					Image tempHealthLine = iconHealthLine.getImage(); //.getScaledInstance(lblHealthLine.getWidth(), lblHealthLine.getHeight(), iconHealthLine.getImage().SCALE_DEFAULT);
					iconHealthLine = new ImageIcon(tempHealthLine);
					lblHealthLine.setIcon(iconHealthLine);
					
					txtMonthly.setText("\n       Monthly \n        Table");
				}
				else
				{
					current = true;
					ImageIcon iconLine = new ImageIcon(dir+"/img/LineChart_physical.png");
					Image tempLine = iconLine.getImage().getScaledInstance(lblLineChart.getWidth(), lblLineChart.getHeight(), iconLine.getImage().SCALE_DEFAULT);
					iconLine = new ImageIcon(tempLine);
					lblLineChart.setIcon(iconLine);
					lblHealthLine.setBounds(lblLineChart.getWidth()+txtMonthly.getWidth(), 0, 600, frmViewReport.getHeight()/2);
					ImageIcon iconHealthLine = new ImageIcon(dir+"/img/LineChart_health.png");
					Image tempHealthLine = iconHealthLine.getImage().getScaledInstance(lblHealthLine.getWidth(), lblHealthLine.getHeight(), iconHealthLine.getImage().SCALE_DEFAULT);
					iconHealthLine = new ImageIcon(tempHealthLine);
					lblHealthLine.setIcon(iconHealthLine);
					
					txtMonthly.setText("\n       Monthly \n    LineChart");
				}
			}
		});
		btnTable.setBounds(667, 236, 176, 25);
		frmViewReport.getContentPane().add(btnTable);
		
		txtrnMonthlynHistogram = new JTextArea();
		txtrnMonthlynHistogram.setFont(new Font("Dialog", Font.PLAIN, 36));
		txtrnMonthlynHistogram.setBackground(new Color(250, 235, 215));
		txtrnMonthlynHistogram.setForeground(new Color(255, 0, 0));
		txtrnMonthlynHistogram.setText("\n      Monthly\n     Histogram");
		txtrnMonthlynHistogram.setEditable(false);
		txtrnMonthlynHistogram.setBounds(lblLineChart.getWidth(), frmViewReport.getHeight()/2, 300, 200);
		frmViewReport.getContentPane().add(txtrnMonthlynHistogram);
		
		lblHealthLine = new JLabel("New label");
		lblHealthLine.setBounds(lblLineChart.getWidth()+txtMonthly.getWidth(), 0, 600, frmViewReport.getHeight()/2);
		ImageIcon iconHealthLine = new ImageIcon(dir+"/img/LineChart_health.png");
		Image tempHealthLine = iconHealthLine.getImage().getScaledInstance(lblHealthLine.getWidth(), lblHealthLine.getHeight(), iconHealthLine.getImage().SCALE_DEFAULT);
		iconHealthLine = new ImageIcon(tempHealthLine);
		lblHealthLine.setIcon(iconHealthLine);
		frmViewReport.getContentPane().add(lblHealthLine);
		
		lblHealthHist = new JLabel("New label");
		lblHealthHist.setBounds(lblLineChart.getWidth()+txtMonthly.getWidth(), frmViewReport.getHeight()/2, 600, frmViewReport.getHeight()/2);
		ImageIcon iconHealthHist = new ImageIcon(dir+"/img/Histogram_health.png");
		Image tempHealthHist = iconHealthHist.getImage().getScaledInstance(lblHealthLine.getWidth(), lblHealthLine.getHeight(), iconHealthHist.getImage().SCALE_DEFAULT);
		iconHealthHist = new ImageIcon(tempHealthHist);
		lblHealthHist.setIcon(iconHealthHist);
		frmViewReport.getContentPane().add(lblHealthHist);
		
		btnPrintToPdf = new JButton("Print to pdf");
		btnPrintToPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				ArrayList<String> imageUrllist = new ArrayList<String>();  
		        imageUrllist.add(dir + "/img/LineChart_physical.png");
		        imageUrllist.add(dir + "/img/Histogram_physical.png");
		        imageUrllist.add(dir + "/img/LineChart_health.png");
		        imageUrllist.add(dir + "/img/Histogram_health.png");
		        imageUrllist.add(dir + "/img/table_physical.png");
		        imageUrllist.add(dir + "/img/table_health.png");
		        String pdfUrl = dir + "/img/report.pdf"; 
		        File file = PdfManager.Pdf(imageUrllist, pdfUrl, username);  
		        try {  
		            file.createNewFile();  
		        } catch (IOException e) {  
		            // TODO Auto-generated catch block  
		            e.printStackTrace();  
		        }  
		        File file_pdf = new File(dir + "/img/report.pdf"); 
		        try {
					java.awt.Desktop.getDesktop().open(file_pdf);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnPrintToPdf.setBounds(686, 603, 117, 25);
		frmViewReport.getContentPane().add(btnPrintToPdf);
		
		btnPrintToPrinter = new JButton("Print to printer");
		btnPrintToPrinter.setBounds(674, 640, 147, 25);
		frmViewReport.getContentPane().add(btnPrintToPrinter);
		frmViewReport.setVisible(true);
	}
}
