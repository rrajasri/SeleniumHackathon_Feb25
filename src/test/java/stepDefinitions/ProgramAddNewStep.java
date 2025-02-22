package stepDefinitions;

import java.util.concurrent.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.*;

public class ProgramAddNewStep {
	WebDriver driver = DriverFactory.getDriver();
	ProgramPage ProgramPage = new ProgramPage(driver);
	ProgramAddNewPage ProgramAddNewPage = new ProgramAddNewPage(driver);
	 

	@Given("Admin is on Program page")
	public void admin_is_on_program_page() {
		ProgramPage.program();
	}

	@When("Admin clicks on Add New Program under the Program menu bar")
	public void admin_clicks_on_under_the_menu_bar() {
		ProgramAddNewPage.addNewProgram();
	}

	@Then("Admin should see pop up window for program details")
	public void admin_should_see_pop_up_window_for_program_details() {
		Assert.assertTrue(ProgramAddNewPage.newClassPopUpBox());

	}

	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as_program_details(String expectedtext) {
		String actualtext = ProgramAddNewPage.popUpTitle();
		Assert.assertEquals(actualtext, expectedtext,"Text did not match");
	}

	@Then("Admin should see red asterisk mark beside mandatory field Name")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field_name() {
		Assert.assertTrue(ProgramAddNewPage.redAstrickBesideName());
	}

	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() {
		ProgramPage.program();
		ProgramAddNewPage.addNewProgram();
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
		ProgramAddNewPage.popUpSaveButton();
	}

	@Then("Admin gets message {string} is required")
	public void admin_gets_message_field_is_required(String fieldName) throws TimeoutException {
		Assert.assertTrue(ProgramAddNewPage.fieldRequired(fieldName),
				"Error message for '" + fieldName + "' is NOT displayed!");
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		ProgramAddNewPage.verifyCancelButton();
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {
		Assert.assertTrue(ProgramAddNewPage.isProgramDetailsFormInvisible(),
				"Program Details form did not disappear after clicking Cancel");
	}

	@When("Admin enters {string} in the {string} text box and click on save button")
	public void admin_enters_text_in_field(String fieldValue, String fieldName) {
		ProgramAddNewPage.enterTextInField(fieldName, fieldValue);
	}

	@Then("Admin can see the entered text in {string} box")
	public void admin_can_see_text_in_field(String fieldName) {
		String actualText = ProgramAddNewPage.getEnteredText(fieldName);
		System.out.println("actualText is" + actualText);
		Assert.assertFalse(actualText.isEmpty());
	}

	@When("Admin selects the status of the program by clicking on the radio button {string}")
	public void admin_selects_the_status(String status) {
		ProgramAddNewPage.selectProgramStatus(status);
	}

	@Then("Admin can see {string} status selected")
	public void admin_can_see_status_selected(String expectedStatus) {
		String actualStatus = ProgramAddNewPage.getSelectedStatus();
		System.out.println("actualStatus is " + actualStatus);

		Assert.assertEquals(actualStatus, expectedStatus, "status does not match");
	}
	
//	    @When("Admin creates a new program with {string}, {string}, and {string}")
//	    public void admin_creates_a_new_program(String programName, String description, String status) {
//	    	 //Storing values for later use
//	    	 createdProgramName = programName;
//	         createdProgramDescription = description;
//	         createdProgramStatus = status;
//	         ProgramAddNewPage.addNewProgram();
//	    	ProgramAddNewPage.enterProgramName(programName);
//	    	System.out.println("programName is" + programName);
//	    	ProgramAddNewPage.enterDescription(description);
//	    	System.out.println("description is" + description);
//	    	ProgramAddNewPage.selectProgramStatus(status);
//	    	System.out.println("status is" + status);
//	    	ProgramAddNewPage.popUpSaveButton();
//	    }

	    @When("Admin searches with newly created {string}")
	    public void admin_searches_with_newly_created_program(String programName) {

	    	ProgramAddNewPage.searchProgram(programName);
	    	
	    	
	    }

	    @Then("Records of the newly created {string} is displayed and match the data entered")
	    public void records_of_newly_created_program_is_displayed(String ProgramName) {
	        Assert.assertTrue( ProgramAddNewPage.isProgramDisplayed(ProgramName));
	        		
	    }
	    @When("Admin Click on X button")
	    public void admin_click_on_button() {
	    	ProgramAddNewPage.verifyXButton();
	    }
	}



