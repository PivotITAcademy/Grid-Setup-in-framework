package com.naveenautomationlabs.AutomationFramework.Utils;

public enum Environment {

	DEV("Dev","https://naveenautomationlabs.com/opencart/index.php?route=common/home"),
	STAGE("Stage","https://naveenautomationlabs.com/opencart/index.php?route=common/home"),
	QA("Qa","https://naveenautomationlabs.com/opencart/index.php?route=common/home"),
	PROD("Production","https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	
	String env;
	String url;
	
	private Environment(String env, String url) {
		this.env = env;
		this.url = url;
	}

	public String getEnv() {
		return env;
	}

	public String getUrl() {
		return url;
	}
	
	
	
}
