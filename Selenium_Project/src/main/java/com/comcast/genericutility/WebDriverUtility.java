package com.comcast.genericutility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility 
{
	   public void waitUntilPageLoad(WebDriver driver)
	   {
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
	   }
	   
	   public void waitForElementVisibility(WebDriver driver,WebElement element)
	   {
		  WebDriverWait wait = new WebDriverWait(driver, 30);
		  wait.until(ExpectedConditions.visibilityOf(element));
	   }
         
	   
	   public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	   }
	       
	       
	       public void select(WebElement element, String option)
	       {
	    	   Select select=new Select(element);
	    	   select.selectByVisibleText(option);
	    	   
	       }
	       
	       public void select(WebElement element, int index)
	       {
	    	   Select select=new Select(element);
	    	   select.selectByIndex(index);   
	       }

	       public void mouseOver(WebDriver driver,WebElement element)
	       {
	    	   Actions act = new Actions(driver);
	    	   act.moveToElement(element).perform();
	    	   
	       }
	       
	       public void switchToWindow(WebDriver driver, String partialWinTitle)
	       {
	    	   Set<String> window = driver.getWindowHandles();
	    	   Iterator<String> it = window.iterator();
	    	   while(it.hasNext())
	    	   {
	    		   String winId=it.next();
	    		   String title=driver.switchTo().window(winId).getTitle();
	               if(title.contains(partialWinTitle))
	               {
	            	   break;
	               }
	    		   
	    	   }
	    	   
	       }
	       
	       
	       public void acceptAlert(WebDriver driver)
	       {
	    	   driver.switchTo().alert().accept();
	       }
	       
	       public void cancelAlert(WebDriver driver)
	       {
	    	   driver.switchTo().alert().dismiss();
	       }
	       
	       public void scrollToWebElement(WebDriver driver, WebElement element) {
	    	   JavascriptExecutor js=(JavascriptExecutor)driver;
	    	  int y= element.getLocation().getY();
	    	   js.executeScript("window.scrollBy(0,"+y+")", element);
	       }
	       
	       public void switchFrame(WebDriver driver,int index) {
	       	driver.switchTo().frame(index);
	       }  
	       
	       public void switchFrame(WebDriver driver,WebElement element) {
	       	driver.switchTo().frame(element);
	       } 
	   	
	       public void switchFrame(WebDriver driver,String idOrName) {
	       	driver.switchTo().frame(idOrName);
	       } 

	       public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
	       	TakesScreenshot ts=(TakesScreenshot)driver;
	       	File src=ts.getScreenshotAs(OutputType.FILE);
	       	File dest=new File("./screenshot/"+screenshotName+".PNG");
	       	Files.copy(src, dest);
	       }
	       
	       public void passEnterKey(WebDriver driver) {
	    	   Actions act = new Actions(driver);
	    	   act.sendKeys(Keys.ENTER).perform();
	       } 












}
