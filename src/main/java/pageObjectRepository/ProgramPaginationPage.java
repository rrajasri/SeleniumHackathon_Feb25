package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProgramPaginationPage {
	
	private WebDriver driver;
	
	public ProgramPaginationPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	private By Next =  By.xpath("//span[contains(@class, 'p-paginator-icon') and contains(@class, 'pi-angle-right')]");
	private By disblednext = By.xpath("//span[contains(@class  , 'p-paginator-current')]");
	private By program = By.xpath("//button//span[text() ='Program']"); 
	private By doublenext = By.xpath("//span[contains(@class  , 'pi pi-angle-double-right')]");
	//private By totalPagestext = By.xpath("//div [text()=' In total there are 76 programs. ']");
	private By firstpage = By.xpath("//p-paginator//button[text()='1']");
	private By doublePrevious = By.xpath("//button[contains(@class , 'p-paginator-first')]");
	private By previous = By.xpath("//button[contains(@class , 'p-paginator-prev')]");
	private By totalentries = By.xpath("//span[contains(text() , 'entries')]");
	
	//private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//private JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public void clickProgram() {
		
		driver.findElement(program).click();
		
	}
	
	 public void clickNext() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement next = driver.findElement(Next);
		next.isEnabled();
		js.executeScript("arguments[0].click();", next);
		//next.click();
		
	 }
	 
	 public boolean Nextisactive() {
		 
		return driver.findElement(Next).isEnabled();
		 
	 }
	 
	 public void doubleNext() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement doublenext1 = driver.findElement(doublenext);
		 js.executeScript("arguments[0].click();", doublenext1);
		 
	 }
	 
	 public boolean disableNextcheck() {
		 
		 WebElement disable = driver.findElement(doublenext);
		 return disable.isEnabled();
		 }
	 
	 public int gettoatalentries() {
		 
		 String total_Entries = driver.findElement(totalentries).getText();
		 String[] parts = total_Entries.split(" ");
	        return Integer.parseInt(parts[5]);
	 }
	 
	 public int getTotalPages(int entriesPerPage) {
	        int totalEntries = gettoatalentries();
	        return (int) Math.ceil((double) totalEntries / entriesPerPage);
	    } 
	 
	 public void goToLastPageUsingNextButton() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    while (driver.findElement(Next).isEnabled()) {
		    	
		      WebElement next =   driver.findElement(Next);
		        js.executeScript("arguments[0].click();", next);
		    }
		}
	 
	 public void goToLastPage() {
		    try {
		        int totalPages = getTotalPages(10); // Example: If 10 entries per page
		        By lastPageNumber = By.xpath("//a[text()='" + totalPages + "']");

		        if (driver.findElements(lastPageNumber).size() > 0) {
		            driver.findElement(lastPageNumber).click();  // Click last page directly
		        } else {
		            goToLastPageUsingNextButton();  // Click "Next" until disabled
		        }
		    } catch (Exception e) {
		        System.out.println("Error navigating to last page: " + e.getMessage());
		    }
		}
	 
	 public int getCurrentPageNumber(int entriesPerPage) {
	        String text = driver.findElement(totalentries).getText();  
	        String[] parts = text.split(" ");
	        int firstEntryNumber = Integer.parseInt(parts[1]); // Extracts "61" in "Showing 61 to 70 of 76 entries"
	        return (firstEntryNumber / entriesPerPage) + 1;  // Calculate the current page number
	    }
	 
	 public boolean checkPreviousbutton() {
		 
		
		 return  driver.findElement(previous).isEnabled();
		 
		
	 }
	  public void clickFirst() {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement first =  driver.findElement(firstpage);
		 js.executeScript("arguments[0].click();", first);
	  }
	 
	 public boolean checkdoubleprevious() {
		 
		return driver.findElement(doublePrevious).isEnabled();
		 
	 }
	 
	 public void clickPrevious() {
		 
		// Actions actions = new Actions(driver);
		WebElement previ= driver.findElement(previous);
		//actions.scrollToElement(previ).click().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", previ);

	 }

	
}
