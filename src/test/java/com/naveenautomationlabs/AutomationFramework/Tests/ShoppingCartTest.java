package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.ShoppingCart;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class ShoppingCartTest extends TestBase{

	ShoppingCart shoppingCart;
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
	}
	
	@Test(enabled = false)
	public boolean validateTotal()
	{
	   String sum = shoppingCart.getTotal();	
	   Assert.assertEquals(sum, "$371.20", "sum is not correct");
	   return true;
	}
	
	@AfterMethod
	public void tearDown()
	{
		quit();
	}
}
