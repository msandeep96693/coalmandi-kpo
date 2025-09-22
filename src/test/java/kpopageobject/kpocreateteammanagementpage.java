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
		
		
		
	}
	
	
	public void updateteammember(String email, String pwd, String sidebarfeaturename, String fullname, String emailID, String phonenumber) throws InterruptedException
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
						
		// enter a email ID
		waitforElement(enteremailaddressfield);
		enteremailaddressfield.sendKeys(Keys.CONTROL + "a");
		enteremailaddressfield.sendKeys(Keys.DELETE);
		Thread.sleep(1500);
		enteremailaddressfield.sendKeys(emailID);
						
		// enter a phone number
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(Keys.CONTROL + "a");
		enterphonenumberfield.sendKeys(Keys.DELETE);
		Thread.sleep(1500);
		enterphonenumberfield.sendKeys(phonenumber);
		
		// click on update button
		waitforElement(updateteammember);
		javascriptclick(updateteammember);
		
		
		
	}
	
	
	public void ClickAction(String btn) {
	    switch(btn.toLowerCase()) {
	       	case "dashboard": javascriptclick(btnsidenavbar.get(0)); break;
	        case "team": javascriptclick(btnsidenavbar.get(1)); break;
	        case "contract": javascriptclick(btnsidenavbar.get(2)); break;
	        case "vendor": javascriptclick(btnsidenavbar.get(3)); break;
	        case "commission": javascriptclick(btnsidenavbar.get(4)); break;
	        case "reports": javascriptclick(btnsidenavbar.get(5)); break;

	        default: throw new NoSuchElementException("Button not found: " + btn);
	    }
	}
	
	
 }
