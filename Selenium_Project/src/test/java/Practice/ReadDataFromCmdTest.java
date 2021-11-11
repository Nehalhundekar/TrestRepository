package Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdTest {
	
	@Test
	public void readData()
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
	}

}
