package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccount extends TestBase {

	public MyAccount() {
		PageFactory.initElements(wd, this);
	}

	WebDriverWait wait = new WebDriverWait(wd, 10);
	@FindBy(xpath = "(//ul//a[text()='Components'])[1]")
	private WebElement componentsBtn;

	@FindBy(xpath = "//a[text()='Monitors (2)']")
	private WebElement monitorsBtn;

	private List<WebElement> webElements;

	private void clickComponentsBtn() {
		componentsBtn.click();
	}

	public Monitors clickMonitorsBtn() {
		clickComponentsBtn();
		monitorsBtn.click();
		return new Monitors();
	}

	public boolean selectOptionFromSiteNavigation(String option) {
		webElements = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.list-group a.list-group-item")));

		// return webElements.stream().anyMatch(e->e.getText().contains(option));

		for (WebElement element : webElements) {
			String var = element.getText();
			if (element.getText().contains(option)) {

				return true;
			}
		}
		return false;

	}
}
