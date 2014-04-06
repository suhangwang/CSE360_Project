package cse360.health_tracker;

import java.awt.Font; 
import java.io.FileOutputStream; 
import java.io.IOException; 
 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.StandardChartTheme; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
 /**  
 * 该类用于演示最简单的柱状图生成 
 * @author Winter Lau  
 */  
 public class BarChartDemo {  
     public static void main(String[] args) throws IOException{  
        //创建主题样式      
         StandardChartTheme standardChartTheme=new StandardChartTheme("CN");      
         //设置标题字体      
         standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));      
         //设置图例的字体      
         standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));      
         //设置轴向的字体      
         standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));      
         //应用主题样式      
         ChartFactory.setChartTheme(standardChartTheme);  
         CategoryDataset dataset = getDataSet();  
         JFreeChart chart = ChartFactory.createBarChart3D(  
                            "水果产量图", // 图表标题 
                            "水果", // 目录轴的显示标签 
                            "产量", // 数值轴的显示标签 
                             dataset, // 数据集 
                             PlotOrientation.VERTICAL, // 图表方向：水平、垂直 
                             true,  // 是否显示图例(对于简单的柱状图必须是 false) 
                             false, // 是否生成工具 
                             false  // 是否生成 URL 链接 
                             );  
                             
         FileOutputStream fos_jpg = null;  
         try {  
             fos_jpg = new FileOutputStream("/home/suhang/git/CSE360_Project/Health_Tracker/img/LineChart.jpg");  
             ChartUtilities.writeChartAsJPEG(fos_jpg,chart,400,300);  
         } finally {  
             try {  
                 fos_jpg.close();  
             } catch (Exception e) {}  
         }  
     }  
     /**  
     * 获取一个演示用的简单数据集对象 
     * @return  
     */  
     private static CategoryDataset getDataSet() {  
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
         dataset.addValue(100, "", "苹果");  
         dataset.addValue(200, "", "梨子");  
         dataset.addValue(300, "", "葡萄");  
         dataset.addValue(400, "", "香蕉");  
         dataset.addValue(500, "", "荔枝");  
         return dataset;  
     }  
     /**  
     * 获取一个演示用的组合数据集对象 
     * @return  
     */  
     private static CategoryDataset getDataSet2() {  
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
         dataset.addValue(100, "北京", "苹果");  
         dataset.addValue(100, "上海", "苹果");  
         dataset.addValue(100, "广州", "苹果");  
         dataset.addValue(200, "北京", "梨子");  
         dataset.addValue(200, "上海", "梨子");  
         dataset.addValue(200, "广州", "梨子");  
         dataset.addValue(300, "北京", "葡萄");  
         dataset.addValue(300, "上海", "葡萄");  
         dataset.addValue(300, "广州", "葡萄");  
         dataset.addValue(400, "北京", "香蕉");  
         dataset.addValue(400, "上海", "香蕉");  
         dataset.addValue(400, "广州", "香蕉");  
         dataset.addValue(500, "北京", "荔枝");  
         dataset.addValue(500, "上海", "荔枝");  
         dataset.addValue(500, "广州", "荔枝");  
         return dataset;  
     }  
 } 
