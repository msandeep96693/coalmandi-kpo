package kpopageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class kposigninpage extends kpoBasicpage {

	public kposigninpage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement emailFieldLocator;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordFieldLocator;
	
	@FindBy(xpath="//span[.='Request to reset']")
	private WebElement lnkRequestToReset;
	
	@FindBy(xpath="(//button[@type='submit'])[1]") 
	private WebElement btnLogin;
	
	public void kposigninpage(String email, String pwd)
	{
		// enter a emailID
		waitforElement(emailFieldLocator);
		emailFieldLocator.sendKeys(email);
		// enter a password
		waitforElement(passwordFieldLocator);
		System.out.println("password :- "+ passwordFieldLocator);
		System.out.println("password :- "+ pwd);
		passwordFieldLocator.sendKeys(pwd);
		// click on signin button
		waitforElement(btnLogin);
		javascriptclick(btnLogin);
	}
}
