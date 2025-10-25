package kpoTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kposigninpage;

public class kposigninExecustionclass extends kpoBaseclass {
	
	@Test
	public void kposignin() throws InterruptedException
	{
		opssign = new kposigninpage(driver);
		opssign.kposigninpage(prop.getProperty("kpoemail"), prop.getProperty("password"));
	}

}
