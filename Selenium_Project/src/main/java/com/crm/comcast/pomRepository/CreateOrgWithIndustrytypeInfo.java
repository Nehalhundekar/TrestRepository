package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgWithIndustrytypeInfo 
{
	WebDriver driver;
	public CreateOrgWithIndustrytypeInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgNameTitle;
	public WebElement getOrgNameTitle() {
		return OrgNameTitle;
	}
	
	
	

}
