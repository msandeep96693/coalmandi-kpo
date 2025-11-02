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
	
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	private WebElement confirmationsuccessmessage;
	
	public void kposigninpage(String email, String pwd) throws InterruptedException
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
		
		waitforElement(confirmationsuccessmessage);
		String confirmationmsg = confirmationsuccessmessage.getText();
		System.out.println("Login confirmation message :- "+ confirmationmsg);
		
		Thread.sleep(2000);
	}
}
