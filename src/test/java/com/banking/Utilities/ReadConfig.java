package com.banking.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()  {
		
		try {
			
			FileInputStream fip = new FileInputStream("./Config/config.properties");
			prop = new Properties ();
			prop.load(fip);
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}
	
	public String getApplicationURL () {
		String url = prop.getProperty("baseURL");
		return url;
	}

	public String getUserName () {
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getBrowserName() {
		String browserName = prop.getProperty("browserName");
		return browserName;
	}
	
}
