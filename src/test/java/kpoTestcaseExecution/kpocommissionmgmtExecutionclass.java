package kpoTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kpocommissionmanagementpage;
import kpopageobject.kpovendorcoordinationpage;

public class kpocommissionmgmtExecutionclass extends kpoBaseclass {
	
	@Test(priority = 0, enabled = true)
	public void kpocommissionlistpage() throws InterruptedException
	{
		commission = new kpocommissionmanagementpage(driver);
		commission.commissionmanagementlist(prop.getProperty("kpoemail"),prop.getProperty("password"),
				prop.getProperty("sidebarvendorname"));
	}
 }
