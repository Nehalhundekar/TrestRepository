package com.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;



public class Loginutility 
{
	public String getLogin(String key) throws Throwable
	{
		FileInputStream fist=new FileInputStream("./Data/data.property");
		Properties pb=new Properties();
		pb.load(fist);
		String vall = pb.getProperty(key);
		return vall;
		
		
		
	}

}
