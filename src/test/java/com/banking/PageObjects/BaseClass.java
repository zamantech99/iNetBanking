package com.banking.PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

//	User ID :	mngr204612
//	Password :	amymasU
	public static WebDriver driver; 
	public static Logger logger;
	public static Properties prop;
	
		
	@Parameters ("browser")
	@BeforeClass
	public static void setup(String browser) {
			
			//*******Initiating Config Files******
				//D:\\Selenium Project\\zBankingProject\\
			File src = new File ("./Config\\config.properties");
			try {
								
				FileInputStream fis = new FileInputStream(src);
				prop = new Properties();
				prop.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is : " + e.getMessage());
			}
			
			// ******Initiating Logger files*****
			logger = Logger.getLogger("BankingProject");
			PropertyConfigurator.configure("log4j.properties");
			
		
			//*******Initiating Browser Launch********
						//prop.getProperty("browserName").
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
			}
				
			else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "//Drivers//geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//driver.get("https://www.news.google.com");
			driver.get(prop.getProperty("baseURL"));			
				logger.info("URL is opened");			
					
		}
		
		
		
	@AfterClass
	public static void teardown() throws InterruptedException {
			Thread.sleep(3000);
			driver.quit();
		}
		
		
}
