package cse360.health_tracker;

import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class TableExample {

    //Note: Typically the main method will be in a
    //separate class. As this is a simple one class
    //example it's all in the one class.
    public static void main(String[] args) {
     
         //Use the event dispatch thread for Swing components
         EventQueue.invokeLater(new Runnable()
         {
             
            @Override
             public void run()
             {
                 
                 try {
					new TableExample();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}         
             }
         });
              
    }
    
    public TableExample() throws IOException
    {
        JFrame guiFrame = new JFrame();
        
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Creating a Table Example");
        guiFrame.setSize(700,200);
      
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        
        //Create the JTable using the ExampleTableModel implementing 
        //the AbstractTableModel abstract class
        JTable table = new JTable(0,3);
        
        //Set the column sorting functionality on
        //table.setAutoCreateRowSorter(true);
        
        //Uncomment the next line if you want to turn the grid lines off
      //  table.setShowGrid(false);
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setColumnIdentifiers(new Object[]{"aa","bb","cc"});
        model.addRow(new Object[]{"Hugues", "Duboscq", "France" });
        //Change the colour of the table - yellow for gridlines 
        //blue for background
        table.setGridColor(Color.YELLOW);
        table.setBackground(Color.CYAN);

        //String array to populate the combobox options
        /*String[] countries = {"Australia", "Brazil", "Canada", "China"
                    ,"France", "Japan", "Norway", "Russia", "South Korea"
                    , "Tunisia", "USA"};*/
        /*JComboBox countryCombo = new JComboBox(countries);
       
        //Set the default editor for the Country column to be the combobox
        TableColumn countryColumn = table.getColumnModel().getColumn(2);
        countryColumn.setCellEditor(new DefaultCellEditor(countryCombo));*/
       
        //set the Event column to be larger than the rest and the Place column 
        //to be smaller
       /* TableColumn eventColumn = table.getColumnModel().getColumn(3);
        eventColumn.setPreferredWidth(150);
        
        TableColumn placeColumn = table.getColumnModel().getColumn(4);
        placeColumn.setPreferredWidth(5);*/
        
        //Place the JTable object in a JScrollPane for a scrolling table
        JScrollPane tableScrollPane = new JScrollPane(table);
        
        guiFrame.add(tableScrollPane);
        guiFrame.setVisible(true);
        createImage(table);
    }
   
    
    public static BufferedImage createImage(JTable table) throws IOException {
        JTableHeader tableHeaderComp = table.getTableHeader();
        int totalWidth = /*tableHeaderComp.getWidth() +*/ table.getWidth();
        int totalHeight = tableHeaderComp.getHeight() + table.getHeight();
        BufferedImage tableImage = new BufferedImage(totalWidth, totalHeight,
            BufferedImage.TYPE_INT_RGB);
        Graphics2D g2D = (Graphics2D) tableImage.getGraphics();
        tableHeaderComp.paint(g2D);
        g2D.translate(0, tableHeaderComp.getHeight());
        table.paint(g2D);
        
        File outputfile = new File("image.jpg");
        ImageIO.write(tableImage, "jpg", outputfile);
        
        return tableImage;
      }
}
