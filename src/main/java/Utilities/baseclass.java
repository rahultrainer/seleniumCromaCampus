package Utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class baseclass{
	
	private static WebDriver driver;
	String configpath = "./src/main/resources/properties/Config.properties";
	Propertyfile pf;
	public extentreporting ert =  new extentreporting();
	
	@BeforeSuite
	public void setUp() throws Exception
	{
		ert.startTest("setUp");
//		Reporter.log("inside setup");
		pf = new Propertyfile();
		String browsername = pf.callpropertyfile("browser", configpath);
		if(browsername.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-geolocation");
			options.addArguments("start-maximized");
			System.setProperty("webdriver.chrome.driver", pf.callpropertyfile("chromedriver", configpath));
			setDriver(new ChromeDriver(options));
		}
		else if(browsername.equals("firefox"))
		{
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("geo.enabled", false);
			fp.setPreference("geo.provider.use_corelocation", false);
//			fp.setPreference("geo.enabled", false);
//			fp.setPreference("geo.enabled", false);
			System.setProperty("webdriver.gecko.driver", pf.callpropertyfile("firefoxdriver", configpath));
			setDriver(new FirefoxDriver());
		}
		ert.getstatus("pass");
//		Reporter.log("browser launched");
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		
	}
	
	@AfterSuite
	public void teardown()
	{
		Reporter.log("inside teadown");
		getDriver().close();
		ert.getstatus("pass");
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		baseclass.driver = driver;
	}
}
