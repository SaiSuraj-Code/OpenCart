package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistration extends BaseClass {
	
	
	@Test(groups = {"Regression","Master"})
	 
	void Verify_AccountRegistration()
	{
		
		logger.info("**** i am starting test case TC001 ****");
		
		try 
		{
		HomePage HP = new HomePage(driver);
		
		HP.MyAccountClick();
		HP.MyRegisterClick();
		logger.info("**** i am clicking register ****");
		AccountRegistrationPage ARP = new AccountRegistrationPage(driver);
		
		logger.info("**** Providing  customer details ****");
		
		ARP.SetFirstName(RandomString());
		
		ARP.SetLastName(RandomString());
		
		ARP.SetEmail(RandomString()+"@gmail.com");
		
		ARP.SetTelephone(RandomStringNum());
		
		ARP.SetPassword("XYZ123");
		
		ARP.SetConfirmPassword("XYZ123");
		
		ARP.SetAgree();
		
		ARP.SetContinue();
		
		logger.info("**** Validating the result ****");
		String Conf = ARP.getAcctConfig();
		
		
		if(Conf.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		//Assert.assertEquals(Conf, "Your Account Has Been Created!");
		else
		{
			logger.error("Test failed..");
			logger.debug("debuging..");
			Assert.assertTrue(false);
		}
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("** test completed***");
	}

}
