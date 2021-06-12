package testapp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.google_search;
import Utilities.baseclass;
import Utilities.superclass;

public class test1 {
//	private WebDriver driver;
	test t;
	@Test
	public void test1_google() throws InterruptedException
	{
//		driver = get_driver();
		t = new test();
		t.ert.startTest("test1_google");;
		t.ert.getstatus("pass");
		t.ert.reportend();
		System.out.println("test1 :: " + test.getDriver());
		google_search gs = new google_search(test.getDriver());
		gs.testgooglesearch();
	}
}
