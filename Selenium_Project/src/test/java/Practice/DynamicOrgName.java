package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.genericutility.BaseClassUtility;
import com.comcast.genericutility.ExcelUtility;
import com.comcast.genericutility.FileUtility;
import com.comcast.genericutility.JavaUtility;
import com.crm.comcast.pomRepository.CreateNewOrganization;
import com.crm.comcast.pomRepository.Organizations;
@Listeners(com.comcast.genericutility.ListenerImpl.class)
public class DynamicOrgName extends BaseClassUtility {
	WebDriver driver;
	@Test
	public void orgNameDynamic() throws Throwable
	{
		JavaUtility jui=new JavaUtility();
		ExcelUtility eui=new ExcelUtility();
		FileUtility fui=new FileUtility();
		String Browser = fui.getPropertyKeyValue("browser");
		String Url = fui.getPropertyKeyValue("url");
		String Username = fui.getPropertyKeyValue("username");
		String Password = fui.getPropertyKeyValue("password");
		
		String orgName = eui.getData("Sheet1", 4, 2)+"_"+jui.getRanDomNumber();
		
		
		if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(Url);
		
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		Organizations org=new Organizations(driver);
		org.getCreateOrgBtn().click();
		
		CreateNewOrganization newOrg=new CreateNewOrganization(driver);
		newOrg.createOrgind(orgName);
		newOrg.getSaveBtn().click();
		Thread.sleep(10000);
		
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.navigate().refresh();
		Thread.sleep(10000);
	
		  WebElement ele = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[.='"+orgName+"']"));
		  String Actele = ele.getText();
		System.out.println(Actele);
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		int count=list.size();
		System.out.println(count);
		for(int i=1;i<count;i++)
		{
			String Expctele = list.get(i).getText();
			System.out.println(Expctele);
			if(Expctele.equals(Actele))
			{
				driver.findElement(By.xpath("//a[.='"+orgName+"']../following-sibling::td[5]/a[.='del']")).click();
				driver.switchTo().alert().accept();
				System.out.println(orgName +" deleted successfully");
				break;
				
			}
			
			
		}

	}
	

}
