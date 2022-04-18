package JDBCJavaDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class ImplementationPart {
	
	Scanner sc=new Scanner(System.in);
	
	public void getLoginInfo() {
	
	
	 String mysqlUrl = "jdbc:mysql://localhost:3306/CovidTracker";
     String user = "root";
     String password = "moon";
	 
     System.out.println("***************WELCOME TO COVID TRACKER SYSTEM****************");
	 
	 System.out.println("   Hey deys Your answers will be carefully analyzed!!");
		System.out.println("   Terms and services:  ->before using checkup: ");
		System.out.println("        ->Your data is safe it will not shared with anyone ");
		System.out.println("        ->Checkup is for informational purpose ");
	
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
	}

public void  getCheckupType()

{
System.out.println("Select Your Choice");

System.out.println("1->Covid CheckUp");
System.out.println("2->Normal CheckUp");
System.out.println("3->Vacinating Session");

{
	System.out.println("Enter your choices");

	
	int choices1 = 0;

   if(sc.hasNextInt()) 
	{
		 choices1 = sc.nextInt();
	
switch(choices1)
{
case 1:
	System.out.println("COVID CHECKUP SESSION");
	getCovidCheckup();
case 2:
	getNormalCheckup();
	
case 3:
	getVacination();
	
default:
{
	System.out.println("invalid data");
   }
sc.close(); 
	}
}
}
}


public void getCovidCheckup()
{

		System.out.println("Covid Test Session");
	
		System.out.println("ENTER YOUR EXACT RT-PCR VALUE");
		
		if(sc.hasNext()) {
		int RTPCR = 0;
		 RTPCR = sc.nextInt();
		
		if(RTPCR<=35)
		{
			System.out.println("COVID POSITIVE!..BECAUSE OF RT-PCR VALUE LESSER THAN 35 ");
			System.out.println("RT-PCR VALUE MUST BE ABOVE 35(MANDATORY)..BUT LESSER THAN 35");
			System.out.println("DONT WORRIES WE WILL TAKE CARE OF YOU..PROVIDE YOUR EXACT CONTACT NUMBER");
			
			String address ="";
			address = sc.next();
			System.out.println("here your data perfectly registered");
			System.out.println("OUR PATNERS  WILL REACH YOUR LOCATION AND THEY WILL PROVIDER TREATMENT AT YOUR HOME");
		 
			System.out.println("Enter your choices");

			
			int choices1 = 0;

		   if(sc.hasNextInt()) 
			{
				 choices1 = sc.nextInt();
				
				 	}
			
		}
		
		else if(RTPCR>=35)
		{
			System.out.println("COVID NEGATIVE");
			System.out.println("\nNO WORRIES IT'S NORMAL BUT BE SAFE AT HOME");
			System.out.println("PLEASE KEEP DISTANCE WITH OTHERS!!.." + "\n WEAR YOUR MASK & WASH YOUR HANDS");
		
		
			int choices1 = 0;

			   if(sc.hasNextInt()) 
				{
					 choices1 = sc.nextInt();
					
					 	}
		
		}
		}
}
public void getNormalCheckup()
{
		System.out.println("GENERAL WARD GENERAL CHECKUP");
		
	System.out.println("What is your body temperature? "+"/nprovide your exact body tempearature");
	
	if(sc.hasNext()) {
	int temp = sc.nextInt();
	if(temp>98 && temp<=110)
	{
		System.out.println("HIGH BODY TEMPERATURE");
		System.out.println("PLEASE ADMIT NEAR BY YOUR HOSIPITAL");
		System.out.println("OTHERWISE CONTACT THIS PERSON 9080235631...");
		System.out.println("THEY WILL PROVIDE TREATEMENT FOR YOU AT YOUR HOME");
	
		System.out.println("so you want to continue select your choise");
		
		
		int choices1 = 0;

		   if(sc.hasNextInt()) 
			{
				 choices1 = sc.nextInt();
				
			}	
	}
	
	else if(temp<98)
	{
		System.out.println("NO WORRIES NORMAL TEMPERATURE BUT BE SAFE AT HOME");
		System.out.println("PLEASE KEEP DISTANCE WITH OTHERS WEAR YOUR MASK & WASH YOUR HANDS");
	
		
		System.out.println("do you want to continue select your choice");
		int choices1 = 0;

		   if(sc.hasNextInt()) 
			{
				 choices1 = sc.nextInt();
				
				 	}
		
	}
	else
	{
		System.out.println("INVALID PLEASE PROVIDE VALID DATA");
		sc.nextInt();
	
		int choices1 = 0;

		   if(sc.hasNextInt()) 
			{
				 choices1 = sc.nextInt();
				
				 	}
	}
	}

	}
	
public void getVacination()
{
	System.out.println("VACCINATING SESSION 105VS");

System.out.println("DID YOU COMPLETE PRIMARY COVID-19 VACINATION?");
System.out.println("SELECT YOUR OPTIONS");

System.out.println("PRESS 'Y' FOR YES OR 'N' FOR NO");

if(sc.hasNext()) {
 String ans = sc.next();

char ch ='Y';
if(ch =='Y'|| ch =='y')
{
	System.out.println("Thanks for your response");

}

else
{
	String answ = sc.next();

	System.out.println("PROVIDE YOUR  CONTACT NUMBER");

	String address = sc.next();
	System.out.println("here your data perfectly registered");
	System.out.println("OUR PATNERS  WILL REACH YOUR LOCATION AND THEY WILL PROVIDER YOUR VACCINES");
 
	
}

System.out.println("DID YOU COMPLETE SECONDARY BOOSTER");
 System.out.println("PRESS 'Y' FOR YES 'N' FOR NO");
 char ch1='N';
 if(ch1=='N'||ch1=='n') {
	String answ = sc.next();

	System.out.println("PROVIDE YOUR  CONTACT NUMBER");

	String address = sc.next();
	System.out.println("here your data perfectly registered");
	System.out.println("OUR PATNERS  WILL REACH YOUR LOCATION AND THEY WILL PROVIDER YOUR VACCINES");
 
 }
 else if(ch1 =='s'||ch1=='S')
	 
 {
 
	 System.out.println("Thanks for your response");
 }
 
 
  else
{
	System.out.println("INVALID DATA ");
}

}	
}
}