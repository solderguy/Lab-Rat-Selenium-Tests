package jsoper.com.pair;

/**
 * @author John Soper
 * @version 1  May 4, 2015
 * 
 * Function test of Raspberry Pi Hadoop Cluster page from personal 
 * website with Selenium
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PiClusterFuncTests {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = Utils.getBrowserType();
		baseUrl = "http://www530.pair.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// http://selenium-suresh.blogspot.com/2013/09/selenium-webdriver-methods-with-examples.html
	// https://github.com/eviltester/startUsingSeleniumWebDriver/blob/master/src/test/java/com/eviltester/webdriver/MyFirstTest.java

	@Test
	public void testRaspPiClusterFuncTetss() throws Exception {
		driver.get(baseUrl + "/jsoper/index.html");
		driver.findElement(By.linkText("The $300 Raspberry Pi Hadoop Cluster"))
				.click();
		assertEquals("The 8-Bit Lab Rat", driver.getTitle());
		
		try {
			assertTrue(isElementPresent(By.xpath("//tr[11]/td[5]")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		try {
			assertTrue(isElementPresent(By
					.linkText("Raspberry Pi Board (model B)")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		try {
			assertTrue(isElementPresent(By
					.cssSelector("img[alt=\"raspberry pi board\"]")));
//			float height = driver
//					.findElement(
//							By.cssSelector("img[alt=\"raspberry pi board\"]"))
//					.getSize().getHeight();
//			float width = driver
//					.findElement(
//							By.cssSelector("img[alt=\"raspberry pi board\"]"))
//					.getSize().getWidth();
//			System.out.println("height: " + height);
//			System.out.println("width: " + width);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		assertTrue(isElementPresent(By.cssSelector("img.centerImg")));
		assertEquals("Single Board Mac Interfacing",
				driver.findElement(By.xpath("//h5[2]")).getText());
		assertTrue(isElementPresent(By
				.xpath("//img[@alt='X11 headless setup']")));
		assertTrue(isElementPresent(By.xpath("//img[@alt='cluster rear view']")));
		assertTrue(isElementPresent(By.xpath("//img[@alt='nodes in browser']")));
		assertEquals(
				"",
				driver.findElement(
						By.xpath("//img[@alt='frontal cluster shot']"))
						.getText());
		assertEquals("Front shot", driver.findElement(By.xpath("//h2[5]"))
				.getText());
		assertEquals("",
				driver.findElement(By.cssSelector("img[alt=\"back icon\"]"))
						.getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
