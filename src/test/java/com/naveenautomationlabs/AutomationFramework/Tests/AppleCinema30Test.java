package com.naveenautomationlabs.AutomationFramework.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.Pages.YourStore;
import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AppleCinema30Test  extends TestBase{

	
	YourStore yourStore;
	SuccessTest successTest;
		
		@BeforeMethod
		public void setUp() {
			intialization();
			yourStore= new YourStore();
			successTest= new SuccessTest();
		}
		
		@Test
		public void validateProductSelected()
		{
			yourStore.selectProductFromRow("Apple Cinema 30");
			
			
		}
	}


