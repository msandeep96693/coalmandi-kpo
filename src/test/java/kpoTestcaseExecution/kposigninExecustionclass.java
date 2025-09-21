package kpoTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.kpoBaseclass;
import kpopageobject.kposigninpage;

public class kposigninExecustionclass extends kpoBaseclass {
	
	@Test
	public void opssignin()
	{
		opssign = new kposigninpage(driver);
		opssign.kposigninpage(prop.getProperty("opsemail"), prop.getProperty("password"));
	}

}
