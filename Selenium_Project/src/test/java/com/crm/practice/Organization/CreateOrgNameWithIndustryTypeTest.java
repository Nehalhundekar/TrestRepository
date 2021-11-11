package com.crm.practice.Organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.comcast.genericutility.BaseClassUtility;
import com.comcast.genericutility.ExcelGeneric;
import com.comcast.genericutility.JavaUtility;
import com.comcast.genericutility.Loginutility;
import com.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.pomRepository.CreateOrgWithIndustrytype;
import com.crm.comcast.pomRepository.CreateOrgWithIndustrytypeInfo;
import com.crm.comcast.pomRepository.CreateNewOrganization;
import com.crm.comcast.pomRepository.Home;
import com.crm.comcast.pomRepository.Login;
import com.crm.comcast.pomRepository.OrganizationInfo;
import com.crm.comcast.pomRepository.Organizations;

public class CreateOrgNameWithIndustryTypeTest extends BaseClassUtility
{
	@Test(groups="regressionTest")
	public void orgIndustryTyp() throws Throwable
	{
		
		
		
		String orgName = exc.getExcel("Sheet1", 4, 2)+"_"+jui.getRanDomNumber();
		String indust = exc.getExcel("Sheet1", 4, 3);
		String typ =exc.getExcel("Sheet1", 4, 4);
		String contact = exc.getExcel("Sheet1", 4, 5);
		
		
		Home hm=new Home(driver);
		hm.getOrganizationLink().click();
		Organizations og=new Organizations(driver);
		og.getCreateOrgBtn().click();
		CreateNewOrganization orgnew=new CreateNewOrganization(driver);
		orgnew.createOrgind(orgName);
		
		CreateOrgWithIndustrytype cntind=new CreateOrgWithIndustrytype(driver);
		
		cntind.IndustryType();
		
		orgnew.getSaveBtn().click();
		
		CreateOrgWithIndustrytypeInfo Inf1=new CreateOrgWithIndustrytypeInfo(driver);
		String Title = Inf1.getOrgNameTitle().getText();
		if(Title.contains(orgName))
		{
			System.out.println(orgName +"organisation successfully created====> pass ");
		}
		else
		{
			System.out.println(orgName+"organisation not created=====>fail");
		}
		Assert.fail();
	
	}
	
	@Test(groups="regressionTest")
	public void createOrg() throws Throwable
	{
		
		
		String orgName = exc.getExcel("Sheet1", 4, 2)+"_"+jui.getRanDomNumber();
		String contact = exc.getExcel("Sheet1", 4, 5);
		
		
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
