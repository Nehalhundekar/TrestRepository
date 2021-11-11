package com.comcast.genericutility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.comcast.pomRepository.Home;
import com.crm.comcast.pomRepository.Login;

public class BaseClassUtility 
{
	public JavaUtility jui=new JavaUtility();
	public Loginutility log=new Loginutility();
	public ExcelGeneric exc=new ExcelGeneric();
	public WebDriverUtility web=new WebDriverUtility();
	public WebDriver driver=null;
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void bsConfig()
	{
		System.out.println("========connected to Database=============");
		System.out.println("execution");
	}
	//@Parameters(value="Browser")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void bcConfig() throws Throwable
	{
		System.out.println("========Launch the broswer=============");
		String Browser = log.getLogin("browser");
		String Url = log.getLogin("url");
		if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(Url);
	}
	
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void bmConfig() throws Throwable
	{
		System.out.println("========login to Application=============");
		String Username = log.getLogin("username");
		String Password = log.getLogin("password");
		Login lp=new Login(driver);
		lp.logInApp(Username, Password);
	}
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void AmConfig()
	{
		System.out.println("========Sign out=============");
		Home hm=new Home(driver);
		hm.logOut();
	}
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void AcConfig()
	{
		System.out.println("========close browser=============");
		driver.close();
	}
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void AsConfig()
	{
		System.out.println("========connection to Database is lost=============");
	}
	
	
	

}
