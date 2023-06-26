package com.naveenautomationlabs.AutomationFramework.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.AutomationFramework.base.TestBase;

public class AppleCinema30 extends TestBase {

	WebDriverWait wait = new WebDriverWait(wd, 10);
	public AppleCinema30() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "(//input[@name='option[218]'])[2]")
	private WebElement mediumRadioBtn;

	@FindBy(xpath = "(//input[@name='option[223][]'])[1]")
	private WebElement checkBox2;

	@FindBy(xpath = "//input[@id='input-option208']")
	private WebElement textInputField;

	@FindBy(css = "#input-option217")
	private WebElement selectOption;

	@FindBy(xpath = "//textarea[@id='input-option209']")
	private WebElement textAreaInputField;

	@FindBy(id = "button-upload222")
	private WebElement fileUpload;

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//a[text()='shopping cart']")
	private WebElement shoppingCartBtn;

	private void mediumRadioBtnClick() {
		
wait.until(ExpectedConditions.elementToBeClickable(mediumRadioBtn)).click();
	//	mediumRadioBtn.click();
	}

	private void selectCheckBox() {
		
		wait.until(ExpectedConditions.elementToBeClickable(checkBox2)).click();
	//	checkBox2.click();
	}

	private void inputText() {
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(null))
		textAreaInputField.sendKeys("test");
	}

	private void enterTextInTextArea() {
		textAreaInputField.sendKeys("testing");
	}

	private void selectPCColor() {
		Select sc = new Select(selectOption);
		sc.selectByIndex(2);
	}

	private void uploadFile() {
		// fileUpload.sendKeys("G:\\Software Testing 2023\\Items.txt");
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("arguments[0].click();", fileUpload);

		try {
			Robot robot = new Robot();
			robot.delay(1000);
			// put the file in clipboard

			StringSelection ss = new StringSelection("G:\\Software Testing 2023\\Items.txt");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// ctrl +v
			robot.keyPress(KeyEvent.VK_CONTROL); // press control key
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);

			// Enter

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wd.switchTo().alert().accept();

	}

	public AppleCinema30 clickAddToCartBtn() {
		addToCart();
		addToCartBtn.click();
		return new AppleCinema30();
	}

	public ShoppingCart clickShoppingCartBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCartBtn)).click();
		return new ShoppingCart();
	}

	private void addToCart() {
	
		
		mediumRadioBtnClick();
		selectCheckBox();
		inputText();
		selectPCColor();
		enterTextInTextArea();
		uploadFile();

	}
}
