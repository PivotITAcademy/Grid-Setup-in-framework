package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class ShoppingCart extends TestBase{

	public ShoppingCart() {
		PageFactory.initElements(wd, this);
	}
	
	public String sum;
	
	@FindBy(xpath = "(//td[text()='$325.60'])[4]")
	private WebElement total;
	
	@FindBy(xpath = "//a[text()='Checkout']")
	private WebElement checkOutBtn;
	
	public String getTotal()
	{
		return total.getText();
	}
	
	public Checkout clickCheckOutBtn()
	{
		// sum =validateTotal();
	
		checkOutBtn.click();
		return new Checkout();
	}
}
