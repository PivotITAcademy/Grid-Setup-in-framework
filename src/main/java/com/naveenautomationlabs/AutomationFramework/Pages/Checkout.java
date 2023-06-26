package com.naveenautomationlabs.AutomationFramework.Pages;

import java.util.concurrent.TimeUnit;

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

	@FindBy(xpath = "(//input[@name='payment_address'])[2]")
	private WebElement newAddressRadioBtn;

	@FindBy(xpath = "((//input[@name='shipping_address'])[1]")
	private WebElement radionBtnExistingAddressDeliveryDetails;

	@FindBy(xpath = "((//input[@name='shipping_method'])[1]")
	private WebElement flatShippingRadioBtn;

	// ------------BillingDetails WebElements
	@FindBy(css = "#input-payment-firstname")
	private WebElement firstNameInputField;

	@FindBy(css = "#input-payment-lastname")
	private WebElement lastNameInputField;

	@FindBy(css = "#input-payment-company")
	private WebElement companyInputField;

	@FindBy(css = "#input-payment-address-1")
	private WebElement addressInputField;

	@FindBy(css = "#input-payment-city")
	private WebElement cityInputField;

	@FindBy(css = "#input-payment-postcode")
	private WebElement postalCodeInputField;

	@FindBy(css = "#input-payment-country")
	private WebElement selectCountry;

	@FindBy(css = "#input-payment-zone")
	private WebElement selectRegion;
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

	private void selectNewAddressBillingDetails() {
		newAddressRadioBtn.click();
	}

	private void clickBillingDetailsContinueBtn() {
		enterBillingDetails();
		billingDetailsContinueBtn.click();
	}

	private void clickDeliveryDetailsContinueBtn() {

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

	public Success clickConfirmOrderBtn() {
		wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		clickBillingDetailsContinueBtn();

		clickDeliveryDetailsContinueBtn();

		clickDeliveryMethodContinueBtn();

		clickPaymentMethodContinueBtn();

		confirmOrderBtn.click();

		return new Success();
	}

	public Success clickConfirmOrderBtnWithLogin() {
		wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		selectNewAddressBillingDetails();

		clickBillingDetailsContinueBtn();

		clickDeliveryDetailsContinueBtn();

		clickDeliveryMethodContinueBtn();

		clickPaymentMethodContinueBtn();

		confirmOrderBtn.click();

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
		wd.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

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
