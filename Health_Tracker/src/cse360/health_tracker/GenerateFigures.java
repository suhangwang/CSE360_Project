package cse360.health_tracker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.*;
import org.jfree.ui.*;

/**
 * 创建JFreeChart Line Chart（折线图）
 */
public class GenerateFigures {
	
	/*public static void main(String[] args) {
		// get data from MySQL
		GraphicalDataType data = MySQLDB.retrieveRecord_new("admin", "admin");
		// create line chart and histogram
		JFreeChart lineChart = createChart(data.getLineDataset());
		JFreeChart histChart = createHistChart(data.getHistDataset());
		// save image as file
		saveAsFile(lineChart, "/home/suhang/git/CSE360_Project/Health_Tracker/img/LineChart.png", 300, 300);
		saveAsFile(histChart, "/home/suhang/git/CSE360_Project/Health_Tracker/img/Histogram.png", 300, 300);
	}*/

	public static void generateFigures() throws IOException
	{
		GraphicalDataType data = MySQLDB.retrieveRecord_Physical("admin", "admin");
		GraphicalDataType data_health = MySQLDB.retrieveRecord_Health("admin", "admin");
		// create line chart and histogram
		JFreeChart lineChart = createChart(data.getLineDataset());
		JFreeChart histChart = createHistChart(data.getHistDataset());
		JFreeChart lineChart_Health = createChart_Health(data_health.getLineDataset());
		JFreeChart histChart_Health = createHistChart_Health(data_health.getHistDataset());

		// save image as file
		File directory = new File(".");
		final String dir = directory.getCanonicalPath();
		saveAsFile(lineChart, dir+"/img/LineChart_physical.png", 600, 360);
		saveAsFile(histChart, dir+"/img/Histogram_physical.png", 600, 360);
		saveAsFile(lineChart_Health, dir+"/img/LineChart_health.png", 600, 360);
		saveAsFile(histChart_Health, dir+"/img/Histogram_health.png", 600, 360);
		//createImage(data.getTable(), dir + "/img/table_physical.png");
		//createImage(data_health.getTable(), dir + "/img/table_health.png");
	}
	
	/*public static JFreeChart lineChart(TimeSeriesCollection lineDataset)
	{
		JFreeChart lineChart = ChartFactory.createTimeSeriesChart(null, null, null, lineDataset);
		lineChart.setBackgroundPaint(Color.white);
		return lineChart;
	}*/
	
	public static JFreeChart createHistChart(CategoryDataset histDataset)
	{
		//create theme  
        StandardChartTheme standardChartTheme=new StandardChartTheme("CN");      
        //set title font    
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,12));      
        //set legend font   
        standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,10));      
        //set axis font  
        standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,10));      
        //use theme   
        ChartFactory.setChartTheme(standardChartTheme);  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                           "Histogram", // title
                           "physical activity", // category
                           "Hours", // y label 
                            histDataset, // dataset 
                            PlotOrientation.VERTICAL, // figure direction: horizontal or vertical
                            true,  // legend
                            false, // tooltips
                            false  // URLs
                            );  
        return chart;
	}
	
	public static JFreeChart createHistChart_Health(CategoryDataset histDataset)
	{
        StandardChartTheme standardChartTheme=new StandardChartTheme("CN");          
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,12));      
        standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,10));      
        standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,10));      
        ChartFactory.setChartTheme(standardChartTheme);  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                           "Health Indicator Histogram", // title
                           "health indicator", // category
                           "", // y label 
                            histDataset, // dataset 
                            PlotOrientation.VERTICAL, // figure direction: horizontal or vertical
                            true,  // legend
                            false, // tooltips
                            false  // URLs
                            );  
        return chart;
	}
	
	// 根据CategoryDataset生成JFreeChart对象
	public static JFreeChart createChart(TimeSeriesCollection lineDataset) {
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
				"Monthly Plot", 		// title
				"Time", 		// categoryAxisLabel
				"Hours", 	// valueAxisLabel
				lineDataset,// dataset
				true, 		// legend
				true, 		// tooltips
				false); 		// URLs300, 300


		// 配置字体（解决中文乱码的通用方法）
		Font xfont = new Font("宋体", Font.PLAIN, 12); // X轴
		Font yfont = new Font("宋体", Font.PLAIN, 12); // Y轴
		Font kfont = new Font("宋体", Font.PLAIN, 10); // 底部
		Font titleFont = new Font("隶书", Font.BOLD, 12); // 图片标题

		jfreechart.setBackgroundPaint(Color.white);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot(); // 获得 plot：XYPlot！

		xyplot.getDomainAxis().setLabelFont(xfont);
		xyplot.getRangeAxis().setLabelFont(yfont);
		jfreechart.getLegend().setItemFont(kfont);
		jfreechart.getTitle().setFont(titleFont);

		//设置时间格式，同时也解决了乱码问题
		DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
		SimpleDateFormat sfd = new SimpleDateFormat("yy-MM");
		dateaxis.setDateFormatOverride(sfd);
		xyplot.setDomainAxis(dateaxis);

		// 以下的设置可以由用户定制，也可以省略
		XYPlot plot = (XYPlot) jfreechart.getPlot();
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		// 设置曲线图与xy轴的距离
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		// 设置曲线是否显示数据点
		xylineandshaperenderer.setBaseShapesVisible(true);
		// 设置曲线显示各数据点的值
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);

		return jfreechart;
	}

	
	public static JFreeChart createChart_Health(TimeSeriesCollection lineDataset) {
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
				"Health Indicator Linechart", 		// title
				"Time", 		// categoryAxisLabel
				"", 	// valueAxisLabel
				lineDataset,// dataset
				true, 		// legend
				true, 		// tooltips
				false); 		// URLs300, 300

		Font xfont = new Font("宋体", Font.PLAIN, 12); // X轴
		Font yfont = new Font("宋体", Font.PLAIN, 12); // Y轴
		Font kfont = new Font("宋体", Font.PLAIN, 10); // 底部
		Font titleFont = new Font("隶书", Font.BOLD, 12); // 图片标题

		jfreechart.setBackgroundPaint(Color.white);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot(); // 获得 plot：XYPlot！

		xyplot.getDomainAxis().setLabelFont(xfont);
		xyplot.getRangeAxis().setLabelFont(yfont);
		jfreechart.getLegend().setItemFont(kfont);
		jfreechart.getTitle().setFont(titleFont);

		//设置时间格式，同时也解决了乱码问题
		DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
		SimpleDateFormat sfd = new SimpleDateFormat("yy-MM");
		dateaxis.setDateFormatOverride(sfd);
		xyplot.setDomainAxis(dateaxis);

		// 以下的设置可以由用户定制，也可以省略
		XYPlot plot = (XYPlot) jfreechart.getPlot();
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		// 设置曲线图与xy轴的距离
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		// 设置曲线是否显示数据点
		xylineandshaperenderer.setBaseShapesVisible(true);
		// 设置曲线显示各数据点的值
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);

		return jfreechart;
	}
	
	// 保存为文件
	public static void saveAsFile(JFreeChart chart, String outputPath,
			int width, int height) {
		FileOutputStream out = null;
		try {
			File outFile = new File(outputPath);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outputPath);
			// save as PNG file
			ChartUtilities.writeChartAsPNG(out, chart, width, height);
			// save as JPEG file
		    //ChartUtilities.writeChartAsJPEG(out, chart, 500, 400);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// do nothing
				}
			}
		}
	}
	
	public static void createImage(JTable table, String fileName) throws IOException {
		JFrame guiFrame = new JFrame();
        
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Table Report");
        guiFrame.setSize(600,360);
      
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
		
		
        table.setGridColor(Color.yellow);
        table.setBackground(Color.magenta);
        table.setAutoResizeMode(1);
        table.setVisible(true);
        table.setMinimumSize(new Dimension(600,360));
        table.setRowHeight(0, 30);

        JScrollPane tableScrollPane = new JScrollPane(table);
        
        guiFrame.add(tableScrollPane);
        guiFrame.setVisible(true);
        
        JTableHeader tableHeaderComp = table.getTableHeader();
        int totalWidth = /*tableHeaderComp.getWidth() +*/ table.getWidth();
        int totalHeight = tableHeaderComp.getHeight() + table.getHeight();
        BufferedImage tableImage = new BufferedImage(totalWidth, totalHeight,
            BufferedImage.TYPE_INT_RGB);
        Graphics2D g2D = (Graphics2D) tableImage.getGraphics();
        tableHeaderComp.paint(g2D);
        g2D.translate(0, tableHeaderComp.getHeight());
        table.paint(g2D);
        
        File outputfile = new File(fileName);
        ImageIO.write(tableImage, "png", outputfile);
        guiFrame.setVisible(false);
      }
}

