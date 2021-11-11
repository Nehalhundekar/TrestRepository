package com.comcast.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatBaseUtility 
{
	static Driver driver;
	static Connection connection;
	static ResultSet result;
	/**
	 * 
	 */
	public void connectDb()
	{
		try{
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public void closeDB() throws SQLException 
	{
		connection.close();
	}
	public ResultSet execyteQuery(String query)
	{
		try{
			result=connection.createStatement().executeQuery(query);
			return result;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String executeQuerryAndGetADta(String query,int coloumnName,String expectedData) throws Throwable
	{
		boolean flag=false;
		result=connection.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(coloumnName).equals(expectedData))
			{
				flag=true;
				break;
			}
			else
			{
				System.out.println(expectedData +"data not verified in the database");
				return expectedData;
			}
		}
		return expectedData;
	}

}
