package db_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TicketBooking 
{
	@Test(dataProvider="TestData")
	public void Bookings(String src,String dst)
	{
		System.out.println(src +"  to  "+ dst);
	}
	
	@DataProvider(name="TestData")
	public Object[][] getTestData()
	{
		Object[][] arr=new Object[5][2];
		arr[0][0]="Bangalore";
		arr[0][1]="Goa";
		
		arr[1][0]="Bangalore";
		arr[1][1]="Bombay";
		
		arr[2][0]="Bangalore";
		arr[2][1]="ooty";
		
		arr[3][0]="Bangalore";
		arr[3][1]="Delhi";
		
		arr[3][0]="Bangalore";
		arr[3][1]="LehLadak";
		
		return arr;
		
		
		
		
	}

}
