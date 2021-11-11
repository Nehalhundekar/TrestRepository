package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.genericutility.FileUtility;

public class OrgNameText {
	WebDriver driver;
	@Test
	public void orgNametxt() throws Throwable
	{
		FileUtility fui=new FileUtility();
		String Browser = fui.getPropertyKeyValue("browser");
		String Url = fui.getPropertyKeyValue("url");
		String Username = fui.getPropertyKeyValue("username");
		String Password = fui.getPropertyKeyValue("password");
		
		
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
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		int count=list.size();
		for(int i=1;i<count;i++)
		{
			System.out.println(list.get(i).getText());
		}
	}

}
