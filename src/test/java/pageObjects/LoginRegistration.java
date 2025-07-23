package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistration extends Basepage {

	public LoginRegistration(WebDriver driver) {
		super(driver);
		
	}
	
	//Locate the login details 
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Email_user;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Email_Password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement Login;
	
	//Actions
	
	public void SetEmail_user(String user)
	{
		Email_user.sendKeys(user);
	}
	
	public void SetEmail_Password(String user)
	{
		Email_Password.sendKeys(user);
	}
	
	public void SetLogin()
	{
		Login.click();
	}
	
	
	

}
