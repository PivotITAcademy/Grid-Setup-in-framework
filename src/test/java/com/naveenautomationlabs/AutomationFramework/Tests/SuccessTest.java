package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AppleCinema30;
import com.naveenautomationlabs.AutomationFramework.Pages.Checkout;
import com.naveenautomationlabs.AutomationFramework.Pages.Monitors;
import com.naveenautomationlabs.AutomationFramework.Pages.MyAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.RegisterAccount;
import com.naveenautomationlabs.AutomationFramework.Pages.ShoppingCart;
import com.naveenautomationlabs.AutomationFramework.Pages.Success;
import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class SuccessTest extends TestBase {

	YourStore yourStore;
	Monitors monitors;
	AppleCinema30 appleCinema;
	ShoppingCart shoppingCart;
	Checkout checkOut;
	Success success;
	RegisterAccount registerAccount;
	MyAccount myAccount;

	@BeforeMethod
	public void setUp() {
		intialization();
		yourStore = new YourStore();

	}

	@Test
	public void validateOrderPlacedSuccessfull() {
		registerAccount = yourStore.clickRegisterBtn();
		success = registerAccount.clickContinueBtn();
		myAccount = success.clickContinueBtn();
		monitors = myAccount.clickMonitorsBtn();
		appleCinema = monitors.clickAppleCinemaBtn();

		appleCinema.clickAddToCartBtn();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		shoppingCart = appleCinema.clickShoppingCartBtn();

		checkOut = shoppingCart.clickCheckOutBtn();

		try {
			success = checkOut.clickConfirmOrderBtn();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String message = success.showOrderPlaceMessage();
		Assert.assertEquals(message, "Your order has been placed!", "messge is not correct");
		success.clickContinueBtn();

	}

	@AfterMethod
	public void tearDown() {
		// quit();
	}
}
