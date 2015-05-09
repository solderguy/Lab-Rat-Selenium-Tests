package jsoper.com.pair;

/**
 * @author John Soper
 * @version 1  May 4, 2015
 * 
 * Static utility methods for Selenium testing
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Utils {

	public static WebDriver getBrowserType() {
		// In Eclipse select which browser to use by
		// Run As > Run Configuration > arguments > VM arguments
		// -Dbrowser=chrome
		// -Dbrowser=firefox
		// Also ok to leave blank because Firefox is default

		Platform platform = Platform.getCurrent();
		//System.out.println("platform: " + platform);

		String browser = System.getProperty("browser");
		if (browser.equals("chrome") || browser.equals("Chrome"))
			return new ChromeDriver();

		else if (browser.equals("ieexplorer") || browser.equals("explorer")
				|| browser.equals("IEexplorer") || browser.equals("ie")) {
			if ( (Platform.WINDOWS.is(platform)) ||
			     (Platform.VISTA.is(platform))   ||
			     (Platform.WIN8.is(platform))    ||
			     (Platform.XP.is(platform)) ) {
				File file = new File("C:/eclipse/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				return new InternetExplorerDriver();
			} else {
				System.out.println("IE not supported, using Firefox default");
				return new FirefoxDriver();
			}

		} else if (browser.equals("safari") || browser.equals("Safari")) {
			if (Platform.MAC.is(platform))
				return new SafariDriver();
			else {
				System.out
						.println("Safari not supported, using Firefox default");
				return new FirefoxDriver();
			}

		} else
			return new FirefoxDriver(); // default, and always works the most
	}

	public static void download(String fName) {
		String fileName = "QunitFiles/js/" + fName;
		String webAddr = "http://www530.pair.com/jsoper/js/" + fName;
		try {
			URL url = new URL(webAddr);
			File file = new File(fileName);
			if (file.exists())
				file.delete();
			FileUtils.copyURLToFile(url, file);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void commentOutMethod() {
		try {
			File file = new File("QunitFiles/js/labRatFunctions.js");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "", oldtext = "";
			while ((line = reader.readLine()) != null) {
				oldtext += line + "\r\n";
			}
			reader.close();
			// Comment out from the start to the end of the blinkIt method
			// because Selnium doesn't like it
			String midtext = oldtext.replaceAll("function blinkIt",
					"/*\nfunction blinkIt");
			String newtext = midtext.replaceAll("var quotes = ",
					"*/\nvar quotes = ");

			FileWriter writer = new FileWriter(
					"QunitFiles/js/labRatFunctions.js");
			writer.write(newtext);
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Please run directly as junit tests");
	}
}
