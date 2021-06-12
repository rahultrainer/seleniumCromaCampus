package testapp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;

import POM.google;
import POM.google_search;
import Utilities.baseclass;
import Utilities.superclass;

public class test extends baseclass {
	
//	private WebDriver driver;
	private String sTestCaseName;
	WebDriverWait wait;
	baseclass base;
	
	@DataProvider(name = "data-provider")
	public Object[][] testprovider() throws Exception
	{
//		test_report("testpp");
		Object[][] testObjArray = readwriteexcel.readexcel("./data/testdata.xlsx", "test");
//		getstatus("fail");
//		report.flush();
		return testObjArray;
	}
//	
//	@DataProvider(name = "data-provider1")
//	public Object[][] testprovider1()
//	{
//		return new Object[][] {{1},{2}};
//	}
	
//	@Test(priority = 2)
//	public void test()
//	{
//		System.out.println("inside test");
//	}
//	@Test(priority = 1)
//	public void test3()
//	{
//		System.out.println("inside test 3");
//	}
//	@Test(priority = 3)
//	public void test2()
//	{
//		System.out.println("inside test 2");
//	}
	
//	@Test(dataProvider="data-provider")
////	@Test(priority = 2)
////	(priority = 1)
//	public void test1(String userid, String password, String mobile)
////	public void test1()
//	{		
////		driver.findElement(By.xpath("")).is; //, isSelected, is
//		wait = new WebDriverWait(driver, 30);
//		ert.test_report("test");
////		Reporter.log(userid + " ::: inside test 1 ::: " + password + " :pass: "+ mobile);
////		System.out.println(userid + " ::: inside test 1 ::: " + password + " :pass: "+ mobile);
//		driver.get("https://www.google.co.in");
////		google g = new google(driver);
////		g.testgoogle();
//		ert.getstatus("fail");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("lnXdpd"))).click();
//	}
	
	@Test
	public void test2() throws InterruptedException
	{
		System.out.println("test :: " + getDriver());
		getDriver().get("https://www.google.co.in");
		google g = new google(getDriver());
		g.testgoogle();
		ert.startTest("test2");;
		ert.getstatus("fail");
//		ert.reportend();
//		extentreport.flush();
	}
}
