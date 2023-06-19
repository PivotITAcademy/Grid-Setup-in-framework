package com.naveenautomationlabs.AutomationFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class Checkout extends TestBase {

	public Checkout() {
		PageFactory.initElements(wd, this);
	}

	Select select;

	/*
	 * @FindBy(css="input[value='register']") private WebElement registerRadioBtn;
	 * 
	 * @FindBy(css="input[value='Continue']") private WebElement
	 * continueRegisterBtn;
	 * 
	 * @FindBy(css = "#input-email") private WebElement inputEmailField;
	 * 
	 * @FindBy(css = "#input-password") private WebElement inputPasswordField;
	 * 
	 * @FindBy(css = "input[value='Login']") private WebElement loginBtn;
	 * 
	 * 
	 * @FindBy(xpath = "(//input[@name='payment_address'])[1]") private WebElement
	 * radionBtnExistingAddressBillingDetails;
	 */

	@FindBy(xpath = "((//input[@name='shipping_address'])[1]")
	private WebElement radionBtnExistingAddressDeliveryDetails;

	@FindBy(xpath = "((//input[@name='shipping_method'])[1]")
	private WebElement flatShippingRadioBtn;

	// ------------billingdetails webelements
	@FindBy(css = "#input-payment-firstname")
	WebElement firstNameInputField;

	@FindBy(css = "#input-payment-lastname")
	WebElement lastNameInputField;

	@FindBy(css = "#input-payment-company")
	WebElement companyInputField;

	@FindBy(css = "#input-payment-address-1")
	WebElement addressInputField;

	@FindBy(css = "#input-payment-city")
	WebElement cityInputField;

	@FindBy(css = "#input-payment-postcode")
	WebElement postalCodeInputField;

	@FindBy(css = "#input-payment-country")
	WebElement selectCountry;

	@FindBy(css = "#input-payment-zone")
	WebElement selectRegion;
//----------------------------

	@FindBy(css = "input[id='button-payment-address']")
	private WebElement billingDetailsContinueBtn;

	@FindBy(css = "input[id='button-shipping-address']")
	private WebElement deliveryDetailsContinueBtn;

	@FindBy(css = "input[id='button-shipping-method']")
	private WebElement deliveryMethodContinueBtn;

	@FindBy(css = "input[name='agree']")
	private WebElement termsAgreeCheckBox;

	@FindBy(css = "input[id='button-payment-method']")
	private WebElement paymentMethodContinueBtn;

	@FindBy(xpath = "//input[@id='button-confirm']")
	private WebElement confirmOrderBtn;

	@FindBy(xpath = "//td[text()='$809.00']")
	private WebElement totalValue;

	/*
	 * public void enterEmail() { inputEmailField.sendKeys("tony@gmail.com"); }
	 * 
	 * public void enterPassword() { inputPasswordField.sendKeys("Password2"); }
	 * 
	 * public Checkout clickLoginBtn() { loginBtn.click(); return new Checkout(); }
	 * 
	 * public void selectExistingAddressBillingDetails() {
	 * radionBtnExistingAddressBillingDetails.click(); }
	 */

	private void clickBillingDetailsContinueBtn() {
		enterBillingDetails();
		billingDetailsContinueBtn.click();
	}

	/*
	 * private void selectExistingAddressDeliveryDetails() {
	 * radionBtnExistingAddressDeliveryDetails.click(); }
	 */

	private void clickDeliveryDetailsContinueBtn() {
		// selectExistingAddressDeliveryDetails();
		deliveryDetailsContinueBtn.click();
	}

	private void clickDeliveryMethodContinueBtn() {

		deliveryMethodContinueBtn.click();
	}

	private void selectTermsAndConditionsCheckbox() {
		termsAgreeCheckBox.click();
	}

	private void clickPaymentMethodContinueBtn() {
		selectTermsAndConditionsCheckbox();
		paymentMethodContinueBtn.click();
	}

	public Success clickConfirmOrderBtn() throws InterruptedException {
		Thread.sleep(1000);
		clickBillingDetailsContinueBtn();
		Thread.sleep(1000);
		clickDeliveryDetailsContinueBtn();
		Thread.sleep(1000);
		clickDeliveryMethodContinueBtn();
		Thread.sleep(1000);
		clickPaymentMethodContinueBtn();
		Thread.sleep(1000);
		confirmOrderBtn.click();
		Thread.sleep(1000);
		return new Success();
	}

	public String showsTotalValue() {
		return totalValue.getText();
	}

	private void enterFirstName() {
		firstNameInputField.sendKeys("Tony");
	}

	private void enterLastname() {
		lastNameInputField.sendKeys("Singh");
	}

	private void enterCompanyName() {
		lastNameInputField.sendKeys("pivot");
	}

	private void enterAddress() {
		addressInputField.sendKeys("16 house");
	}

	private void enterCity() {
		cityInputField.sendKeys("Brampton");
	}

	private void enterPostalCode() {
		postalCodeInputField.sendKeys("L6Z1A1");
	}

	private void selectCountry() {
		select = new Select(selectCountry);
		select.selectByValue("4");
	}

	private void selectState() {
		select = new Select(selectRegion);
		select.selectByIndex(3);
	}

	private void enterBillingDetails() {
		enterFirstName();
		enterLastname();
		enterCompanyName();
		enterAddress();
		enterCity();
		enterPostalCode();
		selectCountry();
		selectState();
	}

}
