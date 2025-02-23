package pageObjectRepository;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage  {
  
	WebDriver driver;//=new ChromeDriver();
  @FindBy(xpath="//*[text()=\" LMS - Learning Management System \"]")
  private WebElement Lmstitle;
  @FindBy(xpath="//*[@class=\"mat-ripple mat-button-ripple\"]")
  private WebElement alltextAlighnment;
  
  
  

  
  @FindBy(xpath="//app-doughnutchart")
  private WebElement piechart;
  
  @FindBy(xpath="//mat-card-content[@class='mat-card-content']//canvas[@class='chartjs-render-monitor']")
  private WebElement barchart;
  

  @FindBy (xpath="//*[text()=\" Welcome sdetnumpyninja@gmail.com\"]")
  WebElement welcomeMessage;
  @FindBy(xpath="//*[text()=\"ADMIN\"]")
  WebElement role;
  
  @FindBy (xpath="//*[@class=\"widget-container\"]")
  WebElement count;

  @FindBy (xpath="//*[@class=\"bottom\"]")
  WebElement bottom;
  
 // @FindBy (xpath="(//div[@class='top'])[2]")
 // WebElement top;
  @FindBy (xpath="//*[@class=\"widget green\"]")
  WebElement user;
  @FindBy (xpath="//*[@aria-label=\"Previous page\"]")
  WebElement previous;
  
  @FindBy (xpath="//*[@aria-label=\"First page\"]")
  WebElement firstpage;
  
  @FindBy (xpath="//*[@aria-label=\"Next page\"]")
  WebElement nextpage;
  
  @FindBy (xpath="//*[@aria-label=\"Last page\"]")
  WebElement lastpage;
  
//  @FindBy (xpath="class=["mat-row cdk-row ng-star-inserted")
//  WebElement five_staffdata;
 
 

  public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		 driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
  

 
 
  
  //@FindBy(xpath="//*[text()=\" LMS - Learning Management System \"]")
  //private WebElement Lmstitle;
  
  
  

public void landOnloginpage()
  {
	  
	  //DriverFactory.initializeBrowser
	  driver.get("https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login");
  }
  
  public void login()
  {
	  driver.findElement(By.id("username")).sendKeys("sdetnumpyninja@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("Feb@2025");
	  driver.findElement(By.xpath("//span[text()=\"Select the role\"]")).click();
	  driver.findElement(By.xpath("//*[text()=\" Admin \"]")).click();
	  driver.findElement(By.xpath("//*[text()=\"Login\"]")).click();
	//assert.equals(driver.getTitle(),"LMS");
	

	  
	  
  }

public void validateLmsTitle() {
	
	
	System.out.println("title   "+driver.getTitle());
	assertEquals(driver.getTitle(),"LMS");
	
	}

public void verifyTitlePosition() 
{
	int xCoordinate=Lmstitle.getLocation().getX();
	int yCoordinate=Lmstitle.getLocation().getY();
	
	System.out.println("xcordinate "+xCoordinate);
	System.out.println("ycordinate "+yCoordinate);
	int tolerance = 10;
	
	 Assert.assertEquals(true, xCoordinate >= tolerance && yCoordinate >= tolerance);
}

public void verifyNevigationbarTextSpelling() {
	// TODO Auto-generated method stub
	
}

public void veryfyTitleSpelling() {
	String str=" LMS - Learning Management System ";
	Assert.assertEquals(Lmstitle.getText().toString(), str);
	
}

public void check_AlignmentOfTextField() {
	
	//LoggerLoad.info("Alignment input field is center position");
	List<WebElement> texts=driver.findElements(By.xpath("//*[@class=\"mat-ripple mat-button-ripple\"]"));
	
	for(WebElement text_alighnment:texts)
	{
		String tex_Alignment= text_alighnment.getCssValue("text-align");
		Assert.assertEquals("center", tex_Alignment);
		System.out.println("alighnment  "+tex_Alignment);
	}
	
	
}

public void checkTextPosition(String textname) {
List<WebElement> texts=driver.findElements(By.xpath("//*[@class=\"mat-button-wrapper\"]"));
   


for (int i = 0; i < texts.size(); i++) {
WebElement text = texts.get(i);
    
// Get the value (text) of the element
String value = text.getText();
    
// Print the position (index) and value
System.out.println("Position: " + i + " | Value: " + value);
    
//if (value.isEmpty()) {
//    System.out.println("Element has no visible text.");
//} else {
//    System.out.println("Position: " + i + " | Value: " + value);
//}
//}
//	for(WebElement text:texts)
//	{
		
		
		
		if(textname.equalsIgnoreCase("Home"))
		{
			
			//listItems.get(2).getText())
			//System.out.println("alighnment  "+textname, texts.get(0).getText());
			System.out.println("name  "+ texts.get(i).getText());
			Assert.assertEquals(texts.get(i).getText(),textname);
			break;
		
	//System.out.println("alighnment  "+tex_Alignment);
	}
		else if(textname.equalsIgnoreCase("Program"))
		{
			System.out.println("name    "+ texts.get(1).getText());
			Assert.assertEquals(texts.get(i).getText(),textname);
		break;
		
		//System.out.println("alighnment  "+tex_Alignment);
	}
		else if(textname.equalsIgnoreCase("Batch"))
		{
			System.out.println("name  "+ texts.get(i).getText());
			Assert.assertEquals(texts.get(i).getText(),textname);
		break;
		
		//System.out.println("alighnment  "+tex_Alignment);
	}
		else if(textname.equalsIgnoreCase("Class"))
		{
			System.out.println("name     "+ texts.get(i).getText());
		Assert.assertEquals(textname, texts.get(i).getText());
		break;
		
		
	}
		
		else if(textname.equalsIgnoreCase("Logout"))
		{
			System.out.println("name     "+ texts.get(i).getText());
		Assert.assertEquals(textname, texts.get(i).getText());
		break;
			
	}
	
	}
}

public void pieChartisAvailable() {
	boolean isavailable=piechart.isDisplayed();
	Assert.assertEquals(true,isavailable);
	
}
public void barChartisAvailable() {
	boolean isavailable=barchart.isDisplayed();
	Assert.assertEquals(true,isavailable);
	
}


public void verifyEelcomeMessageAndRole() {
	
	
	String user_role =role.getText().toString();
	Assert.assertEquals(user_role,"ADMIN");
	
  String wel_msg=welcomeMessage.getText().toString();
	
	//boolean isWelcomemessageAvailable=welcomeMessage.isDisplayed();
	Assert.assertEquals(wel_msg," Welcome sdetnumpyninja@gmail.com");
	
}
  public void count(String value)
  {
	 // int i = 3;  // For example, you want to select the 3rd div
	 
	

	  
	// List<WebElement> count=driver.findElements(By.xpath("//*[@class=\"value\"]"));
	 
	 //String top=""//*[@class=\"widget green\"]"
	 
	/* for(int i=0;i<count.size();i++)
	 {*/
		 
		 
		 
		 
		  if(value.equalsIgnoreCase("User"))
		  {
			  String xpath = "(//div[@class='top'])[" + 2 + "]";
			  WebElement top = driver.findElement(By.xpath(xpath));
			  
			  String bottom_xpath = "(//div[@class='bottom'])[" + 2 + "]";
			   WebElement bottom = driver.findElement(By.xpath(bottom_xpath));
			 
		 String number=top.getText().toString();
		 String valuename=bottom.getText().toString();
		 
		 System.out.println("number  =" +number    +"bottom value  =" + valuename);
		 Assert.assertEquals(valuename, "User");
		// break;
		  }
	// }
		  
		  else  if(value.equalsIgnoreCase("Staff"))
		  {
			  String xpath = "(//div[@class='top'])[" + 3 + "]";
			  WebElement top = driver.findElement(By.xpath(xpath));
			  String bottom_xpath = "(//div[@class='bottom'])[" + 3 + "]";
			   WebElement bottom = driver.findElement(By.xpath(bottom_xpath));
			   String number=top.getText().toString();
				 String valuename=bottom.getText().toString();
				 
				 System.out.println("number  =" +number    +"bottom value  =" + valuename);
				 Assert.assertEquals(valuename, "Staff");
		 
	 }
	 
		  else if(value.equalsIgnoreCase("Batches"))
		  {
			  String xpath = "(//div[@class='top'])[" + 4 + "]";
			  WebElement top = driver.findElement(By.xpath(xpath));
			  
			  String number=top.getText().toString();
				 String valuename=bottom.getText().toString();
				 
				 System.out.println("number  =" +number    +"bottom value  =" + valuename);
				 Assert.assertEquals(valuename, "Batches");
	 }
		  else  if(value.equalsIgnoreCase("Programs"))
		  {
			  String bottom_xpath = "(//div[@class='bottom'])[" + 5 + "]";
			   WebElement bottom = driver.findElement(By.xpath(bottom_xpath));
			  String xpath = "(//div[@class='top'])[" + 5 + "]";
			  WebElement top = driver.findElement(By.xpath(xpath));
			 
			  String number=top.getText().toString();
				 String valuename=bottom.getText().toString();
				 
				 System.out.println("number  =" +number    +"bottom value  =" + valuename);
				 Assert.assertEquals(valuename, "Programs");
	 }
	
	 }


public void verifyPaginationIcons() 
{
	Assert.assertEquals(true, firstpage.isDisplayed());
	Assert.assertEquals(true, previous.isDisplayed());
	Assert.assertEquals(true, nextpage.isDisplayed());
	Assert.assertEquals(true, lastpage.isDisplayed());
	
}

public void verifyFiveStaffdata() {
	// TODO Auto-generated method stub
	List<WebElement> staffList = driver.findElements(By.xpath("//*[@class=\"mat-row cdk-row ng-star-inserted\"]"));
	
	int staffdata=staffList.size();
	Assert.assertEquals(staffList.size(), 5);
	if(staffdata==5)
	{
		if(nextpage.isEnabled())
		{
		nextpage.click();
		List<WebElement> staffListnextpage = driver.findElements(By.xpath("//*[@class=\"mat-row cdk-row ng-star-inserted\"]"));
		Assert.assertEquals(staffListnextpage.size(), 5);
		}
		
		if(previous.isEnabled())
		{
		nextpage.click();
		List<WebElement> staffListnextpage = driver.findElements(By.xpath("//*[@class=\"mat-row cdk-row ng-star-inserted\"]"));
		Assert.assertEquals(staffListnextpage.size(), 5);
		}
		
		if(firstpage.isEnabled())
		{
		nextpage.click();
		List<WebElement> staffListnextpage = driver.findElements(By.xpath("//*[@class=\"mat-row cdk-row ng-star-inserted\"]"));
		//int staffdata=staffList.size();
		Assert.assertEquals(staffListnextpage.size(), 5);
		}
	}
}
public void verifyPreviouspageDisable() {
	Assert.assertEquals(previous.isEnabled(), false);
	
}
public void verifyFirstpageDisable() {
	Assert.assertEquals(firstpage.isEnabled(), false);
	
}


  }



	


	

