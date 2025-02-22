package pageObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgramEditPage {
	WebDriver driver;
	WebDriverWait wait;

	public ProgramEditPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//table//tbody//tr[1]//button[@id='editProgram']")
	WebElement editfirstprogrambutton;
	@FindBy(xpath="//span[@id='pr_id_2-label']")
	WebElement editPageTitle;
	

	public void editProgramButton() {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(editfirstprogrambutton));
		editfirstprogrambutton.click();
	}
	public boolean editPageTitleDisplay() {
		return editPageTitle.isDisplayed();
	}

	public String editPageTitle() {
		return editPageTitle.getText();
	}
}
	