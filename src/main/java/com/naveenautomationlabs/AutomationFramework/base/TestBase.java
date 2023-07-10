package com.naveenautomationlabs.AutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.testng.annotations.BeforeClass;


import com.naveenautomationlabs.AutomationFramework.Listeners.WebDriverEvents;
import com.naveenautomationlabs.AutomationFramework.Utils.Browsers;
import com.naveenautomationlabs.AutomationFramework.Utils.Environment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;
	private FileInputStream fileInputStream;
	private Properties prop;
	public static Logger logger;
	private WebDriverEvents events;
	private EventFiringWebDriver eDriver;
	//private Browsers browserName = Browsers.CHROME;
	private Environment env = Environment.PROD;
	
	
	public TestBase()
	{
		prop= new Properties();
		try {
			fileInputStream = new FileInputStream("./src\\main\\java\\com\\naveenautomationlabs\\AutomationFramework\\Config\\Config.Properties");
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
	
	@BeforeClass
	public void setUpLogger()
	{
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}
	public void intialization()
	{
		
		String browserName= System.getProperty("Browser");	
		switch (browserName) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();// this will return chromedriver and create method returns webdriver instance
			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "Firefo":
			wd =WebDriverManager.firefoxdriver().create();
			break;

		default:
		System.out.println("not a valid browser name");
		break;
		}
		
		eDriver = new EventFiringWebDriver(wd);
		events = new WebDriverEvents();
		eDriver.register(events);
		wd = eDriver;
		
		wd.get(env.getUrl());
	//	wd.get(prop.getProperty("url"));
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("Implicit_Wait")), TimeUnit.SECONDS);
		wd.manage().window().maximize();
		
		}
	
	
	
	public void quit()
	{
		wd.quit();
	}
}
