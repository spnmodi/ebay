package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static  WebDriver driver;
	public void initialization()
	{
		 System.setProperty("webdriver.chrome.driver","C:\\EclipseOxygenWorkspace\\chromedriver.exe" );
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("http://www.ebay.co.uk");
	}

}
