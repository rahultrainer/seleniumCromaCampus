package Utilities;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class capturescreenshot {

	public static void error_screenshot(WebDriver webdriver, String sspath)
	{
		TakesScreenshot tss = ((TakesScreenshot)webdriver);
		File screenfile = tss.getScreenshotAs(OutputType.FILE);
		File destpath = new File(sspath);
		try
			{
				FileHandler.copy(screenfile, destpath);
			}
		catch(Exception e)
			{
				System.out.println("path not found");
			}
	}
}
