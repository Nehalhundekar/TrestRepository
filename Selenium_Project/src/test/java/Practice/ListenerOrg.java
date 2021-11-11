package Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.genericutility.BaseClassUtility;
import com.crm.comcast.pomRepository.CreateNewOrganization;
import com.crm.comcast.pomRepository.Home;
import com.crm.comcast.pomRepository.OrganizationInfo;
import com.crm.comcast.pomRepository.Organizations;




public class ListenerOrg extends BaseClassUtility{
	@Test
	public void failOrg()
	{
		System.out.println("fail");
		Assert.fail();
	}
	
	
}
