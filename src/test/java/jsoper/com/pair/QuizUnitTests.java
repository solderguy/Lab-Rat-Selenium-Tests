package jsoper.com.pair;

/**
 * @author John Soper
 * @version 1  May 4, 2015
 * 
 * Unit test of Xtreme Java Page from personal website 
 * with Selenium driving Qunit
 * 
 * Issues - already broke once because ISP changed address
 */

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuizUnitTests {
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = Utils.getBrowserType();
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

	@Test
	public void testMultiply() {
		Utils.download("quiz.js");
		Utils.download("q1.txt");
		Utils.download("q2.txt");
		Utils.download("q3.txt");
		Utils.download("q4.txt");
		Utils.download("q5.txt");
		Utils.download("q6.txt");
		Utils.download("q7.txt");
		Utils.download("q8.txt");
		Utils.download("q9.txt");
		Utils.download("q10.txt");
		Utils.download("q11.txt");
		Utils.download("q12.txt");

		String workingDir = System.getProperty("user.dir");
		String str = "file://" + workingDir
				+ "/QunitFiles/quiz_test_harness.html";
		driver.get(str);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement element = driver.findElement(By.className("passed"));
		assertTrue(element.getText().contains("16"));

		element = driver.findElement(By.className("failed"));
		assertTrue(element.getText().contains("0"));
	}
}
