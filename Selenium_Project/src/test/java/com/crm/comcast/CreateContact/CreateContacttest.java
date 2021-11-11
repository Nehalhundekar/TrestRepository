package com.crm.comcast.CreateContact;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.crypto.prng.ThreadedSeedGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.genericutility.ExcelUtility;
import com.comcast.genericutility.FileUtility;

public class CreateContacttest 
{
	@Test
	public void getContactName() throws Throwable
	{
		int random=new Random().nextInt(100);
        FileUtility fir=new FileUtility();
		
		
		String BROWSER = fir.getPropertyKeyValue("browser");
		String URL=fir.getPropertyKeyValue("url");
		String USERNAME=fir.getPropertyKeyValue("username");
		String PASSWORD=fir.getPropertyKeyValue("password");
		
		
		ExcelUtility eu=new ExcelUtility();
		String orgName =eu.getData("Sheet1", 1, 2)+"_"+random;
		String contact = eu.getData("Sheet1", 4, 3);
		System.out.println(orgName);
		
		
		
		
		
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
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    
	    WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	    String text = ele.getText();
	    if(text.contains("TY_ORG"))
	    {
	    	System.out.println("Organisation created");
	    }
	    else{
	    	System.out.println("organisation not created");
	    }
	    WebDriverWait wait=new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']"))));
	    driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contact);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	    Thread.sleep(2000);
	    Set<String> set = driver.getWindowHandles();
	    Iterator<String> itr=set.iterator();
	    while(itr.hasNext())
	    {
	    	String windowid = itr.next();
	    	Thread.sleep(3000);
	    	driver.switchTo().window(windowid);
	    	String title = driver.getTitle();
	    	if(title.contains("Accounts&action"))
	    	{
	    		break;
	    	}
	    	Thread.sleep(2000);
	    	
	    	
	    
	    	
	    }
	    
	    driver.findElement(By.id("search_txt")).sendKeys(orgName);
    	driver.findElement(By.xpath("//input[@name='search']")).click();
    	driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
    	
    	Set<String> set1 = driver.getWindowHandles();
	    Iterator<String> itr1=set.iterator();
	    while(itr1.hasNext())
	    {
	    	String windowid1 = itr1.next();
	    	Thread.sleep(3000);
	    	driver.switchTo().window(windowid1);
	    	String title1 = driver.getTitle();
	    	System.out.println(title1);
	    	if(title1.contains("Administrator"))
	    	{
	    		break;
	    	}
	    	
	    }
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(2000);
	    WebElement element = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	    String txt = element.getText();
	   
	    if(txt.contains(contact))
	    {
	    	System.out.println("Contact created");
	    }
	    else{
	    	System.out.println("Contact not created");
	    	
	    }
	    Thread.sleep(2000);
	    WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions act=new Actions(driver);
	    act.moveToElement(ele1).perform();
	    driver.findElement(By.partialLinkText("Sign Out")).click();
	}

}
