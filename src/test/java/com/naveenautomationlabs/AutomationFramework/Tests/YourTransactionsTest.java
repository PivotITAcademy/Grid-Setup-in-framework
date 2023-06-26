package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
import com.naveenautomationlabs.AutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.Pages.YourTransactions;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourTransactionsTest extends TestBase {
	YourStore yourStore;
	YourTransactions yourTransactions;
	MyAccount myAccount;
	AccountLogin accountLogin;
	
	@BeforeMethod
	public void setUp() {
		
		intialization();
		yourStore= new YourStore();
		
	}
	
	@Test
	public void validateCorrectOption()
	{
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.clickLoginBtn();
		boolean isCorrectOptionSelected = myAccount.selectOptionFromSiteNavigation("Transactions");
		if(isCorrectOptionSelected)
		{
			System.out.println("Right Product Selected");
			wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/transaction");
		}
	}
	
	
}
