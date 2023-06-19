package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Success extends TestBase{

	public Success() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath ="//h1[text()='Your order has been placed!']")
	private WebElement orderPlaceMessage;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement conitnueBtn;    //account has been created 
	

	
	public String showOrderPlaceMessage()
	{
		return orderPlaceMessage.getText();
	}
	
	public MyAccount clickContinueBtn()
	
	{
		conitnueBtn.click();
		return new MyAccount();
	}
}
