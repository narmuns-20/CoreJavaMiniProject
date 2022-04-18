package JDBCJavaDBConnection;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	
	public class CreationofDatabaseAndTable {
		
	public static void main(String args[]) throws SQLException {
	
		//Getting the connection
		String mysqlUrl = "jdbc:mysql://localhost:3306";
		String user = "root";
		String password = "moon";
		
		try(Connection conn = DriverManager.getConnection(mysqlUrl, user, password);

				Statement stmt = conn.createStatement();)
				
				{		      
		         String sql = "CREATE DATABASE CovidTracker";
		         stmt.executeUpdate(sql);
		         System.out.println("Database created successfully...");   	  
					
		if (conn != null) 
		{
	        System.out.println("Database created..........");
	    }
	}
		catch (SQLException e) 
				{
		         e.printStackTrace();
				}
			}
		}
	class CreateTable
	{
		
		static String mysqlUrl = "jdbc:mysql://localhost:3306/CovidTracker";
		static String user = "root";
		static String password = "moon";
		
		static String conn = null;
	public static void main(String args[]) throws SQLException
	{
	try(Connection conn = DriverManager.getConnection(mysqlUrl, user, password);

	Statement stmt = conn.createStatement();)
	{		      
		String createtable = "create table PatientsDetails(patients_name varchar(30),  patients_age  int(3), email_id varchar(40), city_name varchar(25), phone_no varchar(10), Gender varchar(10));";
		stmt.execute(createtable);
		System.out.println("Table Created successfully......");

		if (conn != null) {
	        System.out.println("table created");
	    }
		
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
  }		
}

	class CreateTable2
	{
		
		static String mysqlUrl = "jdbc:mysql://localhost:3306/CovidTracker";
		static String user = "root";
		static String password = "moon";
		
		static String conn = null;
	public static void main(String args[]) throws SQLException
	{
	try(Connection conn = DriverManager.getConnection(mysqlUrl, user, password);

	Statement stmt = conn.createStatement();)
	{		      
		String createtable = "create table CovidTrackerData( patient_Id int(10) ,patients_name varchar(25),  patients_age  int(3), RT_PCR_value int(4),Results varchar(20), city_name varchar(25), phone_no varchar(10));";
		stmt.execute(createtable);
		System.out.println("Table Created successfully......");

	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
  }		
}
