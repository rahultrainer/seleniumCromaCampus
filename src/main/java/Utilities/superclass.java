package Utilities;

import org.openqa.selenium.WebDriver;

public class superclass {
	public WebDriver driver;

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
}
