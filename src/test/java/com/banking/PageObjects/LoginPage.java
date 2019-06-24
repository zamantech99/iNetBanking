package com.banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver ;
	
	//Define Constructor with InitElements
	public LoginPage (WebDriver driver){
		PageFactory.initElements(driver, LoginPage.this);
	}
	
	
	//Identify the Elements in the Login Page
	
	@FindBy (xpath = "//input[@name ='uid']")
	@CacheLookup
	WebElement txtuserName;
	
	@FindBy (xpath = "//input[@name ='password']")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy (xpath = "//input[@name ='btnLogin']")
	@CacheLookup
	WebElement btnLogin;
	
	
	//Write action methods for the above elements
	
	public void setUserName (String uName) {
		txtuserName.sendKeys(uName);
	}
	
	public void setPassword (String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLoginBtn () {
		btnLogin.click();
	}
		
	/*public String verifyPageTitle () {
		 return driver.getTitle();
	}*/

	
	
	
	
}
