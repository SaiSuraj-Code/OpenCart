package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Basepage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//div[@id = 'content']//h2[text()='My Account']")
	WebElement MyAccountheading;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Logout;
	
	
	
	//Actions
	
	public boolean MyAccountCheck()
	{
		
		try {
		return (MyAccountheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void ClickLogout()
	{
		Logout.click();
		
	}
	
	

}
