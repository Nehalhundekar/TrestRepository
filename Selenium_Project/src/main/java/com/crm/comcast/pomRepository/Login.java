package com.crm.comcast.pomRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//a[@id='submitButton']")})
	private WebElement loginBtn;
	
	public WebElement getuserNameEdt(){
		return userNameEdt;	
	}
	
	public WebElement getpasswordEdt(){
	return passwordEdt;
	}
	
	public WebElement getLoginBtn(){
		return loginBtn;
				
	}
	
	
	public void logInApp(String username,String password )
	{
		
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}
	
	
	
	

}
