package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.genericutility.ExcelGeneric;
import com.comcast.genericutility.JavaUtility;

public class OrganizationInfo {
	
	WebDriver driver;
	public OrganizationInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrginfoVerify;
	public WebElement getOrginfoVerify() {
		return OrginfoVerify;
	}
	
	
	
	

	
	
}
