package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Basepage {

	   //Constructor which extended from Basepage
	
    public	HomePage(WebDriver driver)
	{
		super(driver);
	}
    
    //Locate the elements 
    
    @FindBy(xpath = "//span[text() = 'My Account']")
    WebElement MyAccount ;
    
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement Register ;
    
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement Login;
    
    //Action methods
    
    public void MyAccountClick()
    {
    	MyAccount.click();
    }
    
    public void MyRegisterClick()
    {
    	Register.click();
    }
    
    public void LoginClick()
    {
    	Login.click();
    }
    
	
	
}
