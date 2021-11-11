package com.comcast.genericutility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * @author dell
 *
 */

public class FileUtility 

{
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
        FileInputStream fis = new FileInputStream("./Data/data.property");
		
		Properties p = new Properties();
		p.load(fis);
		String value =p.getProperty(key);
		System.out.println(value);
		return value;
	}
	

}
