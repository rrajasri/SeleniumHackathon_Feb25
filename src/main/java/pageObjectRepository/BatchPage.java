package pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BatchPage {
	
	WebDriver driver;
	
	@FindBy (xpath="//*[text()='Batch']")
	WebElement batchMenu;  //Clicking Batch after login on Dashboard

	@FindBy (xpath = "//button[text()='Add New Batch']")
	WebElement addNewBatchSubMenu;  //Clicking on sub menu
	
	@FindBy (xpath = "//*[@class=\"p-button-icon pi pi-trash\"]")
	WebElement deleteIcon; //  Delete icon in Batch menu under manage batch
	
	@FindBy (xpath = "//*[text()=\" Manage Batch\"]")
	WebElement manageBatchLabel; // Manage batch Heading
	
	@FindBy (xpath = "//div[@class=\"action\"]/span/button[@icon=\"pi pi-pencil\"]")
	WebElement editIcon; //edit icon in data table
	
	@FindBy (xpath = "//tr[@class='ng-star-inserted']")
	WebElement tableRows;   //Data table rows including the header

	@FindBy (xpath = "//div[@class='action']/span/button[@icon='pi pi-trash']")
	WebElement deleteIconRow;  //Delete icon in data table
	
	@FindBy (xpath = "//div[@role='checkbox']")
	WebElement checkBox; // Check box in data table -- can use aria-checked = 'false' for disable
	
	@FindBy (xpath = "//th[@psortablecolumn='batchName']")
	WebElement batchNameHeader;  //Batch name data table header
	
	@FindBy (xpath = "//th[@psortablecolumn='batchDescription']")
	WebElement batchDescription; //Batch description data table header
	
	@FindBy (xpath = "//th[@psortablecolumn='batchStatus']")
	WebElement batchStatus;  //Batch status data table header
	
	@FindBy (xpath = "//th[@psortablecolumn='batchNoOfClasses']")
	WebElement noOfClasses; // No of classes data table header
	
	@FindBy (xpath = "//th[@psortablecolumn='programName']")
	WebElement programName; //Program name data table header
	
	
	@FindBy (xpath = "//tr[@class='ng-star-inserted']/th[text()=' Edit / Delete ']")
	WebElement editDelete; //Edit and delete data table header
	
	@FindBy (xpath = "//*[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	WebElement sortIcon;  //Sort icon next to headers in data table
	
	@FindBy (xpath = "//span[contains(@class, 'p-dialog-title') and text()='Batch Details']")
	WebElement batchDetailsWindow;  //Batch details window after clicking add new batch sub menu
	

}
