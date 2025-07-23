package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginRegistration;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDataProviders extends BaseClass {
	
	
	@Test (dataProvider="LoginData" , dataProviderClass = DataProviders.class  , groups = "datadriven") //we need specify the class if dataprovider is not in same class.
	
	public void LoginDataProviders(String email , String Pass , String validate)
	{
	   
		//HomePage
		logger.info("**TC003 is started***");
		
		try
		{
		
		HomePage Hp = new HomePage(driver);
		
		Hp.MyAccountClick();
		
		Hp.LoginClick();
		
		//LoginPage
		
		LoginRegistration Log = new LoginRegistration(driver);
		Log.SetEmail_user(email);
		Log.SetEmail_Password(Pass);
		Log.SetLogin();
		
		//My account 
		
		MyAccountPage MYAc = new MyAccountPage(driver);
		
		boolean Status = MYAc.MyAccountCheck();
		
		/* Data is valid - login passed - Pass
		 * Data is invalid - login failed - pass
		 * Data is valid - login failed - fail
		 * Data in invalid - login passed - fail
		 * */
		if(validate.equalsIgnoreCase("Valid"))
		{
			if(Status == true)
			{
				Assert.assertTrue(true);
				MYAc.ClickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(validate.equalsIgnoreCase("InValid"))
		{
			if(Status == true)
			{
				MYAc.ClickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		finally
		{
			logger.info("TC is completed***");
		}
		
		
		
	}

}
