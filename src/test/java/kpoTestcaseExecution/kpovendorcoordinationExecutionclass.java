package kpoTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kpovendorcoordinationpage;

public class kpovendorcoordinationExecutionclass extends kpoBaseclass {
	
	//working
	@Test(priority = 0, enabled = true)
	public void kpovendorcoordinationlistpage() throws InterruptedException
	{
		vendor = new kpovendorcoordinationpage(driver);
		vendor.kpovednorcoordinationlistpage(prop.getProperty("kpoemail"),prop.getProperty("password"),prop.getProperty("sidebarvendorname"),
				prop.getProperty("vendorsearchbusinessname"));
	}

}
