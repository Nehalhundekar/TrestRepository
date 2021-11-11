package db_package;

import java.awt.event.InvocationEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Generic 
{
	public WebDriver driver;
	@BeforeMethod
	
	public void openapp()
	{
		
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		 driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		
	}
	
	@AfterMethod
	public void closeapp()
	{
		/*driver.quit();*/
	}
	
	
}


