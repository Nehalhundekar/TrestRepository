package com.makeMytrip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TicketBookFutureDate {

	public static void main(String[] args) throws Throwable {
		//launch browser
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 //login to Make my trip Application
		 driver.get("https://www.makemytrip.com");
		 //Navigate to Src textfield
		 driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		 WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		 Thread.sleep(2000);
		 //select Mumbai city
		 src.sendKeys("Mumbai");
		 driver.findElement(By.xpath("(//div[@class='calc60'])[1]")).click();
		 //Navigate to dst textfield
		 driver.findElement(By.xpath("//span[.='To']")).click();
		  driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Chennai International Airport");
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText']")).click();
		driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thu Jan 20 2022']")).click();

	}

}
