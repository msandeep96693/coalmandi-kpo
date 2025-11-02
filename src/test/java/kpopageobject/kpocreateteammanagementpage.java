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
	
	@FindBy(xpath = "(//button[.='View Details']/..//button)[2]")
	private WebElement viewdetailsandellipsesbuttons;
	
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
	
	@FindBy(xpath = "//div[@class='flex items-center gap-3']")
	private List<WebElement> teammemberlistofdata;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement kpoprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement kpologoutbutton;
	
	
	// Team management list page
	
	@FindBy(xpath = "//input[@placeholder='Search by name, email']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//span[@title='All']")
	private WebElement allstatusdropdown;
	
	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option']")
	private List<WebElement> statusoptions;
	
	
	public void kpoteammanagementlistpage(String email, String pwd, String sidebarfeaturename, String searchbyname,
			String statusname) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		
		waitforElement(searchtextfield);
		searchtextfield.sendKeys(searchbyname);
		
//		waitforElement(allstatusdropdown);
//		javascriptclick(allstatusdropdown);
//		
//		selectDropdownOption(statusoptions, statusname);
		
		// Fetch kpo team member
		for(int i = 0; i < teammemberlistofdata.size(); i++)
		{
			Thread.sleep(2000);
			String listdetails = teammemberlistofdata.get(i).getText();
			System.out.println("Details : -"+listdetails);
		}
		
		waitforElement(kpoprofileicon);
		javascriptclick(kpoprofileicon);
		
		waitforElement(kpologoutbutton);
		javascriptclick(kpologoutbutton);
	}
	
	
	
	
	
	public void kpocreateteammanagement(String email, String pwd, String sidebarfeaturename, String fullname, String emailID, String phonenumber) throws InterruptedException
	{  
		kposigninpage opssign = new kposigninpage(driver);
		opssign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		Thread.sleep(3000);
		
		// click on add team member button
		waitforElement(addteammemberbtn);
		javascriptclick(addteammemberbtn);
		
		// click on add team member button
		waitforElement(addteammemberbtn);
		javascriptclick(addteammemberbtn);
				
		// enter a full name
		waitforElement(enterfullnamefield);
		enterfullnamefield.sendKeys(fullname);
				
		// enter a email ID
		waitforElement(enteremailaddressfield);
		enteremailaddressfield.sendKeys(emailID);
				
		// enter a phone number
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(phonenumber);
		
		Thread.sleep(3000);
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
		
	}
	
	
	public void updateteammember(String email, String pwd, String sidebarfeaturename, String fullname, String phonenumber) throws InterruptedException
	{
		kposigninpage opssign = new kposigninpage(driver);
		opssign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		Thread.sleep(3000);
		
		// click on ellipses 
		waitforElement(viewdetailsandellipsesbuttons);
		javascriptclick(viewdetailsandellipsesbuttons);
		
		// click on edit icon
		waitforElement(clickonediticon);
		javascriptclick(clickonediticon);
		
		// enter a full name
		waitforElement(enterfullnamefield);
		enterfullnamefield.sendKeys(Keys.CONTROL + "a");
		enterfullnamefield.sendKeys(Keys.DELETE);
		Thread.sleep(1500);
		enterfullnamefield.sendKeys(fullname);
						
		// enter a phone number
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(Keys.CONTROL + "a");
		enterphonenumberfield.sendKeys(Keys.DELETE);
		Thread.sleep(1500);
		enterphonenumberfield.sendKeys(phonenumber);
		
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
