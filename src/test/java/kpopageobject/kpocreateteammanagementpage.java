package kpopageobject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class kpocreateteammanagementpage extends kpoBasicpage {

	public kpocreateteammanagementpage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//img[@alt='Coal Mandi']/../following-sibling::nav//button")
	private List<WebElement> btnsidenavbar;
	
	@FindBy(xpath = "//span[.='Add Team Member']/..")
	private WebElement addteammemberbtn;
	
	@FindBy(xpath = "//input[@placeholder='Enter full name']")
	private WebElement enterfullnamefield;
	
	@FindBy(xpath = "//input[@placeholder='Enter email address']")
	private WebElement enteremailaddressfield;
	
	@FindBy(xpath = "//input[@placeholder='Enter phone number']")
	private WebElement enterphonenumberfield;
	
	@FindBy(xpath = "//span[.='Create Team Member']/..")
	private WebElement clickoncreateteammemberbtn;
	
	@FindBy(xpath = "(//button[@type='button'])[5]")
	private WebElement ellipsesbuttons;
	
	@FindBy(xpath = "(//span[.='Active'])[1]/../preceding-sibling::div")
	private List<WebElement> teammembernameandID;
	
	// Edit ops team member
	
	@FindBy(xpath = "//span[.='Edit']")
	private WebElement clickonediticon;
	
	@FindBy(xpath = "//span[.='Update Team Member']/.." )
	private WebElement updateteammember;
	
	@FindBy(xpath = "//div[.='OPS user updated successfully']")
	private WebElement updatemessage;
	
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	private WebElement confirmationsuccessmessage;
	
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr/td/span")
	private List<WebElement> teammemberlistofdata;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement kpoprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement kpologoutbutton;
	
	
	// Team management list page
	
	@FindBy(xpath = "//input[@placeholder='Search by name, email']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "(//span[.='Active'])[1]")
	private WebElement allstatusdropdown;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	private List<WebElement> statusoptions;
	
	
	
	
	public void kpoteammanagementlistpage(String email, String pwd, String sidebarteamname, String searchbyname
			) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarteamname);
		
		waitforElement(searchtextfield);
		searchtextfield.sendKeys(searchbyname);
		
		waitforElement(allstatusdropdown);
//		javascriptclick(allstatusdropdown);
		allstatusdropdown.click();

		javascriptclick(statusoptions.get(0));
		
		// Fetch kpo team member
		for(int i = 0; i < teammemberlistofdata.size(); i++)
		{
			Thread.sleep(200);
			String listdetails = teammemberlistofdata.get(i).getText();
			System.out.println("Details : -"+listdetails);
		}
		
		Thread.sleep(1500);
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
		
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
	}
	
	
	public void kpocreateteammanagement(String email, String pwd, String sidebarteamname) throws InterruptedException
	{  
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarteamname);
		Thread.sleep(3000);
		
		// click on add team member button
		waitforElement(addteammemberbtn);
		javascriptclick(addteammemberbtn);
		
		// click on add team member button
		waitforElement(addteammemberbtn);
		javascriptclick(addteammemberbtn);
				
		// enter a full name
		waitforElement(enterfullnamefield);
		enterfullnamefield.sendKeys(setRandomName());
				
		// enter a email ID
		waitforElement(enteremailaddressfield);
		enteremailaddressfield.sendKeys(setRandomEmail());
				
		// enter a phone number
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
		
		Thread.sleep(1500);
		// click on create team member button
		waitforElement(clickoncreateteammemberbtn);
		javascriptclick(clickoncreateteammemberbtn);
		
		//create confirmation message
		waitforElement(confirmationsuccessmessage);
		String confirmationmsg = confirmationsuccessmessage.getText();
		System.out.println("create confirmation message :- "+ confirmationmsg);
		
		// Fetch created kpo team member
		for(int i = 0; i<=teammemberlistofdata.size(); i++)
		{
			String listdetails = teammemberlistofdata.get(0).getText().trim();
			System.out.println("Details : -"+listdetails);
		}
		
		Thread.sleep(1500);
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
		
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
	}
	
	
	public void kpoupdateteammember(String email, String pwd, String sidebarteamname) throws InterruptedException
	{
		kposigninpage opssign = new kposigninpage(driver);
		opssign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarteamname);
		Thread.sleep(3000);
		
		// click on ellipses 
		waitforElement(ellipsesbuttons);
		javascriptclick(ellipsesbuttons);
		
		// click on edit icon
		waitforElement(clickonediticon);
		javascriptclick(clickonediticon);
		
		// enter a full name
		waitforElement(enterfullnamefield);
		enterfullnamefield.sendKeys(Keys.CONTROL + "A");
		enterfullnamefield.sendKeys(Keys.DELETE);
		Thread.sleep(1500);
		enterfullnamefield.sendKeys(setRandomName());
						
		// enter a phone number
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(Keys.CONTROL + "A");
		enterphonenumberfield.sendKeys(Keys.DELETE);
		Thread.sleep(1500);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
		
		// click on update button
		waitforElement(updateteammember);
		javascriptclick(updateteammember);
		
		//update confirmation message
		waitforElement(confirmationsuccessmessage);
		String confirmationmsg = confirmationsuccessmessage.getText();
		System.out.println("Update confirmation message :- "+ confirmationmsg);
		
		// Fetch updated kpo team member
		for(int i = 0; i<=teammemberlistofdata.size(); i++)
		{
			String listdetails = teammemberlistofdata.get(0).getText().trim();
			System.out.println("Details : -"+listdetails);
		}
		
		Thread.sleep(1500);
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
	
	
 }
