package kpoTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kpocreateteammanagementpage;
import kpopageobject.kposigninpage;

public class kpoteammgmtExecutionclass extends kpoBaseclass {
	
		@Test(priority = 0, enabled = false)
		public void kpocreateteammanagement() throws InterruptedException
		{
			kpoteam = new kpocreateteammanagementpage(driver);
			kpoteam.kpocreateteammanagement(prop.getProperty("kpoemail"), prop.getProperty("password"), 
					prop.getProperty("sidebarteamname"), prop.getProperty("fullname"), 
					prop.getProperty("emailID"), prop.getProperty("phonenumber"));
					
		}
		
		
		@Test(priority = 1, enabled = true)
		public void kpoupdateteammanagement() throws InterruptedException
		{
			kpoteam = new kpocreateteammanagementpage(driver);
			kpoteam.updateteammember(prop.getProperty("kpoemail"), prop.getProperty("password"), 
					prop.getProperty("sidebarteamname"), prop.getProperty("updatefullname"), 
					prop.getProperty("updateemailID"), prop.getProperty("updatephonenumber"));
		}

}
