package com.naveenautomationlabs.AutomationFramework.Utils;

public enum Browsers {

	CHROME("Chrome"),
	EDGE("Edge"),
	FIREFOX("Firefox"),
	SAFARI ("Safari");
	

	String browserName;

	private Browsers(String browserName) {
		this.browserName = browserName;
	}

	public String getBrowserName() {
		return browserName;
	}

}