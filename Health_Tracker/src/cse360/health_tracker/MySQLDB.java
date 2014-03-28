package cse360.health_tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return valid;	
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
				con.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return true;
		}
	}
}
