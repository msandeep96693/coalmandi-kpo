package kpopageobject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class kpovendorcoordinationpage extends kpoBasicpage {

	public kpovendorcoordinationpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//img[@alt='Coal Mandi']/../following-sibling::nav//button")
	private List<WebElement> btnsidenavbar;
	
	@FindBy(xpath = "//input[@placeholder='Search by business name, contact name']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0']/td")
    private List<WebElement> vendorlistdata;	
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement kpoprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement kpologoutbutton;
	
	public void kpovednorcoordinationlistpage(String email, String pwd, String sidebarfeaturename, 
			String searchbusinessname) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		
		waitforElement(searchtextfield);
		searchtextfield.sendKeys(searchbusinessname);
		
		for(int i = 0; i < vendorlistdata.size(); i++)
		{
			Thread.sleep(2000);
			String listdetails = vendorlistdata.get(0).getText();
			System.out.println("Details : - "+listdetails);
		}
				
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
