package com.banking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.PageObjects.BaseClass;
import com.banking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{


	static LoginPage loginpage;  	
	
	
	@Test
	public static void validLoginTest () {
		driver.get(prop.getProperty("baseURL"));	
		loginpage= new LoginPage(driver);
		loginpage.setUserName(prop.getProperty("username"));
			logger.info("Entered UserName.");
		loginpage.setPassword(prop.getProperty("password"));
			logger.info("Entered Password.");
			
		loginpage.clickLoginBtn();
			logger.info("Login Button is now clicked.");
	}

	
	@Test
	public static void verifyPageTitle () {
		String loginPageTitle = driver.getTitle();
		
		if (loginPageTitle.equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
				logger.info("Verified Page Title.");
		} 
		
		else {
			Assert.assertTrue(false);
				logger.info("Login Test Failed.");
		}
		
	
		
		//comment
	}
	
}
