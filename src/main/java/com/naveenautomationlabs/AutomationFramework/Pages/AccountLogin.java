package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AccountLogin extends TestBase{

	public AccountLogin() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "#input-email")
	private WebElement inputEmailField;

	@FindBy(css = "#input-password")
	private WebElement inputPasswordField;

	@FindBy(css = "input[value='Login']")
	private WebElement loginBtn;

	
	public void enterEmail() {
		inputEmailField.sendKeys("tony@gmail.com");
	}

	public void enterPassword() {
		inputPasswordField.sendKeys("Password2");
	}

	public MyAccount clickLoginBtn() {
		enterEmail();
		enterPassword();
		loginBtn.click();
		return new MyAccount();
	}
	
	
	
}
