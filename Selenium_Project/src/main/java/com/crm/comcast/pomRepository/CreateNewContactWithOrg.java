package com.crm.comcast.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.genericutility.WebDriverUtility;

public class CreateNewContactWithOrg extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewContactWithOrg(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement getContactName;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement OrgNameSelect;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
		}
	
    public WebElement getOrgNameSelect() {
		return OrgNameSelect;
	}
    
    public void contactWithOrg(String contact)
    {
    	getContactName.sendKeys(contact);
    	OrgNameSelect.click();
    	
    	
    }
    
}
