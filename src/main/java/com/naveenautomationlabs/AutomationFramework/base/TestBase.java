package com.naveenautomationlabs.AutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;
	FileInputStream fileInputStream;
	Properties prop;
	
	public TestBase()
	{
		prop= new Properties();
		try {
			fileInputStream = new FileInputStream("C:\\Users\\Rimpi\\eclipse-workspace\\AutomationFramework\\src\\main\\java\\com\\naveenautomationlabs\\AutomationFramework\\Config\\Config.Properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void intialization()
	{
		String browserName= prop.getProperty("browser");	
		switch (browserName) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();// this will return chromedriver and create method returns webdriver instance
			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "Firefox":
			wd =WebDriverManager.firefoxdriver().create();
			break;

		default:
		System.out.println("not a valid browser name");
		break;
		}
		
		wd.get(prop.getProperty("url"));
		//wd.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("Implicit_Wait")), TimeUnit.SECONDS);
		wd.manage().window().maximize();
		
		}
	
	
	public void quit()
	{
		wd.quit();
	}
}
