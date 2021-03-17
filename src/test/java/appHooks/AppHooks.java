package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {

	private DriverFactory df;
	private WebDriver driver;
	private ConfigReader cr;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {

		cr = new ConfigReader();
		prop = cr.init_prop();

	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		df = new DriverFactory();
		// if we do not store this in driver, driver.quit will through null pointer
		driver = df.init_driver(browserName);
	}

	// for @After order 1 will execute first and then order 0 will execute
	@After(order = 0)
	public void quitBrowser() {

		driver.quit();

	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {

			// take screenshot:

			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
		}

	}

}
