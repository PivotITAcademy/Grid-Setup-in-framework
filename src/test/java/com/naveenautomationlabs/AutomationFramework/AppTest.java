package com.naveenautomationlabs.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestBase
{
   
	@BeforeMethod
	public void setUp()
	{
		intialization();
	}
	
	
	@Test
    public void shouldAnswerWithTrue()
    {
    	
       Assert.assertTrue(true);
        
    }
    
    @AfterMethod
    public void quit()
    {
    	quit();
    }
}
