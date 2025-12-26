package kpoTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kposigninpage;

public class kposigninExecustionclass extends kpoBaseclass {
	
	@Test
	public void kposignin() throws InterruptedException
	{
		kposign = new kposigninpage(driver);
		kposign.kposigninpage(prop.getProperty("kpoemail"), prop.getProperty("password"));
	}

}
