package hooks;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilitities.ConfigReader;


public class Hooks {

	public WebDriver driver;
	private DriverFactory driverFactory;
	private static Properties prop;

	@Before
	public void beforeScenario() {
		
		driverFactory = new DriverFactory();
		prop = ConfigReader.initializeprop();
		String browser = prop.getProperty("browser");
		// String browser = ConfigReader.getBrowserType();
		driver = driverFactory.initializeBrowser(browser);
		driver.get(prop.getProperty("URL"));
	}

//	@After(order = 0)
//	public void quitBrowser() {
//		if (DriverFactory.getDriver() != null) {
//			DriverFactory.getDriver().quit();
//			DriverFactory.removeDriver();
//		}
//	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
		}
	}

}
