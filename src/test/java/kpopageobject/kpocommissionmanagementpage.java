package kpopageobject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class kpocommissionmanagementpage extends kpoBasicpage {

	public kpocommissionmanagementpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//img[@alt='Coal Mandi']/../following-sibling::nav//button")
	private List<WebElement> btnsidenavbar;
	

	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement kpoprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement kpologoutbutton;
	
	
	public void commissionmanagementlist(String email, String pwd, String sidebarcommissionname
			) throws InterruptedException
	{
		kposigninpage kposign = new kposigninpage(driver);
		kposign.kposigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarcommissionname);
		
		// pending
		
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
	        case "commission": javascriptclick(btnsidenavbar.get(4)); break;
	        case "reports": javascriptclick(btnsidenavbar.get(5)); break;

	        default: throw new NoSuchElementException("Button not found: " + btn);
	    }
	}
	
}
