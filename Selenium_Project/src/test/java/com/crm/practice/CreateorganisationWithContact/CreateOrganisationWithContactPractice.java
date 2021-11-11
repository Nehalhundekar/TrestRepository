package com.crm.practice.CreateorganisationWithContact;

import org.testng.annotations.Test;

import com.comcast.genericutility.BaseClassUtility;
import com.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.pomRepository.Contact;
import com.crm.comcast.pomRepository.CreateNewContact;
import com.crm.comcast.pomRepository.CreateNewContactWithOrg;
import com.crm.comcast.pomRepository.CreateNewOrganization;
import com.crm.comcast.pomRepository.Home;
import com.crm.comcast.pomRepository.Organizations;



public class CreateOrganisationWithContactPractice extends BaseClassUtility
{
	@Test(groups="smokeTest")
	public void createOrg() throws Throwable
	{
		
		
		String orgName = exc.getExcel("Sheet1", 4, 2)+"_"+jui.getRanDomNumber();
	//	String industry = exc.getExcel("Sheet1", 4, 3);
	//	String type = exc.getExcel("Sheet1", 4, 4);
		String contact = exc.getExcel("Sheet1", 4, 5);
	
		Home hm=new Home(driver);
		hm.getOrganizationLink().click();
		Organizations og=new Organizations(driver);
		og.getCreateOrgBtn().click();
	
		CreateNewOrganization cg=new CreateNewOrganization(driver);
		cg.createOrgind(orgName);
		cg.getSaveBtn().click();
	
		Contact cntct=new Contact(driver);
		web.waitForElementVisibility(driver, hm.getContactLink());
		
		Thread.sleep(10000);
		hm.getContactLink().click();
		
		cntct.getCreateContctClick().click();
		Thread.sleep(2000);
		CreateNewContactWithOrg orgcnt=new CreateNewContactWithOrg(driver);
		orgcnt.contactWithOrg(contact);
		og.searchOrgName(orgName);
		orgcnt.getSaveBtn().click();
		

	}
	@Test(groups="smokeTest")
	public void createContct() throws Throwable
	{
		
		//String orgName = exc.getExcel("Sheet1", 4, 2)+"_"+jui.getRanDomNumber();
		String contact = exc.getExcel("Sheet1", 4, 5);
	
		Home hm=new Home(driver);
		hm.getContactLink().click();
		
		Contact cnt=new Contact(driver);
		
		cnt.getCreateContctClick().click();
		CreateNewContact cnew=new CreateNewContact(driver);
		cnew.createContact(contact);
			
		
	}

}
