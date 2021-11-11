package Practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample_non_Select_Statements 
{

	public static void main(String[] args) throws Throwable 
	{
		Connection conn=null;
		try{
			Driver ref=new Driver();
			DriverManager.registerDriver(ref);
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_db", "root", "root");
			Statement stat = conn.createStatement();
			int result = stat.executeUpdate("insert into patient values(103,'reman','H',333,'reman@gmail.com')");
			if(result==1)
			{
				System.out.println("patient is created");
			}
		}
		catch(Exception e)
		{
			System.err.println("Patient not created");
			
		}
		finally {
			conn.close();
			System.out.println("==========close connection===========");
		}
			
			
		
		

	}

}
