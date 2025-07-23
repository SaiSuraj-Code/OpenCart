package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginRegistration;
import pageObjects.MyAccountPage;

public class TC002_LoginTestCase extends BaseClass {
	
	@Test(groups ={"Sanity" , "Master"})
	
	public void VerifyLogin() throws IOException
	{
	
		logger.info("**TC002 is started ***");
		
		try {
		HomePage Hp = new HomePage(driver);
		
		Hp.MyAccountClick();
		
		Hp.LoginClick();
		
		LoginRegistration Log = new LoginRegistration(driver);
		
		//Properties prop = new Properties();
		
		//FileInputStream File = new FileInputStream("C:\\Workspace\\Java 29-05\\OpenCart01\\src\\test\\resources\\config.properties");
		
       // prop.load(File);
       
		Log.SetEmail_user(Prop.getProperty("email"));
		
		Log.SetEmail_Password(Prop.getProperty("password"));
		
		Log.SetLogin();
	   
		logger.info("***Logined into the page****");
		
		//Check the my account
		
		
		MyAccountPage MyAc = new MyAccountPage(driver);
		
	    Assert.assertTrue(MyAc.MyAccountCheck());
		
		
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		
   logger.info("***TC is finished**");
	
}
}
