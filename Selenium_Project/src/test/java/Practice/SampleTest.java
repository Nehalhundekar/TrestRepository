package Practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleTest {

	public static void main(String[] args) throws Throwable 
	{
		Driver ref=new Driver();
		DriverManager.registerDriver(ref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_db", "root", "root");
		Statement stat = conn.createStatement();
		ResultSet sett = stat.executeQuery("select * from patient");
		while(sett.next())
		{
			System.out.println(sett.getInt(1)+"\t"+sett.getString(2)+"\t"+sett.getString(3)+"\t"+sett.getInt(4)+"\t"+sett.getString(5));
		}
		conn.close();

	}

}
