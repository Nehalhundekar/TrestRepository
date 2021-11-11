package Practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CurrentDate {

	public static void main(String[] args) throws Throwable {
		 Date dateObj=new Date();
		 String date = dateObj.toString();
		 
		 System.out.println(date);
		 //launch browser
		 WebDriver driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //login to Make my trip Application
		 driver.get("https://www.makemytrip.com");
		 //Navigate to Src textfield
		 driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		 WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		 Thread.sleep(5000);
		 //select Mumbai city
		 src.sendKeys("Mumbai");
		 driver.findElement(By.xpath("(//div[@class='calc60'])[1]")).click();
		 //Navigate to dst textfield
		 WebElement dst = driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']"));
		 dst.sendKeys("Bangalore");
		 

	}

}
