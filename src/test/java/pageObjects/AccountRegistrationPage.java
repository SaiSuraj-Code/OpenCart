package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends Basepage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	} //Constructor 
	
	//Locate the elements 
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstName ;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastName ;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email ;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement TelePhone ;
	
	//input[@id='input-password']
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password ;
	
	//input[@id='input-confirm']
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement ConfirmPassword ;
	
	//input[@name = 'agree']
	
	@FindBy(xpath="//input[@name = 'agree']")
	WebElement Agree ;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Continue ;
	
	//h1[normalize-space()='Your Account Has Been Created!']
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	
	WebElement AcctConfig;
	
	//Action methods
	
	public void SetFirstName(String user)
	{
		FirstName.sendKeys(user);
	}
	
	public void SetLastName(String user)
	{
		LastName.sendKeys(user);
	}
	
	public void SetEmail(String user)
	{
		Email.sendKeys(user);
	}
	
	public void SetTelephone(String user)
	{
		TelePhone.sendKeys(user);
	}
	
	public void SetPassword(String user)
	{
		Password.sendKeys(user);
	}
	
	public void SetConfirmPassword(String user)
	{
		ConfirmPassword.sendKeys(user);
	}
	
	public void SetAgree()
	{
		Agree.click();
	}
	
	public void SetContinue()
	{
		Continue.click();
	}
	
	public String getAcctConfig()
	{
		try
		{
			return (AcctConfig.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}		
		
	}
	
	
	

}
