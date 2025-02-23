package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BatchPage {

    WebDriver driver;

	public BatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//button[span/text()='Batch']")
	WebElement batchMenu;  //Clicking Batch after login on Dashboard

	@FindBy (xpath = "//button[text()='Add New Batch']")
	WebElement addNewBatchSubMenu;  //Clicking on sub menu
	
	@FindBy (xpath = "//mat-card-title//button[span/@class=\"p-button-icon pi pi-trash\"]")
	WebElement topDeleteIcon; //  Delete icon in Batch menu under manage batch
	
	@FindBy (xpath = "//*[text()=\" Manage Batch\"]")
	WebElement manageBatchLabel; // Manage batch Heading

	@FindBy (xpath = "//p-paginator//button[text()='1']")
	WebElement page1Button;

	@FindBy (xpath = "//div[@class=\"action\"]/span/button[@icon=\"pi pi-pencil\"]")
	List<WebElement> editIcons; //edit icon in data table
	
	@FindBy (xpath = "//tbody/tr")
	List<WebElement> tableRows;   //Data table rows

	@FindBy (xpath = "//div[@class='action']/span/button[@icon='pi pi-trash']")
	List<WebElement> deleteIcons;  //Delete icon in data table
	
	@FindBy (xpath = "//tbody//div[@role='checkbox']")
	List<WebElement> checkBoxes; // Check box in data table -- can use aria-checked = 'false' for disable

	@FindBy (xpath = "//th//div[@role='checkbox']")
	WebElement headerCheckBox;

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
	List<WebElement> sortIcons;  //Sort icon next to headers in data table

	@FindBy (xpath = "//th[@psortablecolumn]")
	List<WebElement> sortableColumnHeaders;

	@FindBy (xpath = "//*[@id=\"mat-menu-panel-1\"]/div/button")
	WebElement addNewBatchMenu; //Add new batch sub menu
	
	@FindBy (xpath = "//span[contains(@class, 'p-dialog-title') and text()='Batch Details']")
	WebElement batchDetailsWindow;  //Batch details window after clicking add new batch sub menu
	
	@FindBy (xpath = "//span[contains(@class, 'p-button-label') and text()='Cancel']")
	WebElement cancelButtonInBatchDetails; //Cancel button in batch details window
	
	@FindBy (xpath = "//span[contains(@class, 'p-button-label') and text()='Save']")
	WebElement saveButtonInBatchDetails;  //Save button in batch details window
	
	@FindBy (xpath = "//*[@id='programName']/div/input[@aria-haspopup='listbox' and @type='text' and @placeholder='Select a Program name']")
	WebElement selectProgramNameListBox; //List box for select program name in batch details window

	@FindBy (xpath = "//p-dropdown[@id='programName']")
	WebElement selectProgramNameDropDown; //List box for select program name in batch details window, for selection

	@FindBy (xpath = "//input[@id='batchProg']")
	WebElement batchNameFirstInputBox;  //1st input box under batch name in batch details window
	
	@FindBy (xpath = "//input[@type = 'text' and @id='batchName']")
	WebElement batchNameSecondInputBox;  //2nd input box under batch name in batch details window
	
	@FindBy (xpath = "//input[@id='batchDescription' and @type = 'text']")
	WebElement batchDescriptionInputBox;  //Batch description input box in batch details window

	@FindBy (xpath = "//p-radiobutton[@id='batchStatus']")
	List<WebElement> batchStatuses;  //Batch status radio buttons in batch details window

	@FindBy (xpath = "//input[@id='batchNoOfClasses' and @type = 'number']")
	WebElement numberOfClassedInputBox;  //No of classes input box in batch details window

	@FindBy (xpath = "//div[contains (@class, 'p-dialog-header-icons')]")
	WebElement closeButtonInBatchDetailsBox;  //Close button (X) in batch details dialog box
	
	@FindBy (xpath = "//*[@id='filterGlobal']")
	WebElement searchBox; //Search box in main page

    public void navigateToBatchPage() {
		this.openMenu("Batch");
	}
	
	public void clickOnBatchMenu() {
		addNewBatchSubMenu.click();
	}

	public void selectProgramNameInBatchDetailsPopup(String programName) {
		driver.findElement(By.xpath("//p-dropdown//span")).click();
		driver.findElement(By.xpath("//p-dropdownitem/li[span[contains(text(), 'seleniumcucumber')]]")).click();
    }
	
	public void clickOnSave() {
		saveButtonInBatchDetails.click();
	}
	
	public void clickOnCancel() {
		cancelButtonInBatchDetails.click();
	}

	public boolean hasManageBatchLabel() {
		return manageBatchLabel.isDisplayed();
	}

	public boolean hasPageTitle(String title) {
		return driver.findElement(By.xpath("//app-header[//span/text() = '" + title + "']")).isDisplayed();
	}

	public boolean hasTopDeleteIconDisabled() {
		return topDeleteIcon.getDomAttribute("disabled") != null;
	}

	public boolean hasPage1Enabled() {
		return page1Button.getDomAttribute("disabled") == null;
	}

	public int editIconsCount() {
		return editIcons.size();
	}

	public int tableRowsCount() {
		return tableRows.size();
	}

	public int deleteIconsCount() {
		return deleteIcons.size();
	}

	public int checkBoxesCount() {
		return checkBoxes.size();
	}

	public boolean hasHeader(String title) {
		return driver.findElement(By.xpath("//th[contains(text(), '" + title + "')]")).isDisplayed();
	}

	public int sortableColumnsCount() {
		return sortableColumnHeaders.size();
	}

	public int sortIconsCount() {
		return sortIcons.size();
	}

	public boolean hasHeaderCheckBox() {
		return headerCheckBox.isDisplayed();
	}

	public void openMenu(String menuName) {
		switch (menuName) {
			case "Batch":
				batchMenu.click();
				break;
		}
	}

	public boolean hasSubMenu(String subMenuName) {
		switch (subMenuName) {
			case "Add New Batch":
				return addNewBatchSubMenu.isDisplayed();
		}

		return false;
	}

	public void openSubMenu(String subMenuName) {
		switch (subMenuName) {
			case "Add New Batch":
				addNewBatchSubMenu.click();
		}
	}

	public boolean isAddNewBatchPopupDisplaying() {
		return batchDetailsWindow.isDisplayed();
	}

	public boolean isFieldAndTypeDisplayedAppropriately(String fieldName) {
		switch (fieldName) {
			case "Batch Name":
				return batchNameSecondInputBox.isDisplayed();
			case "Program Name":
				return selectProgramNameListBox.isDisplayed();
			case "Description":
				return batchDescriptionInputBox.isDisplayed();
			case "Status":
				return batchStatuses.get(0).isDisplayed() && batchStatuses.get(1).isDisplayed();
			case "Number of Classes":
				return numberOfClassedInputBox.isDisplayed();
		}

		return false;
	}

	public boolean isFieldEnabled(String fieldName) {
		switch (fieldName) {
			case "Batch Name":
				return batchNameSecondInputBox.getDomAttribute("disabled") == null;
			case "Program Name":
				return selectProgramNameListBox.getDomAttribute("disabled") == null;
			case "Description":
				return batchDescriptionInputBox.getDomAttribute("disabled") == null;
			case "Status":
				return batchStatuses.get(0).getDomAttribute("disabled") == null
						&& batchStatuses.get(1).getDomAttribute("disabled") == null;
			case "Number of Classes":
				return numberOfClassedInputBox.getDomAttribute("disabled") == null;
		}

		return false;
	}

	public String getTextOnBatchNamePrefix() {
		return batchNameFirstInputBox.getDomProperty("value");
	}
}