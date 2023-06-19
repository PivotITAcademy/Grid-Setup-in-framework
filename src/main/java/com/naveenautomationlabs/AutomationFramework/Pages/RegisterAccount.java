package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class RegisterAccount extends TestBase{

	public RegisterAccount() {
		PageFactory.initElements(wd, this);
	}

	Random random = new Random();
	int randomInt = random.nextInt(1000);
	String randomEmail = "a1" + randomInt + "@gmail.com";
	
	@FindBy(css="#input-firstname")
	private WebElement firstName;
	
	@FindBy(css="#input-lastname")
	private WebElement lastName;
	
	@FindBy(css="#input-email")
	private WebElement emailInputField;
	
	@FindBy(css="#input-telephone")
	private WebElement telephoneInputField;
	
	@FindBy(css="#input-password")
	private WebElement passwordInputField;
	
	@FindBy(css="#input-confirm")
	private WebElement confirmPasswordInputField;
	
	@FindBy(xpath="(//input[@name='newsletter'])[2]")
	private WebElement noNewsLetterRadioButton;
	
	@FindBy(css="div>input[name='agree']")
	private WebElement privacyolicyCheckBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	private void enterFirsttName()
	{
		firstName.sendKeys("kamal");
	}
	private void enterLastName()
	{
		lastName.sendKeys("kaur");
	}
	private void enterEmail()
	{
		emailInputField.sendKeys(randomEmail);
	}
	private void enterTelephone()
	{
		telephoneInputField.sendKeys("1111111111");
	}
	
	private void enterPassword()
	{
		passwordInputField.sendKeys("Password1");
	}
	
	private void enterConfirmPassword()
	{
	confirmPasswordInputField.sendKeys("Password1");
	}
	private void clickNewsLetterBtn()
	{
		noNewsLetterRadioButton.click();
	}
	private void agreePrivacyPolicy()
	{
		privacyolicyCheckBox.click();
	}
	
	private void enterRegistrationDetails()
	{
		enterFirsttName();
		enterLastName();
		enterEmail();
		enterTelephone();
		enterPassword();
		enterConfirmPassword();
		clickNewsLetterBtn();
		agreePrivacyPolicy();
	}
	
	public Success clickContinueBtn()
	{
		enterRegistrationDetails();
		continueBtn.submit();
		return new Success();
	}
	
	
}
