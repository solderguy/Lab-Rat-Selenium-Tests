package jsoper.com.pair;

/**
 * @author John Soper
 * @version 1  May 4, 2015
 * 
 * Function test of select pages of personal website with
 * Selenium
 * 
 */

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LabRatFuncTests {
	static WebDriver driver;

	@BeforeClass
	static public void setUp() {
		driver = Utils.getBrowserType();
	}

	@AfterClass
	static public void closeBrowser() {
		driver.close();
		driver.quit();
	}

	@Test
	public void testAutofire() {
		driver.get("http://www.pair.com/jsoper");
		driver.findElement(By.linkText("Autofire Circuit")).click();
		assertTrue(true);
	}

}
