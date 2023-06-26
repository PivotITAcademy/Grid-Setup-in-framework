package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.List;
import java.util.Set;

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
	
	WebDriverWait wait = new WebDriverWait(wd,10);
	List<WebElement>  webElements;
	String parentHandle = wd.getWindowHandle(); 
	Set<String> windowhandles = wd.getWindowHandles();

	@FindBy(css = "ul.list-inline>li:nth-of-type(2)>a")
	private WebElement myAccount;

	@FindBy(xpath = "(//ul//a[text()='Register'])[1]")
	private WebElement registerBtn;
	
	@FindBy(css = "ul.dropdown-menu>li:nth-of-type(2)>a")
	private WebElement loginBtn;


	private void clickMyAccountBtn() {
		myAccount.click();
	}

	public AccountLogin clickLoginBtn()
	{
		clickMyAccountBtn();
		loginBtn.click();
		return new AccountLogin();
	}
	public RegisterAccount clickRegisterBtn() {
		clickMyAccountBtn();
		registerBtn.click();
		return new RegisterAccount();
	}
	
	
	public void selectProduct()
	{
		webElements=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.product-layout.col-lg-3.col-md-3.col-sm-6.col-xs-12")));
		
			for(WebElement webElement: webElements) 
			{	
				String text = "Canon EOS 5D";
				if(webElement.getText().contains(text))
				{
					System.out.println("**************Right Element selected:" + text);
				}
			}		
	}
	


}
