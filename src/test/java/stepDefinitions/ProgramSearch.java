package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepository.ProgramAddNewPage;
import pageObjectRepository.ProgramDeletePage;
import pageObjectRepository.ProgramEditPage;
import pageObjectRepository.ProgramPage;

public class ProgramSearch {
	
	WebDriver driver = DriverFactory.getDriver();
	ProgramPage ProgramPage = new ProgramPage(driver);
	ProgramEditPage ProgramEditPage = new ProgramEditPage(driver);
	ProgramAddNewPage ProgramAddNewPage = new ProgramAddNewPage(driver);
	ProgramDeletePage ProgramDeletePage = new ProgramDeletePage(driver);
	
	@When("Admin enter the program to search By program name {string} and {int}")
	public void admin_enter_the_program_to_search_by_program_name_and(String sheetname, Integer rownumber) {
	   
	}
	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
	    
	}

}
