package kpoTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kpocreateteammanagementpage;
import kpopageobject.kposigninpage;

public class kpoteammgmtExecutionclass extends kpoBaseclass {
	
	
		//working
	    @Test(priority = 0, enabled = true)
	    public void kpoteammanagementlistpage() throws InterruptedException
	    {
	    	kpoteam = new kpocreateteammanagementpage(driver);
	    	kpoteam.kpoteammanagementlistpage(prop.getProperty("kpoemail"), prop.getProperty("password"),
	    			prop.getProperty("sidebarteamname"), prop.getProperty("searchbyname"));
	    }
	
	    //working
		@Test(priority = 1, enabled = true)
		public void kpocreateteammanagement() throws InterruptedException
		{
			kpoteam = new kpocreateteammanagementpage(driver);
			kpoteam.kpocreateteammanagement(prop.getProperty("kpoemail"), prop.getProperty("password"), 
					prop.getProperty("sidebarteamname"));
		}
		
		//working
		@Test(priority = 2, enabled = true)
		public void kpoupdateteammanagement() throws InterruptedException
		{
			kpoteam = new kpocreateteammanagementpage(driver);
			kpoteam.kpoupdateteammember(prop.getProperty("kpoemail"), prop.getProperty("password"), 
					prop.getProperty("sidebarteamname"));
		}

}
