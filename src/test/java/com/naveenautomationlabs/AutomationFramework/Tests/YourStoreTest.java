package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class YourStoreTest extends TestBase {

	YourStore yourStore;
	
	@BeforeMethod
	public void setUp() {

		intialization();
		yourStore = new YourStore();
	}

	@Test
	public void validateWishButtonValueIncrease() {
		yourStore.clickWishBtn();
		String name = "Wish List "+"(" + yourStore.count+ ")";
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(yourStore.wishListBtn.getText(),name);
	}
}
