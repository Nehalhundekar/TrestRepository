package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.genericutility.WebDriverUtility;

public class CreateOrgWithIndustrytype extends WebDriverUtility
{

	WebDriver driver;
	public CreateOrgWithIndustrytype(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="industry")
	private WebElement InstustryName;
	
	
	public WebElement getInstustryName() {
		return InstustryName;
	}


	@FindBy(name="accounttype")
	private WebElement Type;
	public WebElement getType() {
		return Type;
	}
	
	public void IndustryType()
	{
		select(InstustryName, "Energy");
		select(Type, "Press");
	}

	
	
	
}
