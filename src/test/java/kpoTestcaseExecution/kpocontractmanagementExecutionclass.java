package kpoTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kpocontractmanagementpage;

public class kpocontractmanagementExecutionclass extends kpoBaseclass {
	
	//@Test
	public void kpocontractmanagementlistpage() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementlistpage(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"), prop.getProperty("searchbusinessname"), 
				prop.getProperty("Statusoptionname"));
	}
	
	//@Test
	public void contractmanagementInitiatecontractaction() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementupdateaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"),prop.getProperty("statusname"),
				prop.getProperty("kpoexecutiveoptionname"), prop.getProperty("contractbuyersignoptionname"), 
				prop.getProperty("contractsellersignoptionname"));
	}
	
	
	//@Test
	public void contractmanagementrequestshortcloseaction() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementrequesttoshortcloseaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"),prop.getProperty("statuspendingsignature"));
	}

	//@Test
	public void contractmanagementcontinueorderaction() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementcontinueorderaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"), prop.getProperty("statuspendingsignature"));
	}
	
	
	
	@Test
	public void contractmanagementkpoverifysignatureaction() throws InterruptedException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementkpoverifysignatureaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"), prop.getProperty("statuspendingsignature"));
	}
	
	
	//@Test
	public void kpocontractmanagementassignpage() throws InterruptedException, AWTException
	{
		contract = new kpocontractmanagementpage(driver);
		contract.contractmanagementassignaction(prop.getProperty("kpoemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcontractname"), prop.getProperty("kpoexecutivename"));
	}
	
	

}
