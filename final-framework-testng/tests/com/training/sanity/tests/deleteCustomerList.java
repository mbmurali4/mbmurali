/*
Tester Name# BalaMurali M

Test Description : To Verify whether application allows the admin to delete Customer details from Customer list

Pre Condition : 
1. user should launch the application by entering valid URL
2. Login as admin  

Test case number : UNF_021
*/

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CustomerDeletePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class deleteCustomerList { 

	private WebDriver driver;
	private String baseUrl;
	private CustomerDeletePOM customerdeletePOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
}
	
	@BeforeMethod

	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		customerdeletePOM = new CustomerDeletePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod

	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		customerdeletePOM.sendUserName("admin");
		customerdeletePOM.sendPassword("admin@123");
		customerdeletePOM.clickLoginBtn(); 
		customerdeletePOM.clickOnCustomer();
	 	screenShot.captureScreenShot("Cust1");
	}

	

}
