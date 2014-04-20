package cse360.health_tracker;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class GraphicalDataType {
	
	private TimeSeriesCollection lineDataset;
	private DefaultCategoryDataset histDataset;
	private JTable table;
	private DefaultTableModel model;
	
	public GraphicalDataType()
	{
		lineDataset = new TimeSeriesCollection();
		histDataset = new DefaultCategoryDataset();
		table = new JTable(0,6);
		model = (DefaultTableModel) table.getModel();
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
	
	public void setTableColumnName(Object[] name)
	{
		model.setColumnIdentifiers(name);
	}
	
	public void addTableRow(Object[] row)
	{
		model.addRow(row);
	}
	
	public JTable getTable()
	{
		return table;
	}
}
