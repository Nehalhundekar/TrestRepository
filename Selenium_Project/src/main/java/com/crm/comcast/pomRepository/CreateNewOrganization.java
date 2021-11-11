package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.genericutility.ExcelGeneric;
import com.comcast.genericutility.JavaUtility;

public class CreateNewOrganization 
{
	WebDriver driver;
	public CreateNewOrganization(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement CreateOrg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	

	public WebElement getCreateOrg() {
		return CreateOrg;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrgind(String orgName)
	{
		
		CreateOrg.sendKeys(orgName);
		
	}

}
