package Practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateOrg {
	@Test(retryAnalyzer=com.comcast.genericutility.RetryAnalyser.class)
	public void orgName()
	{
		Reporter.log("this is created",true);
		Assert.fail();
	}

}
