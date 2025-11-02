package kpopageobject;

import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option']")
	private List<WebElement> statusdropdownoption;
	
	@FindBy(xpath = "//div[@class='space-y-4']")
	private List<WebElement> contractlistdata;
	
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
	
	public void contractmanagementlistpage(String email, String pwd, String sidebarfeaturename, 
			String searchbusinessname, String statusoptionname) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		
		waitforElement(searchtextfield);
		searchtextfield.sendKeys(searchbusinessname);
		
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

	public void contractmanagementupdateaction()
	{
		
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
}
