package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.*;

public class ProgramEditStep {
	WebDriver driver = DriverFactory.getDriver();
	ProgramPage ProgramPage = new ProgramPage(driver);
	ProgramEditPage ProgramEditPage = new ProgramEditPage(driver);
	ProgramAddNewPage ProgramAddNewPage = new ProgramAddNewPage(driver);
	
	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() {
		driver.navigate().refresh();
		ProgramEditPage.editProgramButton();
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() {
		Assert.assertTrue(ProgramEditPage.editPageTitleDisplay());
	}
	@Then("Admin should see editwindow title as {string}")
	public void admin_should_see_editwindow_title_as(String expectedtext) {
		String actualtext = ProgramEditPage.editPageTitle();
		Assert.assertEquals(actualtext, expectedtext,"Text did not match");
	}
	@When("Admin edits {string} in the {string} text box and click on save button")
	public void admin_edits_in_the_text_box_and_click_on_save_button(String fieldName, String fieldValue) {
		driver.navigate().refresh();
		ProgramEditPage.editProgramButton();
		ProgramAddNewPage.enterTextInField(fieldName, fieldValue);
	}

	 




}
