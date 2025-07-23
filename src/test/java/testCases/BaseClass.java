package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	
	public static WebDriver driver;
	
	public Logger logger;
	public Properties Prop;
	
	@SuppressWarnings("deprecation")
	@BeforeClass (groups = {"Sanity","Regression" , "Master", "datadriven"})
	@Parameters({"OS","Browser"})
	void Setup(String Os , String Bs) throws IOException
	{
		
		//Load the properties
		FileReader file = new FileReader("./src//test//resources//config.properties");
		
		 Prop = new Properties();
		
		 Prop.load(file);
		 
		
		logger = LogManager.getLogger(this.getClass());
		
		
		if(Prop.getProperty("execution_env").equalsIgnoreCase("Remote"))
		{
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			if(Os.equalsIgnoreCase("Windows"))
			{
				cap.setPlatform(Platform.WINDOWS);
			}
			else if(Os.equalsIgnoreCase("Linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else if(Os.equalsIgnoreCase("Mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			
			else
			{
				System.out.println("NO matching OS");
			}	
			
			switch(Bs.toLowerCase())
			{
			
			case "chrome" : cap.setBrowserName("chrome"); break;
			
			case "edge" : cap.setBrowserName("MicrosoftEdge"); break;
			
			case "firefox" : cap.setBrowserName("firefox"); break;
			
			default : System.out.println("No matching browser :"); return;
						
			}
			
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			 
		}
		
		
		if(Prop.getProperty("execution_env").equalsIgnoreCase("Local"))	
		{
		
		switch(Bs)
		{
			case "chrome" : driver = new ChromeDriver(); break;
			case "Edge" : driver = new EdgeDriver(); break;
			case "FireFox" : driver = new FirefoxDriver(); break;
			
			default : System.out.println("Invalid browser"); return;
		}
		}
		
			
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(Prop.getProperty("appUrl")); //Get the url from propertie file
		
		driver.manage().window().maximize();
		
	}
	


	@AfterClass(groups = {"Sanity","Regression" , "Master", "datadriven"})
	void tearDown()
	{
	   driver.quit();	
	}
	
	@SuppressWarnings("deprecation")
	public String RandomString()
	{
		
		String GenString = RandomStringUtils.randomAlphabetic(5);
		
		return GenString;
		
	}
	
	public String RandomStringNum()
	{
		
		@SuppressWarnings("deprecation")
		String GenStringNum = RandomStringUtils.randomAlphanumeric(10);
		
		return GenStringNum;
		
	}



	public String captureScreen(String name) throws IOException {
		
		String S_name = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());

		TakesScreenshot takeScreehshot = (TakesScreenshot) driver;
		
		File SourceFile = takeScreehshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\Screenshots\\" + name + S_name +".png" ;
		
		File TargetFile = new File(targetFilePath);
		
		SourceFile.renameTo(TargetFile);
		
		return targetFilePath;
	}

}
