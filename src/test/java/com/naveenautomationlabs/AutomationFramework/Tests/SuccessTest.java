package com.naveenautomationlabs.AutomationFramework.Tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.AccountLogin;
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

	private YourStore yourStore;
	private Monitors monitors;
	private AppleCinema30 appleCinema;
	private ShoppingCart shoppingCart;
	private Checkout checkOut;
	private Success success;
	private RegisterAccount registerAccount;
	private MyAccount myAccount;
	private AccountLogin accountLogin;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {

		intialization();
		yourStore = new YourStore();
		wait = new WebDriverWait(wd, 10);

	}

	@Test(enabled = false)
	public void validateOrderPlacedSuccessfull() {
		registerAccount = yourStore.clickRegisterBtn();
		success = registerAccount.clickContinueBtn();
		myAccount = success.clickContinueBtn();
		monitors = myAccount.clickMonitorsBtn();
		appleCinema = monitors.clickAppleCinemaBtn();

		appleCinema.clickAddToCartBtn();

		shoppingCart = appleCinema.clickShoppingCartBtn();
		checkOut = shoppingCart.clickCheckOutBtn();
		success = checkOut.clickConfirmOrderBtn();
		String message = success.showOrderPlaceMessage();
		Assert.assertEquals(message, "Your order has been placed!", "Message is not correct");

	}

	@Test
	@Ignore
	public void validateOrderPlacedAfterLogin() {
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.clickLoginBtn();
		monitors = myAccount.clickMonitorsBtn();
		appleCinema = monitors.clickAppleCinemaBtn();

		appleCinema.clickAddToCartBtn();

		shoppingCart = appleCinema.clickShoppingCartBtn();
		checkOut = shoppingCart.clickCheckOutBtn();
		success = checkOut.clickConfirmOrderBtnWithLogin();
		String message = success.showOrderPlaceMessage();
		Assert.assertEquals(message, "Your order has been placed!", "Message is not correct");

	}

	@Test
	public void validateProductSelected() {
		boolean flag = yourStore.selectProductFromRow("iPhone");
		Assert.assertTrue(flag);
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.clickLoginBtn();

	}

	@AfterMethod
	public void tearDown() {
		// quit();
	}
}
