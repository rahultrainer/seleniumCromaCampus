package POM;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.capturescreenshot;

public class google_search {
	
	List<WebElement> we1;
	WebElement we, we2;
	private WebDriver driver;
	String google_searchbar = "//input[@name='q']";
	String btn_search = "//input[@name='btnK']";
	String googleresult = "Google Scholar";
	
	public google_search(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void testgooglesearch() throws InterruptedException
	{
//		we = driver.findElement(By.xpath(google_searchbar));
//		we1 = driver.findElements(By.xpath(btn_search));
//		if(we.isDisplayed())
//		{
//			we.sendKeys("Search the article");
//			we.sendKeys(Keys.TAB);
//		}
//		Thread.sleep(5000);
//		for(WebElement w : we1)
//		{
//			System.out.println(w);
//			if(w.isDisplayed())
//			{
//				w.click();
//			}
//		}
//		Thread.sleep(5000);
		System.out.println("pom :: " + driver);
		we2 = driver.findElement(By.linkText(googleresult));
		try{
		System.out.println("**************pass");
		capturescreenshot css = new capturescreenshot();
//		css.error_screenshot(driver, "./Screenshots/test.jpg");
		assertEquals(we2.isDisplayed(), true);
			}
		catch(Exception e)
		{
			System.out.println("**************fail");
			assertFalse(true);
		}
	}
}
