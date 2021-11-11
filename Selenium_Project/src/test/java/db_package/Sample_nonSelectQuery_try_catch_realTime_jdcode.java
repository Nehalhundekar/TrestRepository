package db_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_nonSelectQuery_try_catch_realTime_jdcode 
{

	public static void main(String[] args) throws Throwable 
	{
		Connection con=null;
		try{
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
			Statement st = con.createStatement();
			int result = st.executeUpdate("insert into student values(5,'rahul','z','rahul@gmail.com')");
			if(result==1)
			{
				System.out.println("student is successfully created--!!");
			}
		}
			catch(Exception e)
			{
				System.err.println("Student is not created");
			}
		finally 
		{
			con.close();
			System.out.println("==========close connection=======");
			
		}
			
		}
		

	}


