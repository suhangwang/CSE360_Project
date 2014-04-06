package cse360.health_tracker;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class GraphicalDataType {
	
	private TimeSeriesCollection lineDataset;
	private DefaultCategoryDataset histDataset;
	
	public GraphicalDataType()
	{
		lineDataset = new TimeSeriesCollection();
		histDataset = new DefaultCategoryDataset();
	}
	
	public void addLineChartTimeSeries(TimeSeries value)
	{
		lineDataset.addSeries(value);
	}
	
	public void addCategory(double value, Month month, String columnKey)
	{
		histDataset.addValue(value, month, columnKey);
	}
	
	public TimeSeriesCollection getLineDataset()
	{
		return lineDataset;
	}
	
	public DefaultCategoryDataset getHistDataset()
	{
		return histDataset;
	}
}
