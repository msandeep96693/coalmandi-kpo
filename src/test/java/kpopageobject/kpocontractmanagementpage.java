package kpopageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class kpocontractmanagementpage extends kpoBasicpage  {

	public kpocontractmanagementpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//img[@alt='Coal Mandi']/../following-sibling::nav//button")
	private List<WebElement> btnsidenavbar;
	
	@FindBy(xpath = "//input[@placeholder='Search by business name']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//span[@title='All Status']")
	private WebElement allstatusdropdown;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	private List<WebElement> statusdropdownoption; 
	// //div[@class='ant-select-item ant-select-item-option']/div
	// //div[@class='ant-select-item-option-content']
	@FindBy(xpath = "//div[@class='space-y-4']")
	private List<WebElement> contractlistdata;
	
	@FindBy(xpath = "(//div[@class='w-full']/div)[2]/div/div/div")
	private List<WebElement> contractlistdata1;
	
	@FindBy(xpath = "//button[.='View Details']")
	private List<WebElement> viewdetailsbtn;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement kpoprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement kpologoutbutton;
	
	
	// contract details xpath
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement addnewdispatchbutton;
	
	@FindBy(xpath = "//span[.='View Dispatch History']")
	private WebElement viewdispatchhistory;
	
	@FindBy(xpath = "//button[.='Initiate Contract']")
	private WebElement initiatecontractbtn;
	
	@FindBy(xpath = "//button[.='Assign']")
	private WebElement assignbutton;
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	private WebElement clickkpoexecutivedropdown;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement kposearchtextfield;
	
	@FindBy(xpath = "(//button[.='Assign'])[2]" )
	private WebElement assignbtn2;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[1]")
	private WebElement clickbuyerdropdown;
	
	@FindBy(xpath = "(//input[@type='search'])[1]")
	private WebElement buyersearchfield;
	
	@FindBy(xpath = "(//input[@type='search'])[2]")
	private WebElement sellersearchfield;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	private List<WebElement> buyerdropdownoptions;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[2]")
	private WebElement clicksellerdropdown;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	private List<WebElement> sellerdropdownoptions;
	
	@FindBy(xpath = "//button[.='Send Contract']")
	private WebElement sendcontractbtn;
	
	@FindBy(xpath = "//button[.='Request to Short Close']")
	private WebElement requesttoshortclosebtn;
	
	@FindBy(xpath = "//button[.='Continue Order']")
	private WebElement continueorderbtn;
	
	@FindBy(xpath = "//button[.='Yes']")
	private WebElement yesbutton;
	
	@FindBy(xpath = "//button[.='Verify Signatures']")
	private WebElement verifysignaturebtn;
	
	@FindBy(xpath = "//button[.='Accept']")
	private WebElement acceptbtn;
	
	// add dispatch form
	
	@FindBy(xpath = "//input[@placeholder='Enter quantity']")
	private WebElement dispatchQTY;
	
	@FindBy(xpath = "//input[@placeholder='Enter truck/train number']")
	private WebElement truckntrainnumberfield;
	
	@FindBy(xpath = "//input[@placeholder='Select the dispatch date']")
	private WebElement clickdispatchdatefield;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement uploaddispatchfile;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter any additional remarks...']")
	private WebElement otherremarkstextarea;
	
	@FindBy(xpath = "//button[.='Add Dispatch']")
	private WebElement adddispatchbutton;
	
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td/div/span")  
	private List<WebElement> allStatusnames;
	
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td") 
	private List<WebElement> pendingreleasestatus1;
	
	@FindBy(xpath = "//span[.='All Status']")
	private WebElement clickonallstatusdropdown;
	
	// dispatch 
	@FindBy(xpath = "//button[.='Dispatches']")
	private WebElement dispatchsection;
	
	@FindBy(xpath = "//span[.='Add New Dispatch']")
	private WebElement addnewdispatchbtn;
	
	@FindBy(xpath = "//input[@placeholder='Enter quantity']")
	private WebElement enterqtyfield;
	
	@FindBy(xpath = "//span[.='Select the dispatch date']")
	private WebElement clickonselectthedispatchdatefield;
	
	@FindBy(xpath = "//input[@placeholder='Enter truck/train number']")
	private WebElement entertrucktrainnumberfield;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement uploadfile;
	
	@FindBy(xpath = "//button[.='Add Dispatch']")
	private WebElement adddispatchbtn;
	
	public void contractmanagementlistpage(String kpoemail, String pwd, String sidebarcontractname, 
			 String statusoptionname) throws InterruptedException
	{
		// String searchbusinessname,
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(kpoemail, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarcontractname);
		
//		waitforElement(searchtextfield);
//		searchtextfield.sendKeys(searchbusinessname);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		// index  0 - all status
		// index  1 - Pending Signature
		// index  2 - Pending Release
		// index  3 - In Progress
		// index  4 - Cancelled
		// index  5 - Completed
		
		statusdropdownoption.get(2).click();
		
		Thread.sleep(1000);
//		selectDropdownOption(statusdropdownoption, statusoptionname);
		
		Thread.sleep(3000);		
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
				
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
		
	}

	public void contractmanagementInitiatecontractaction(String kpoemail, String pwd, String sidebarcontractname,
			String statusoptionname, String kpoexecutiveoptionname, String contractbuyersignoptionname,
			String contractsellersignoptionname ) throws InterruptedException, AWTException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(kpoemail, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarcontractname);
//		ClickActionexecutive(sidebarcontractname);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		// index  0 - all status
		// index  1 - Pending Signature
		// index  2 - Pending Release
		// index  3 - In Progress
		// index  4 - Cancelled
		// index  5 - Completed
		
		statusdropdownoption.get(2).click();
		
//		selectDropdownOption(statusdropdownoption, statusoptionname);

		// click on pending release in a list 
		Thread.sleep(2000);
		WebElement status = allStatusnames.get(0);
		javascriptclick(status);
		 
		scrollBottomoPage();
		
		// click on pending release in a list
		WebElement status2 = allStatusnames.get(1);
		javascriptclick(status2);
		
		scrollBottomoPage();
		
		Thread.sleep(2000);
		
		waitforElement(initiatecontractbtn);
		javascriptclick(initiatecontractbtn);
		
		waitforElement(clickbuyerdropdown);
		javascriptclick(clickbuyerdropdown);
		
		waitforElement(buyersearchfield);
		buyersearchfield.sendKeys("sandeep");
		
		selectDropdownOption(buyerdropdownoptions, contractbuyersignoptionname);
		
		waitforElement(clicksellerdropdown);
		javascriptclick(clicksellerdropdown);
		
		waitforElement(sellersearchfield);
		sellersearchfield.sendKeys("sandeep");
		
		selectDropdownOption(sellerdropdownoptions, contractsellersignoptionname);
		Thread.sleep(500);
		
		waitforElement(sendcontractbtn);
		javascriptclick(sendcontractbtn);
		Thread.sleep(2000);
		
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
				
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
			
	}
	
	public void contractmanagementrequesttoshortcloseaction(String kpoemail, String pwd, String sidebarcontractname,
			String statusoptionname ) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(kpoemail, pwd);
		
		// select the left nav bar features by name
//		ClickAction(sidebarfeaturename);
		ClickActionexecutive(sidebarcontractname);
	
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		// index  0 - all status
		// index  1 - Pending Signature
		// index  2 - Pending Release
		// index  3 - In Progress
		// index  4 - Cancelled
		// index  5 - Completed
				
		statusdropdownoption.get(1).click();
		
//		selectDropdownOption(statusdropdownoption, statusoptionname);
		
		// click on pending signature list
		Thread.sleep(2000);
		WebElement status = allStatusnames.get(0);
		javascriptclick(status);
		
		WebElement status2 = allStatusnames.get(1);
		 JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", status2);
		javascriptclick(status2);
		
		js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", requesttoshortclosebtn);
		waitforElement(requesttoshortclosebtn);
		javascriptclick(requesttoshortclosebtn);
		
		Thread.sleep(3000);
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
				
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
	}
	
	public void contractmanagementcontinueorderaction(String kpoemail, String pwd, String sidebarcontractname,
			String statuspendingsignature) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(kpoemail, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarcontractname);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		// index  0 - all status
		// index  1 - Pending Signature
		// index  2 - Pending Release
		// index  3 - In Progress
		// index  4 - Cancelled
		// index  5 - Completed
				
		statusdropdownoption.get(1).click();
		
//		selectDropdownOption(statusdropdownoption, statuspendingsignature);
		
		// click on pending signature list
		Thread.sleep(2000);
		WebElement status = allStatusnames.get(0);
		javascriptclick(status);
		
		// update index number based on a status in a list
		WebElement status2 = allStatusnames.get(0);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", status2);
		javascriptclick(status2);
		
		scrollBottomoPage();
		
		waitforElement(continueorderbtn);
		javascriptclick(continueorderbtn);
		
		waitforElement(yesbutton);
		javascriptclick(yesbutton);
		
		Thread.sleep(2000);
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
				
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
		
		
	}
	
	public void contractmanagementkpoverifysignatureaction(String kpoemail, String pwd, String sidebarcontractname,
			String statusoptionname) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(kpoemail, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarcontractname);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		// index  0 - all status
		// index  1 - Pending Signature
		// index  2 - Pending Release
		// index  3 - In Progress
		// index  4 - Cancelled
		// index  5 - Completed
				
		statusdropdownoption.get(1).click();
		
//		selectDropdownOption(statusdropdownoption, statusoptionname);
		
		// click on pending signature list
		Thread.sleep(2000);
		WebElement status = allStatusnames.get(0);
		javascriptclick(status);
		
		// update index number based on a status in a list
		WebElement status2 = allStatusnames.get(1);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", status2);
		javascriptclick(status2);
		
		js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", verifysignaturebtn);
		waitforElement(verifysignaturebtn);
		javascriptclick(verifysignaturebtn);

		waitforElement(acceptbtn);
		javascriptclick(acceptbtn);
		
		Thread.sleep(3000);
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
				
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
		
		}
	
	public void contractmanagementassignaction(String kpoemail, String pwd, String sidebarcontractname,
			String statuspendingrelease, String kpoexecutivename) throws InterruptedException, AWTException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(kpoemail, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarcontractname);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		// index  0 - all status
		// index  1 - Pending Signature
		// index  2 - Pending Release
		// index  3 - In Progress
		// index  4 - Cancelled
		// index  5 - Completed
						
		statusdropdownoption.get(2).click();
		
//		selectDropdownOption(statusdropdownoption, statuspendingrelease);
		
		Thread.sleep(2000);
		WebElement status = allStatusnames.get(1);
		javascriptclick(status);
		
		
		waitforElement(assignbutton);
		javascriptclick(assignbutton);
		
		waitforElement(clickkpoexecutivedropdown);
		javascriptclick(clickkpoexecutivedropdown);
		
		waitforElement(kposearchtextfield);
		kposearchtextfield.sendKeys(kpoexecutivename);
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
		
		waitforElement(assignbtn2);
		javascriptclick(assignbtn2);
		Thread.sleep(2000);
		
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
				
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
	}
	
	public void kpoadddispatch(String kpoemail, String pwd, 
			String sidebarcontractname ) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(kpoemail, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarcontractname);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		// index  0 - all status
		// index  1 - Pending Signature
		// index  2 - Pending Release
		// index  3 - In Progress
		// index  4 - Cancelled
		// index  5 - Completed
						
		statusdropdownoption.get(2).click();
		
//		selectDropdownOption(statusdropdownoption, statuspendingrelease);
		
		Thread.sleep(2000);
		WebElement status = allStatusnames.get(1);
		javascriptclick(status);
		
		waitforElement(dispatchsection);
		dispatchsection.click();
		
		waitforElement(addnewdispatchbtn);
		addnewdispatchbtn.click();
		
		Thread.sleep(25000);  // OTP wait
		
		waitforElement(enterqtyfield);
		enterqtyfield.clear();
		Thread.sleep(1500);
		enterqtyfield.sendKeys("22");
		
		waitforElement(clickonselectthedispatchdatefield);
		clickonselectthedispatchdatefield.click();
		
		selectDate("21-12-2025");
		
		waitforElement(entertrucktrainnumberfield);
		entertrucktrainnumberfield.sendKeys("kafas34");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='block';", uploadfile);
		uploadfile.sendKeys("/home/active34/Downloads/photos /QA club photos/Club 7.png");
		
		waitforElement(adddispatchbtn);
		adddispatchbtn.click();
		
		Thread.sleep(3000);
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
				
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
		
	}
	
	

	
	public void ClickAction(String btn) {
	    switch(btn.toLowerCase()) {
	       	case "dashboard": javascriptclick(btnsidenavbar.get(0)); break;
	        case "team": javascriptclick(btnsidenavbar.get(1)); break;
	        case "contract": javascriptclick(btnsidenavbar.get(2)); break;
	        case "vendor": javascriptclick(btnsidenavbar.get(3)); break;
	        case "reports": javascriptclick(btnsidenavbar.get(4)); break;

	        default: throw new NoSuchElementException("Button not found: " + btn);
	    }
	}
	
	public void ClickActionexecutive(String btn) {
	    switch(btn.toLowerCase()) {
	       	case "dashboard": javascriptclick(btnsidenavbar.get(0)); break;
	        case "contract": javascriptclick(btnsidenavbar.get(1)); break;
	        case "vendor": javascriptclick(btnsidenavbar.get(2)); break;
	        case "reports": javascriptclick(btnsidenavbar.get(3)); break;

	        default: throw new NoSuchElementException("Button not found: " + btn);
	    }
	}
	
	public void selectDate(String date) {
	    try {
	        // Convert dd-MM-yyyy to date object
	        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        LocalDate selectedDate = LocalDate.parse(date, inputFormat);

	        // Convert to aria-label format e.g. "4 November 2025"
	        DateTimeFormatter ariaFormat = DateTimeFormatter.ofPattern("d MMMM yyyy");
	        String ariaLabelDate = selectedDate.format(ariaFormat);

	        System.out.println("Selecting date: " + ariaLabelDate);

	        // Click the calendar to open (update locator if needed)
	        driver.findElement(By.xpath("(//div[@class='relative w-full'])[1]")).click();

	        // ✅ Dynamic XPath based on aria-label
	        WebElement dateElement = driver.findElement(By.xpath("//abbr[@aria-label='" + ariaLabelDate + "']/.."));

	        // Scroll into view (safe clicking)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", dateElement);
	        dateElement.click();

	        System.out.println("✅ Date selected: " + date);

	    } catch (Exception e) {
	        System.out.println("❌ Failed to select date: " + date);
	        e.printStackTrace();
	    }
	}
}
