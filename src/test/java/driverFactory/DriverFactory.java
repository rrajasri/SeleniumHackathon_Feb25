package driverFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver initializeBrowser(String browser) {
		if (browser == null || browser.isEmpty()) {
			throw new IllegalArgumentException("Browser name must not be null or empty.");
		}

		try {
			switch (browser.toLowerCase()) {
			case "chrome":
				// ChromeOptions chromeOptions = new ChromeOptions();
				// chromeOptions.addArguments("headless");
				tlDriver.set(new ChromeDriver());
				break;
			case "firefox":
				// FirefoxOptions firefoxOptions = new FirefoxOptions();
				// firefoxOptions.addArguments("headless");
				tlDriver.set(new FirefoxDriver());
				break;
			case "edge":
				// EdgeOptions edgeOptions = new EdgeOptions();
				// edgeOptions.addArguments("headless");
				tlDriver.set(new EdgeDriver());
				break;
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
		} catch (Exception e) {
			System.err.println("Error initializing browser: " + e.getMessage());
			throw e;
		}

		WebDriver driver = getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public static WebDriver getDriver() {
		WebDriver driver = tlDriver.get();
		if (driver == null) {
			throw new IllegalStateException("WebDriver is not initialized. Did you call initializeBrowser?");
		}
		return driver;
	}

	public static void removeDriver() {
		WebDriver driver = tlDriver.get();
		if (driver != null) {
			driver.quit();
			tlDriver.remove();
		}
	}
}




































//package driverFactory;
//
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URL;
//import java.time.Duration;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class DriverFactory {
//
//	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//
//    public WebDriver initializeBrowser(String browserName) {
//        if (browserName == null || browserName.isEmpty()) {
//            throw new IllegalArgumentException("Browser name must not be null or empty.");
//        }
//
//        try {
//            // Connect to Selenium Grid
//            URL gridUrl = URI.create("http://localhost:4444/wd/hub").toURL();
//
//            // Set Desired Capabilities for remote execution
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setBrowserName(browserName.toLowerCase());
//
//            tlDriver.set(new RemoteWebDriver(gridUrl, capabilities));
//
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("Invalid Selenium Grid URL: " + e.getMessage());
//        }
//
//        // Set Browser Configurations
//        WebDriver driver = getDriver();
//        driver.manage().deleteAllCookies();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        return driver;
//    }
//
//    public static synchronized WebDriver getDriver() {
//        WebDriver driver = tlDriver.get();
//        if (driver == null) {
//            throw new IllegalStateException("WebDriver is not initialized. Did you call initializeBrowser?");
//        }
//        return driver;
//    }
//
//    public static void removeDriver() {
//        tlDriver.remove(); // Clear the ThreadLocal after quitting the driver
//    }
//}