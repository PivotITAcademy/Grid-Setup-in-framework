package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStore extends TestBase {

	public YourStore() {

		PageFactory.initElements(wd, this);
	}

	public int count = 0;

	WebDriverWait wait = new WebDriverWait(wd, 10);
	List<WebElement> webElements;

	@FindBy(css = "ul.list-inline>li:nth-of-type(2)>a")
	private WebElement myAccount;

	@FindBy(xpath = "(//ul//a[text()='Register'])[1]")
	private WebElement registerBtn;

	@FindBy(css = "ul.dropdown-menu>li:nth-of-type(2)>a")
	private WebElement loginBtn;

	@FindBy(xpath="//a//span[contains(text(),'Wish List')]")
	public WebElement wishListBtn;
	
	private void clickMyAccountBtn() {
		myAccount.click();
	}

	public AccountLogin clickLoginBtn() {
		clickMyAccountBtn();
		loginBtn.click();
		return new AccountLogin();
	}

	public RegisterAccount clickRegisterBtn() {
		clickMyAccountBtn();
		registerBtn.click();
		return new RegisterAccount();
	}

	public boolean selectProductFromRow(String text) {
		webElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.cssSelector("div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12 div.image+div a")));

		for (WebElement webElement : webElements) {
			if (webElement.getText().contains(text)) 
			{
				webElement.click();
			break;	
			}
		}
		return true;
	}

	public boolean clickWishBtn() {
//button>i.fa.fa-heart
		webElements = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@data-original-title='Add to Wish List']")));
		for (WebElement webElement : webElements) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			webElement.click();
			
			count++;
		}

		return true;
	}
}
