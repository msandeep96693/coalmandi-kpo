package kpoTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kpocontractmanagementpage;

public class kpocontractmanagementExecutionclass extends kpoBaseclass {
	
	@Test(priority = 0, enabled = false)
	public void kpocontractmanagementlistpage() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementlistpage(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"), prop.getProperty("statusoptionname"));
	}
	
	//working
	@Test(priority = 1, enabled = false )
	public void contractmanagementInitiatecontractaction() throws InterruptedException, AWTException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementInitiatecontractaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"),prop.getProperty("statusoptionname"),
				prop.getProperty("kpoexecutiveoptionname"), prop.getProperty("contractbuyersignoptionname"), 
				prop.getProperty("contractsellersignoptionname"));
	}
	
	// working
	@Test(priority = 2, enabled = false)
	public void contractmanagementrequestshortcloseaction() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementrequesttoshortcloseaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"),prop.getProperty("statuspendingsignature"));
	}

	// working
	@Test(priority = 3, enabled = false)
	public void contractmanagementcontinueorderaction() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementcontinueorderaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"), prop.getProperty("statuspendingsignature"));
	}
	
	
	// working
	@Test(priority = 4, enabled = false)
	public void contractmanagementkpoverifysignatureaction() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementkpoverifysignatureaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"), prop.getProperty("statuspendingsignature"));
	}
	
	// working
	@Test(priority = 5, enabled = false)
	public void kpocontractmanagementassignpage() throws InterruptedException, AWTException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementassignaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"), prop.getProperty("statusoptionname"),  prop.getProperty("kpoexecutivename"));
	}
	
	
		@Test(priority = 6, enabled = true)
		public void kpoadddispatchfunctionality() throws InterruptedException, AWTException
		{
			contract = new kpocontractmanagementpage(driver);
			contract.kpoadddispatch(prop.getProperty("kpoemail"), prop.getProperty("password"),
					prop.getProperty("sidebarcontractname"));
		}
	
	

}
