package cse360.health_tracker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import com.mysql.jdbc.Statement;

public class MySQLDB {

	final static private String url = "jdbc:mysql://localhost/cse360db";
	final static private String dbuser = "testuser";
	final static private String dbpassword = "testuser";
	static private Connection con = null;
	static private Statement st = null;
	static private ResultSet rs = null;
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(MySQLDB.addNewUserInfo("admia", "admin", 1, "tempe"))
			System.out.println("successfully added");
		if(MySQLDB.userValid("adminsssssn","admin"))
			System.out.println("find");
	}*/
	
	/* check if username and password is valid*/
	public static boolean userValid(String username, String password)
	{
		boolean valid = false;
		try{
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			st = (Statement) con.createStatement();
			String query = "select * from userInfo where username = \""+ username + "\" and password = \"" + password + "\";";
			System.out.println(query);
			rs = st.executeQuery(query);
			if(rs.next())
				valid = true;
			else
				valid = false;
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return valid;	
	}
	
	/* check if username has been used*/
	public static boolean userExist(String username)
	{
		boolean valid = false;
		try{
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			st = (Statement) con.createStatement();
			String query = "select * from userInfo where username = \""+ username + "\";";
			System.out.println(query);
			rs = st.executeQuery(query);
			if(rs.next())
				valid = true;
			else
				valid = false;
			rs.close();
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return valid;	
	}
	
	public static String getQuestionInd(String username)
	{
		String result = null;
		try{
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			st = (Statement) con.createStatement();
			String query = "select * from userInfo where username = \""+ username + "\";";
			System.out.println(query);
			rs = st.executeQuery(query);
			if(rs.next())
				result = rs.getInt(3)+rs.getString(4);
			rs.close();
			con.close();
			return result;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void changePassword(String username, String password)
	{
		try{
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			st = (Statement) con.createStatement();
			String query = "update userInfo set password = '" + password +"' where username = '" + username +"';";
			System.out.println(query);
			st.executeUpdate(query);
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean addNewUserInfo(String username, String password, int questionInd, String answer)
	{
		if(userExist(username))
			return false;
		else{
			try{
				con = DriverManager.getConnection(url, dbuser, dbpassword);
				st = (Statement) con.createStatement();
				String query = "insert into userInfo(username,password,question,answer) values(\""+username+"\", \""+password+"\","+questionInd+",\""+answer+"\");";
				System.out.println(query);
				st.executeUpdate(query);
				st.close();
				con.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return true;
		}
	}
	
	public static boolean addNewPhysicalActivityRecord(String username, String password, String date,
													   double cardioDou, double strengthDou, double workDou,
													   double sleepDou, double recreationDou)
	{
		try{
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			st = (Statement) con.createStatement();
			String query = "insert into physicalActivity(username,password,date,cardio,strength,work,sleep,recreation) values(\""+
							username+"\",\""+password+"\",\""+date+"\","+cardioDou+","+strengthDou+","+workDou+","+sleepDou+","+recreationDou+")";
			System.out.println(query);
			st.executeUpdate(query);
			st.close();
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean addNewHealthIndicatorRecord(String username, String password, String date,
			   double pressureDou, double sugerDou, double rateDou,
			   double temperatureDou, double weightDou)
	{
		try{
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			st = (Statement) con.createStatement();
			String query = "insert into healthIndicator(username,password,date,pressure,suger,rate,temperature,weight) values(\""+
			username+"\",\""+password+"\",\""+date+"\","+pressureDou+","+sugerDou+","+rateDou+","+temperatureDou+","+weightDou+")";
			System.out.println(query);
			st.executeUpdate(query);
			st.close();
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static TimeSeriesCollection retrieveRecord(String username, String password)
	{
		TimeSeriesCollection lineDataset = new TimeSeriesCollection();
		try{
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			st = (Statement) con.createStatement();
			String queryPhysical = "select * from physicalActivity where username = \"" + username + "\" and password = \"" + 
									password + "\" order by date asc";
			rs = st.executeQuery(queryPhysical);
			
			TimeSeries cardioSeries = new TimeSeries("cardio");
			TimeSeries strengthSeries = new TimeSeries("strength");
			TimeSeries workSeries = new TimeSeries("time");
			TimeSeries sleepSeries = new TimeSeries("sleep");
			TimeSeries recreationSeries = new TimeSeries("recreation");
			
			int year = 0, month = 0, curYear, curMonth, count = 0;
			double cardio = 0, strength = 0, work = 0, sleep = 0, recreation = 0;
			boolean firstTime = true;
			while(rs.next())
			{
				/*Date date = rs.getDate(3);
				curYear = date.getYear();
				curMonth = date.getMonth();*/
				String date1 = rs.getString(3);
				String sp[] = date1.split("-");
				curYear = Integer.parseInt(sp[0]);
				curMonth = Integer.parseInt(sp[1]);
				System.out.println(curYear+" "+curMonth);
				if(year!=curYear || month!=curMonth)
				{
					if(firstTime == false)
					{
						System.out.println(month);
						cardioSeries.add(new Month(month, year), cardio/count);
						strengthSeries.add(new Month(month, year), strength/count);
						workSeries.add(new Month(month, year), work/count);
						sleepSeries.add(new Month(month, year), sleep/count);
						recreationSeries.add(new Month(month, year), recreation/count);
					}
					count = 0;
					cardio = 0;
					strength = 0;
					work = 0;
					sleep = 0;
					recreation = 0;
					year = curYear;
					month = curMonth;
					firstTime = false;
				}
				count = count + 1;
				cardio = cardio + rs.getDouble(4);
				strength = strength + rs.getDouble(5);
				work = work + rs.getDouble(6);
				sleep = sleep + rs.getDouble(7);
				recreation = recreation + rs.getDouble(8);
			}
			System.out.println(month);
			cardioSeries.add(new Month(month, year), cardio/count);
			strengthSeries.add(new Month(month, year), strength/count);
			workSeries.add(new Month(month, year), work/count);
			sleepSeries.add(new Month(month, year), sleep/count);
			recreationSeries.add(new Month(month, year), recreation/count);
			
			lineDataset.addSeries(cardioSeries);
			lineDataset.addSeries(strengthSeries);
			lineDataset.addSeries(workSeries);
			lineDataset.addSeries(sleepSeries);
			lineDataset.addSeries(recreationSeries);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return lineDataset;
	}
	
	public static GraphicalDataType retrieveRecord_Physical(String username, String password)
	{
		GraphicalDataType graphicalData = new GraphicalDataType();
		graphicalData.setTableColumnName(new Object[]{"month","cardio","strength","work","sleep","recreation"});
		try{
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			st = (Statement) con.createStatement();
			String queryPhysical = "select * from physicalActivity where username = \"" + username + "\" and password = \"" + 
									password + "\" order by date asc";
			rs = st.executeQuery(queryPhysical);
			
			TimeSeries cardioSeries = new TimeSeries("cardio");
			TimeSeries strengthSeries = new TimeSeries("strength");
			TimeSeries workSeries = new TimeSeries("work");
			TimeSeries sleepSeries = new TimeSeries("sleep");
			TimeSeries recreationSeries = new TimeSeries("recreation");
			
			int year = 0, month = 0, curYear, curMonth, count = 0;
			double cardio = 0, strength = 0, work = 0, sleep = 0, recreation = 0;
			boolean firstTime = true;
			while(rs.next())
			{
				/*Date date = rs.getDate(3);
				curYear = date.getYear();
				curMonth = date.getMonth();*/
				String date1 = rs.getString(3);
				String sp[] = date1.split("-");
				curYear = Integer.parseInt(sp[0]);
				curMonth = Integer.parseInt(sp[1]);
				System.out.println(curYear+" "+curMonth);
				if(year!=curYear || month!=curMonth)
				{
					if(firstTime == false)
					{
						System.out.println(new Month(month, year));
						cardioSeries.add(new Month(month, year), cardio/count);
						strengthSeries.add(new Month(month, year), strength/count);
						workSeries.add(new Month(month, year), work/count);
						sleepSeries.add(new Month(month, year), sleep/count);
						recreationSeries.add(new Month(month, year), recreation/count);
						graphicalData.addCategory(cardio/count, new Month(month, year), "cardio");
						graphicalData.addCategory(strength/count, new Month(month, year), "strength");
						graphicalData.addCategory(work/count, new Month(month, year), "work");
						graphicalData.addCategory(sleep/count, new Month(month, year), "sleep");
						graphicalData.addCategory(recreation/count, new Month(month, year), "recreation");
						//graphicalData.addCategory(cardio/count, new Month(month, year), "cardio");
						graphicalData.addTableRow(new Object[]{new Month(month, year), cardio/count,
								strength/count, work/count, sleep/count, recreation/count});
					}
					count = 0;
					cardio = 0;
					strength = 0;
					work = 0;
					sleep = 0;
					recreation = 0;
					year = curYear;
					month = curMonth;
					firstTime = false;
				}
				count = count + 1;
				cardio = cardio + rs.getDouble(4);
				strength = strength + rs.getDouble(5);
				work = work + rs.getDouble(6);
				sleep = sleep + rs.getDouble(7);
				recreation = recreation + rs.getDouble(8);
			}
			System.out.println(month);
			cardioSeries.add(new Month(month, year), cardio/count);
			strengthSeries.add(new Month(month, year), strength/count);
			workSeries.add(new Month(month, year), work/count);
			sleepSeries.add(new Month(month, year), sleep/count);
			recreationSeries.add(new Month(month, year), recreation/count);
			graphicalData.addCategory(cardio/count, new Month(month, year), "cardio");
			graphicalData.addCategory(strength/count, new Month(month, year), "strength");
			graphicalData.addCategory(work/count, new Month(month, year), "work");
			graphicalData.addCategory(sleep/count, new Month(month, year), "sleep");
			graphicalData.addCategory(recreation/count, new Month(month, year), "recreation");
			
			graphicalData.addLineChartTimeSeries(cardioSeries);
			graphicalData.addLineChartTimeSeries(strengthSeries);
			graphicalData.addLineChartTimeSeries(workSeries);
			graphicalData.addLineChartTimeSeries(sleepSeries);
			graphicalData.addLineChartTimeSeries(recreationSeries);
			graphicalData.addTableRow(new Object[]{new Month(month, year), cardio/count,
					strength/count, work/count, sleep/count, recreation/count});
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return graphicalData;
	}
	
	
	public static GraphicalDataType retrieveRecord_Health(String username, String password)
	{
		GraphicalDataType graphicalData = new GraphicalDataType();
		graphicalData.setTableColumnName(new Object[]{"month", "blood pressure","blood sugar","pulse rate","body temperature","weight"});
		try{
			con = DriverManager.getConnection(url, dbuser, dbpassword);
			st = (Statement) con.createStatement();
			String queryPhysical = "select * from healthIndicator where username = \"" + username + "\" and password = \"" + 
									password + "\" order by date asc";
			rs = st.executeQuery(queryPhysical);
			
			TimeSeries pressureSeries = new TimeSeries("blood pressure");
			TimeSeries sugarSeries = new TimeSeries("blood sugar");
			TimeSeries pulseSeries = new TimeSeries("pulse rate");
			TimeSeries temperatureSeries = new TimeSeries("body temperature");
			TimeSeries weightSeries = new TimeSeries("weight");
			
			int year = 0, month = 0, curYear, curMonth, count = 0;
			double pressure = 0, sugar = 0, pulse = 0, temperature = 0, weight = 0;
			boolean firstTime = true;
			while(rs.next())
			{
				/*Date date = rs.getDate(3);
				curYear = date.getYear();
				curMonth = date.getMonth();*/
				String date1 = rs.getString(3);
				String sp[] = date1.split("-");
				curYear = Integer.parseInt(sp[0]);
				curMonth = Integer.parseInt(sp[1]);
				System.out.println(curYear+" "+curMonth);
				if(year!=curYear || month!=curMonth)
				{
					if(firstTime == false)
					{
						System.out.println(new Month(month, year));
						pressureSeries.add(new Month(month, year), pressure/count);
						sugarSeries.add(new Month(month, year), sugar/count);
						pulseSeries.add(new Month(month, year), pulse/count);
						temperatureSeries.add(new Month(month, year), temperature/count);
						weightSeries.add(new Month(month, year), weight/count);
						graphicalData.addCategory(pressure/count, new Month(month, year), "blood pressure");
						graphicalData.addCategory(sugar/count, new Month(month, year), "blood sugar");
						graphicalData.addCategory(pulse/count, new Month(month, year), "pulse rate");
						graphicalData.addCategory(temperature/count, new Month(month, year), "body temperature");
						graphicalData.addCategory(weight/count, new Month(month, year), "weight");
						//graphicalData.addCategory(cardio/count, new Month(month, year), "cardio");
						graphicalData.addTableRow(new Object[]{new Month(month, year), 
								pressure/count, sugar/count, pulse/count, temperature/count, weight/count});
					}
					count = 0;
					pressure = 0;
					sugar = 0;
					pulse = 0;
					temperature = 0;
					weight = 0;
					year = curYear;
					month = curMonth;
					firstTime = false;
				}
				count = count + 1;
				pressure = pressure + rs.getDouble(4);
				sugar = sugar + rs.getDouble(5);
				pulse = pulse + rs.getDouble(6);
				temperature = temperature + rs.getDouble(7);
				weight = weight + rs.getDouble(8);
			}
			System.out.println(month);
			System.out.println(new Month(month, year));
			pressureSeries.add(new Month(month, year), pressure/count);
			sugarSeries.add(new Month(month, year), sugar/count);
			pulseSeries.add(new Month(month, year), pulse/count);
			temperatureSeries.add(new Month(month, year), temperature/count);
			weightSeries.add(new Month(month, year), weight/count);
			graphicalData.addCategory(pressure/count, new Month(month, year), "blood pressure");
			graphicalData.addCategory(sugar/count, new Month(month, year), "blood sugar");
			graphicalData.addCategory(pulse/count, new Month(month, year), "pulse rate");
			graphicalData.addCategory(temperature/count, new Month(month, year), "body temperature");
			graphicalData.addCategory(weight/count, new Month(month, year), "weight");
			
			graphicalData.addLineChartTimeSeries(pressureSeries);
			graphicalData.addLineChartTimeSeries(sugarSeries);
			graphicalData.addLineChartTimeSeries(pulseSeries);
			graphicalData.addLineChartTimeSeries(temperatureSeries);
			graphicalData.addLineChartTimeSeries(weightSeries);
			graphicalData.addTableRow(new Object[]{new Month(month, year), 
					pressure/count, sugar/count, pulse/count, temperature/count, weight/count});
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return graphicalData;
	}
}
