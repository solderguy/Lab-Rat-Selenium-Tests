package jsoper.com.pair;

/**
 * @author John Soper
 * @version 1  May 4, 2015
 * 
 * Unit test of select pages of personal website with
 * Selenium driving Qunit web interface
 * 
 */

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LabRatUnitTests {
	static WebDriver driver;

	@BeforeClass
	static public void setUp() throws Exception {
		driver = Utils.getBrowserType();
	}

	@AfterClass
	static public void closeBrowser() {
		driver.close();
		driver.quit();
	}

	@Test
	public void testQuotes() {
		Utils.download("labRatFunctions.js");
		Utils.commentOutMethod();

		String workingDir = System.getProperty("user.dir");
		//System.out.println("user dir: " + workingDir);
		String str = "file:" + workingDir
				+ "/QunitFiles/labRat_test_harness.html";
		driver.get(str);

		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement element = driver.findElement(By.className("passed"));
		assertTrue(element.getText().contains("52"));

		element = driver.findElement(By.className("failed"));
		assertTrue(element.getText().contains("0"));

	}
}
