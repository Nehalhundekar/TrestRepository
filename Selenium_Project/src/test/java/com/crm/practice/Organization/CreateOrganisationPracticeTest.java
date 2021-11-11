package com.crm.practice.Organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.genericutility.ExcelGeneric;
import com.comcast.genericutility.JavaUtility;
import com.comcast.genericutility.Loginutility;
import com.crm.comcast.pomRepository.CreateNewOrganization;
import com.crm.comcast.pomRepository.Home;
import com.crm.comcast.pomRepository.Login;
import com.crm.comcast.pomRepository.OrganizationInfo;
import com.crm.comcast.pomRepository.Organizations;

public class CreateOrganisationPracticeTest 
{
	@Test
	public void createOrg() throws Throwable
	{
		JavaUtility jui=new JavaUtility();
		jui.getRanDomNumber();
		Loginutility log=new Loginutility();
		String Browser = log.getLogin("browser");
		String Url = log.getLogin("url");
		String Username = log.getLogin("username");
		String Password = log.getLogin("password");
		
		ExcelGeneric exc=new ExcelGeneric();
		String orgName = exc.getExcel("Sheet1", 4, 2)+"_"+jui.getRanDomNumber();
		String contact = exc.getExcel("Sheet1", 4, 5);
		
		WebDriver driver=null;
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
		Login lp=new Login(driver);
		lp.logInApp(Username, Password);
		Home hm=new Home(driver);
		hm.getOrganizationLink().click();
		Organizations og=new Organizations(driver);
		og.getCreateOrgBtn().click();
		
		CreateNewOrganization orgnew=new CreateNewOrganization(driver);
		orgnew.createOrgind(orgName);
		orgnew.getSaveBtn().click();
		OrganizationInfo OrgInf=new OrganizationInfo(driver);
		String OrgText = OrgInf.getOrginfoVerify().getText();
		if(OrgText.contains(orgName))
		{
			System.out.println(orgName +"organisation successfully created====> pass ");
		}
		else
		{
			System.out.println(orgName+"organisation not created=====>fail");
		}
		
		
		
	}
	

}
