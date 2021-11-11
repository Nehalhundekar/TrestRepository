package db_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SampleSelectQuery {

	public static void main(String[] args) throws Throwable 
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		Statement st = con.createStatement();
		ResultSet set = st.executeQuery("select * from student");
		
		while(set.next())
		{
			System.out.println(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getString(3)+"\t"+set.getString(4));
		}
		con.close();
		

	}

}
