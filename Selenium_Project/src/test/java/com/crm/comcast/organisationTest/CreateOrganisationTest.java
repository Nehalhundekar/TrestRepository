package com.crm.comcast.organisationTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.comcast.genericutility.ExcelUtility;
import com.comcast.genericutility.FileUtility;

public class CreateOrganisationTest 
{
	@Test
	public void createOrgwithIndustry() throws InterruptedException
	{
		
           int random=new Random().nextInt(100);
		
		
		FileUtility fir=new FileUtility();
		
		
		
		String BROWSER = System.getProperty("browser");
		String URL=System.getProperty("url");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		System.out.println(BROWSER);
		
		ExcelUtility euw=new ExcelUtility();
		String orgName =euw.getData("Sheet1", 4, 2)+"_"+random;
		String indust = euw.getData("Sheet1", 4, 3);
		String typ =euw.getData("Sheet1", 4, 4);
		System.out.println(orgName);
		System.out.println(indust);
		System.out.println(typ);
		
		
		
		
		
		
		
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
		
		
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
	    WebElement ind = driver.findElement(By.name("industry"));
	    Select s1=new Select(ind);
	    s1.selectByVisibleText("Energy");
	    
	    WebElement ty = driver.findElement(By.name("accounttype"));
	    Select s2=new Select(ty);
	    s2.selectByVisibleText("Press");
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(3000);
	    WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	    String text = ele.getText();
	    if(text.contains("Q_ORG"))
	    {
	    	System.out.println("Organisation created");
	    }
	    else{
	    	System.out.println("organisation not created");
	    }
	    driver.close();
		
	}

}
