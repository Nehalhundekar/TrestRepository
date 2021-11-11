package com.crm.comcast.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.genericutility.WebDriverUtility;

public class Organizations extends WebDriverUtility
{
	WebDriver driver;
	public Organizations(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgBtn;
	
	public WebElement getCreateOrgBtn() {
		return CreateOrgBtn;
	}
	@FindBy(id="search_txt")
	private WebElement orgInfo;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchlink;
	
	
	
	public WebElement getOrgInfo() {
		return orgInfo;
	}

	public WebElement getSearchlink() {
		return searchlink;
	}
	
	public void searchOrgName(String orgName)
	{
		switchToWindow(driver, "Accounts&action");
		orgInfo.sendKeys(orgName);
		searchlink.click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		switchToWindow(driver, "Administrator");
	}
	
	
	

}
