package kpopageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
	@FindBy(xpath = "//button[.='Dispatches']")
	private WebElement dispatchsection;
	
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
	
	
	
	// //span[.='Pending Release']
	// //tbody[@class='ant-table-tbody']/tr/td
	public void contractmanagementlistpage(String email, String pwd, String sidebarfeaturename, 
			String searchbusinessname, String statusoptionname) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		
//		waitforElement(searchtextfield);
//		searchtextfield.sendKeys(searchbusinessname);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		
		selectDropdownOption(statusdropdownoption, statusoptionname);
		
		// Fetch kpo team member
		for(int i = 0; i < contractlistdata.size(); i++)
		{
			Thread.sleep(2000);
			String listdetails = contractlistdata.get(i).getText();
			System.out.println("Details : -"+listdetails);
		}
				
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
				
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
		
	}

	public void contractmanagementInitiatecontractaction(String email, String pwd, String sidebarfeaturename,
			String statusoptionname, String statusname, String kpoexecutiveoptionname, String contractbuyersignoptionname,
			String contractsellersignoptionname ) throws InterruptedException, AWTException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
//		ClickAction(sidebarfeaturename);
		ClickActionexecutive(sidebarfeaturename);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		selectDropdownOption(statusdropdownoption, statusoptionname);

		// click on pending release
		Thread.sleep(2000);
		WebElement status = allStatusnames.get(0);
		javascriptclick(status);
		 
		scrollBottomofPage();
		
		// click on pending release 
		WebElement status2 = allStatusnames.get(1);
		javascriptclick(status2);
		
		scrollBottomofPage();
		
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
	
	public void contractmanagementrequesttoshortcloseaction(String email, String pwd, String sidebarfeaturename,
			String statusoptionname ) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
//		ClickAction(sidebarfeaturename);
		ClickActionexecutive(sidebarfeaturename);
	
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		selectDropdownOption(statusdropdownoption, statusoptionname);
		
		
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
	
	public void contractmanagementcontinueorderaction(String email, String pwd, String sidebarfeaturename,
			String statuspendingsignature) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		
		//clickViewButtonUsingContains(statuspendingsignature);
		
		scrollBottomofPage();
		
		waitforElement(continueorderbtn);
		javascriptclick(continueorderbtn);
		
		waitforElement(yesbutton);
		javascriptclick(yesbutton);
		
		Thread.sleep(1000);
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
				
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
		
		
	}
	
	
	
	
	public void contractmanagementkpoverifysignatureaction(String email, String pwd, String sidebarfeaturename,
			String statusoptionname) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		selectDropdownOption(statusdropdownoption, statusoptionname);
		
		// click on pending signature list
		Thread.sleep(2000);
		WebElement status = allStatusnames.get(0);
		javascriptclick(status);
		
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
	
	public void contractmanagementassignaction(String email, String pwd, String sidebarfeaturename,
			String statusoptionname, String kpoexecutivename) throws InterruptedException, AWTException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		selectDropdownOption(statusdropdownoption, statusoptionname);
		
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
}
