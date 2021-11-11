package com.crm.comcast.organisationTest;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.comcast.genericutility.ExcelUtility;
import com.comcast.genericutility.FileUtility;

public class CreateOrganisationWithIndustryTypeTest 
{
	@Test
	public static void createOrg() throws Throwable 
	{
		
		
	
		int random=new Random().nextInt(100);
		
		
		FileUtility fir=new FileUtility();
		
		
		String BROWSER = fir.getPropertyKeyValue("browser");
		String URL=fir.getPropertyKeyValue("url");
		String USERNAME=fir.getPropertyKeyValue("username");
		String PASSWORD=fir.getPropertyKeyValue("password");
		
		ExcelUtility eu=new ExcelUtility();
		String data =eu.getData("Sheet1", 1, 2)+"_"+random;
		System.out.println(data);
		
		
		
		
		
		WebDriver driver =null;
		if(BROWSER.equals("firefox"))
				{
			      driver =new FirefoxDriver();
				}
		else if(BROWSER.equals("chrome"))
		
		{
			driver =new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(3000);
	    WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	    String text = ele.getText();
	    if(text.contains("TY_ORG"))
	    {
	    	System.out.println("Organisation created");
	    }
	    else{
	    	System.out.println("organisation not created");
	    }
	    driver.close();
	    
		
			
		 
		
	}

}
 