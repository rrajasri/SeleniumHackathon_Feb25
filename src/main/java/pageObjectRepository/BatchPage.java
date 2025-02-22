package pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy (xpath = "//*[@id=\"mat-menu-panel-1\"]/div/button")
	WebElement addNewBatchMenu; //Add new batch sub menu
	
	@FindBy (xpath = "//span[contains(@class, 'p-dialog-title') and text()='Batch Details']")
	WebElement batchDetailsWindow;  //Batch details window after clicking add new batch sub menu
	
	@FindBy (xpath = "//span[contains(@class, 'p-button-label') and text()='Cancel']")
	WebElement cancelButtonInBatchDetails; //Cancel button in batch details window
	
	@FindBy (xpath = "//span[contains(@class, 'p-button-label') and text()='Save']")
	WebElement saveButtonInBatchDetails;  //Save button in batch details window
	
	@FindBy (xpath = "//*[@id=\"programName\"]/div/input[@placeholder='Select a Program name']")
	WebElement selectProgramNameListBox; //List box for select program name in batch details window
	
	@FindBy (xpath = "//*[@id=\"batchProg\"]")
	WebElement batchNameFirstInputtBox;  //1st input box under batch name in batch details window
	
	@FindBy (xpath = "//*[@id=\"batchName\"]")
	WebElement batchNameSecondInputBox;  //2nd input box under batch name in batch details window
	
	@FindBy (xpath = "//*[@id=\"batchDescription\"]")
	WebElement batchDescriptionInputBox;  //Batch description input box in batch details window
	
	@FindBy (xpath = "//div[contains (@class, 'p-dialog-header-icons')]")
	WebElement closeButtonInBatchDetailsBox;  //Close button (X) in batch details dialog box
	
	@FindBy (xpath = "//*[@id='filterGlobal']")
	WebElement searchBox; //Search box in main page
	
	
	public void navigateToBatchPage(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBatch()
	{
		batchMenu.click();
	}
	
	public void clickOnBatchMenu() {
		addNewBatchSubMenu.click();
	}

	public void selectProgramNameBatchDetailsPopup() {
		selectProgramNameListBox.click();
	}
	
	public void clickOnSave() {
		saveButtonInBatchDetails.click();
	}
	
	public void clickOnCancel() {
		cancelButtonInBatchDetails.click();
	}

	
}
