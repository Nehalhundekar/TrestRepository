package db_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class RmgVerification extends Generic 
{
	@Test
	public void rmgvr() throws InterruptedException, Throwable
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("(//a[@href])[2]")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("RMG_1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Sachin D");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s1=new Select(ele);
		s1.selectByVisibleText("Created");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
		
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery("select * from project");
			while(set.next())
			{
				if(set.getString(4).equals("RMG_1"))
				{
					System.out.println("project is created");
					break;
				}
			}
		}
		
	}


