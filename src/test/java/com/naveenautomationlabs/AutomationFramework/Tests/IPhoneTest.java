package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class IPhoneTest extends TestBase{
YourStore yourStore;
SuccessTest successTest;
	
	@BeforeMethod
	public void setUp() {
		intialization();
		yourStore= new YourStore();
	}
	
	@Test
	public void validateProductSelected()
	{
		yourStore.selectProductFromRow("iPhone");
		
	}
}
