package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Monitors extends TestBase {

	public Monitors() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content div.row:nth-of-type(3)>div.product-layout:first-of-type>div>div:nth-of-type(2) a")
	private WebElement appleCinemaBtn;

	public AppleCinema30 clickAppleCinemaBtn() {
		appleCinemaBtn.click();
		return new AppleCinema30();
	}
}
