package pageObjectRepository;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitities.ConfigReader;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver Driver) {

		this.driver = Driver;
	}

	// Locators

	private By appImage = By.xpath("//img[@class='images']");
	private By loginHeader = By.xpath("//p[text()='Please login to LMS application']");
	private By userLabel = By.xpath("//span[text()='User']");
	private By userField = By.xpath("//input[@id='username']");
	private By userAstrek = By.xpath("//label[@id='mat-form-field-label-1']//span[2]");
	private By passwordLabel = By.xpath("//span[text()='Password']");
	private By passwordFiled = By.xpath("//input[@id = 'password']");
	private By passwordAstrek = By.xpath("//label[@id='mat-form-field-label-3']//span[2]");
	private By LoginButton = By.xpath("//button[@id='login']");
	private By selectRoleLabel = By.xpath("//span[text()='Select the role']");
	private By selectRoleDropdown = By.xpath("//mat-select[@id='mat-select-0']");
	private By Selectroledropdownitems = By.xpath("//span[@class='mat-option-text']");
	private By SelectroleArrow = By.xpath("//div[@class='mat-select-arrow ng-tns-c161-3']");
	private By Usernamealert = By.xpath("//mat-error[@id='mat-error-1']");
	private By Passwordalert = By.xpath("//mat-error[@id='mat-error-2']");
	private By InvalidURLalertmessage = By.className("message__title");
	private By Iframe = By.xpath("//iframe[1]");//By.tagName("iframe")
	private By Loginform = By.xpath("//mat-card[@class='mat-card mat-focus-indicator']");
	
	private static Properties prop;

	public String getpagetitle() {

		return driver.getTitle();

	}

	public void invalidurl() {

		prop = ConfigReader.initializeprop();
		String invalidurl = prop.getProperty("invalidurl");
		driver.get(invalidurl);

	}

	public String getinvalidurlalert() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(Iframe));
        driver.switchTo().frame(iframe);

        // Step 3: Find the element and extract the text
        WebElement messageElement = driver.findElement(InvalidURLalertmessage);
        String messageText = messageElement.getText();
		return messageText;
		
		
	}

	public  int getBrokenLinks() throws IOException {

		String url = driver.getCurrentUrl();
		
		 HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	        connection.setRequestMethod("GET");
	        connection.connect();

	        // Get response code
	        int responseCode = connection.getResponseCode();
	        return responseCode;
	
	}
	
	public String getusernamelabel() {
		
		return driver.findElement(userLabel).getText();
		
	}
	
	public String getPasswordlabel() {
		
		return driver.findElement(passwordLabel).getText();
		
	}
	
	
	public String applicationText() throws TesseractException {
		
		// Initialize Tesseract OCR
		String tessDataPath = "C:\\Users\\rakhy\\Selenium_Hackathon\\SeleniumHackathon_Feb25\\src\\test\\resources\\tessdata";
		System.setProperty("TESSDATA_PREFIX", tessDataPath);
		 String path = "C:\\Users\\rakhy\\Selenium_Hackathon\\SeleniumHackathon_Feb25\\LMS-logo.png"; // Path to image
	        ITesseract tesseract = new Tesseract();
	        tesseract.setDatapath(tessDataPath);
	        tesseract.setLanguage("eng");
		
		String result = tesseract.doOCR(new File(path));
		result = result.replaceAll("[^a-zA-Z0-9\\s]", "").trim();
		 String[] lines = result.split("\n");
	        if (lines.length > 0) {
	            return lines[0].trim();  // Return the first line of text
	        }

	        return null;  // Return null if no text was found
	    }
	
	public String getcomapnyname() throws TesseractException {
		
		String tessDataPath = "\"C:\\Program Files\\Tesseract-OCR\\tessdata";
		System.setProperty("TESSDATA_PREFIX", tessDataPath);
		 String path = "C:\\Users\\rakhy\\Selenium_Hackathon\\SeleniumHackathon_Feb25\\LMS-logo.png"; // Path to image
	        ITesseract tesseract = new Tesseract();
	        tesseract.setDatapath(tessDataPath);
	        tesseract.setLanguage("eng");

	        // Perform OCR on the image
	        String result = tesseract.doOCR(new File(path));

	        // Optional: Clean up result
	        result = result.replaceAll("[^a-zA-Z0-9\\s]", "").trim();

	        // Split and return the second line of the OCR result
	        String[] lines = result.split("\n");
	        if (lines.length > 1) {
	            return lines[1].trim();  // Return the second line of text
	        }

	        return null;  // Return null if no second line was found
	    }

	public String getLoginHeader() {
		
		return driver.findElement(loginHeader).getText();
		
	}
	
	public Boolean userfieldspresent() {
		
		return driver.findElement(userField).isDisplayed();
		
	}
	
	public Boolean passwordfieldpresent() {
		
		return driver.findElement(passwordFiled).isDisplayed();
	}

	 public String userreqired() {
		 
		 return driver.findElement(userAstrek).getText();
	 }
	 
	 public String passwordrequired() {
		 return driver.findElement(passwordAstrek).getText();
	 }
	
	 public Boolean Dropdowndisplay() {
		 
		 return driver.findElement(selectRoleDropdown).isDisplayed();
	 }
	 
	 public String dropdownLabel() {
		 
		return driver.findElement(selectRoleLabel).getText();
		 
	 }
	 
	 public List<String> dropdownitems() {
		 driver.findElement(SelectroleArrow).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Selectroledropdownitems));
	        List<WebElement> options = driver.findElements(Selectroledropdownitems);
	        return options.stream()
	                      .map(WebElement::getText)
	                      .collect(Collectors.toList());
		
		 
	 }
	 
	 public boolean inputfields_centeralignment() {
		 
		 WebElement form = driver.findElement(Loginform);
		 
		    int formX = form.getLocation().getX();
		    int formY = form.getLocation().getY();
		    int formWidth = form.getSize().getWidth();
		    int formHeight = form.getSize().getHeight();

		    // Get the position and size of the browser window
		    int windowWidth = driver.manage().window().getSize().getWidth();
		    int windowHeight = driver.manage().window().getSize().getHeight();

		    // Calculate the center of the form
		    int formCenterX = formX + formWidth / 2;
		    int formCenterY = formY + formHeight / 2;

		    // Calculate the center of the browser window
		    int windowCenterX = windowWidth / 2;
		    int windowCenterY = windowHeight / 2;

		    // Check if the form's center is aligned with the center of the window
		    return formCenterX == windowCenterX && formCenterY == windowCenterY;
		 
	 }
	 public boolean loginbutton() {
		 
		return driver.findElement(LoginButton).isDisplayed();
		 
	 }
	 
	 public String getuserfieldcolor() {
		 
		return driver.findElement(userField).getCssValue("color");
		 
	 }
	 
	 public String getPasswordcolor() {
		 
		return driver.findElement(passwordFiled).getCssValue("color");
		 
	 }
}