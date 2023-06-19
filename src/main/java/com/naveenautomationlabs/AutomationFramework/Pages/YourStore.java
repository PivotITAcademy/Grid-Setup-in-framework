package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStore extends TestBase {

	public YourStore() {

		PageFactory.initElements(wd, this);

	}

	@FindBy(css = "ul.list-inline>li:nth-of-type(2)>a")
	private WebElement myAccount;

	@FindBy(xpath = "(//ul//a[text()='Register'])[1]")
	private WebElement registerBtn;

	private void clickMyAccountBtn() {
		myAccount.click();
	}

	public RegisterAccount clickRegisterBtn() {
		clickMyAccountBtn();
		registerBtn.click();
		return new RegisterAccount();
	}

}
