package JDBCJavaDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseConnectivityJDBC {

	public static void main(String[] args) {

		DataBaseConnectivityJDBC db = new DataBaseConnectivityJDBC();
			db.adminModification();
	
	}

	
	public void adminModification()
	{
	
		String continuedata = "";
	
	 String mysqlUrl = "jdbc:mysql://localhost:3306/CovidTracker";
	 String user = "root";
	 String password = "moon";
	
	do {
		System.out.println("Select options from below menu : ");
		System.out.println("Press 1 to select data\n Press 2 for Insert data\n Press 3 for delete data\n Press 4 for update data");
	Scanner sc = new Scanner(System.in);
	int options = sc.nextInt();
	
	switch(options)
	{
	case 1:
	
		ResultSet rs = null;
	
		try(Connection conn = DriverManager.getConnection(mysqlUrl, user, password);

		Statement stmt1 = conn.createStatement();)
		{
			String selectquery = "Select * from patientsDetails";
			rs  = stmt1.executeQuery(selectquery);
			
			while(rs.next())
			{
				String str = (rs.getInt(1) + "   " +rs.getString(2) +"   "+rs.getInt(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7));
			System.out.println(str);
			}			
		}
		catch(SQLException ae)
		{
			ae.printStackTrace();
			
		}
		break;
	case 2:
		try(Connection conn = DriverManager.getConnection(mysqlUrl, user, password);

				Statement stmt1 = conn.createStatement();)
				{	
				System.out.print("Enter the pname :");  
				String a=sc.next();  
				System.out.print("Enter the page : ");  
				int b=sc.nextInt();  
				System.out.print("Enter the pemail : ");  
				String c=sc.next();  
				System.out.print("Enter the pcity : ");  
				String d=sc.next();  
				System.out.print("Enter the pph_no : ");  
				String e=sc.next(); 
				System.out.println("Enter the gender : ");
				String f = sc.next();

			
			Connection con = null;
			String sql = "insert into patientsDetails(patients_name,patients_age,email_id,city_name,phone_no,gender) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')";
			
		    int m = stmt1.executeUpdate(sql);
            if (m == 1)
                System.out.println(" Data inserted successfully : " + sql);
            else
                System.out.println("insertion failed");
 
            //con.close();
        }
 
        catch (Exception ex)
		{
            System.err.println(ex);
        }
	break;
	
	case 3:
		
		try(Connection conn = DriverManager.getConnection(mysqlUrl, user, password);

				Statement stmt1 = conn.createStatement();)
				{	
	
			System.out.println("Enter the id  if you want to delete");
			int patients_id = sc.nextInt();
			String sql ="delete from patientsDetails where patients_Id = ?";
PreparedStatement pst = conn.prepareStatement(sql);

pst.setInt(1,patients_id);

int rows = pst.executeUpdate();

if(rows >0)
{
	System.out.println("The patients information has been deleted...");
	
}
else
{
	System.out.println("record not found");
}
conn.close();
				}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		break;
		
		
	case 4 :
		
		
		
		try(Connection conn = DriverManager.getConnection(mysqlUrl, user, password);

		
			
				Statement stmt1 = conn.createStatement();)
				{	
			
				
				System.out.print("Enter the new patient's page : ");  
				int a=sc.nextInt();  
				System.out.print("Enter the new patient's pemail : ");  
				String b=sc.next();  
				System.out.print("Enter the   pname :");  
				String c=sc.next();  
				
			//Connection con = null;
String sql = "UPDATE patientsDetails SET patients_age =?, email_id=?  WHERE patients_name = ?";
		 
		PreparedStatement stmt11 = conn.prepareStatement(sql);
		stmt11.setInt(1, a);
		stmt11.setString(2, b);
		stmt11.setString(3, c);
		int rowsUpdated = stmt11.executeUpdate();
	
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
		
			conn.close();
				}
				
		catch(SQLException se)
		{

		se.printStackTrace();
		}
		default:
			System.out.println("you have entered wrong input");
			break;
	}
	
	System.out.println("Enter y t continue: otherwise press any other key to exit the program");
	continuedata = sc.next();
	
	if(continuedata.equals("y"))
		System.out.println("you have selected to continue");
	}
	while(continuedata.equals("y"));
	System.out.println("you have excited the program");

	
	
	}
}
	
	
	