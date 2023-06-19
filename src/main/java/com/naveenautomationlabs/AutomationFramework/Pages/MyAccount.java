package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccount extends TestBase {

	
	public MyAccount() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath ="(//ul//a[text()='Components'])[1]")
	private WebElement componentsBtn;
	
	@FindBy(xpath = "//a[text()='Monitors (2)']")
	private WebElement monitorsBtn;
	
	
	private void clickComponentsBtn()
	{
		componentsBtn.click();
	}
	
	public Monitors clickMonitorsBtn()
	{
		clickComponentsBtn();
		monitorsBtn.click();
		return new Monitors();
	}
	
}
