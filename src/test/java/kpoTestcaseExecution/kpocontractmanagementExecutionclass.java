package kpoTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kpocontractmanagementpage;

public class kpocontractmanagementExecutionclass extends kpoBaseclass {
	
	@Test
	public void kpocontractmanagementlistpage() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementlistpage(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"), prop.getProperty("searchbusinessname"), 
				prop.getProperty("Statusoptionname"));
				
	}
	

}
