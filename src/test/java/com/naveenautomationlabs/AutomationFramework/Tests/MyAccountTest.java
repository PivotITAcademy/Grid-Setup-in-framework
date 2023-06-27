package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class MyAccountTest extends TestBase{

	YourStore yourStore;
	MyAccount myAccount;
	AccountLogin accountLogin;
	
	@BeforeMethod
	public void setUp() {
		
		intialization();
		yourStore= new YourStore();	
	}
	
	@Test
	public void validateMyAccountOptionSelectedFromSiteNavigation()
	{
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.clickLoginBtn();
		boolean isCorrectOptionSelected = myAccount.selectOptionFromSiteNavigation("My Account");
		if(isCorrectOptionSelected)
		{
			wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/account");
			Assert.assertEquals("My Account", wd.getTitle(),"My Account page not loaded");
		}
	}
}
