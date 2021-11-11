package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.genericutility.WebDriverUtility;

public class Home 
{
	WebDriver driver;
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement OrganizationLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement ContactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrator;
	
	@FindBy(partialLinkText="Sign Out")
	private WebElement signOut;
	
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getAdministrator() {
		return Administrator;
	}

	public WebElement getSignOut() {
		return signOut;
	}
    
	
	public void logOut()
	{
		
		WebDriverUtility web=new WebDriverUtility();
		web.mouseOver(driver, Administrator);
		signOut.click();
	}
	

}
