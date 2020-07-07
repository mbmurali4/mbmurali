/*

Test Objective : To Verify whether application allows the admin to filter the customer details in Customer List

This program tests the Filter options for customer based on "Customer Name" and "Customer Email id" 

Pre Condition : There are existing customers data available with name as "Neha" and email as "Neha@gmail.com"  

*/

package com.training.sanity.tests;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FilterCustomerPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

@Test
public class filterCustomerList { 

	private WebDriver driver;
	private String baseUrl;
	private FilterCustomerPOM filtercustomerPOM;
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
		filtercustomerPOM = new FilterCustomerPOM (driver);
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
	
	
	
	public void LoginTest() throws InterruptedException {
		
		//Send admin field  value 
		filtercustomerPOM.sendUserName("admin");
		
		//Send the password field value 
		filtercustomerPOM.sendPassword("admin@123");
		
		//Click on the Login button
		filtercustomerPOM.clickLoginBtn(); 
		
		//Select the Customer icon 
		filtercustomerPOM.clickCustomer();
		
		//Click on Customer field to enter search value
		filtercustomerPOM.customerName();
		
		//Click on Filter button to search with Customer Name
		filtercustomerPOM.clckFilter();
		
		//Enter  value Email field to search
		filtercustomerPOM.emailName();
		
		//Filter Search result for email id displayed 
		filtercustomerPOM.clickFilter();
		
		//Scroll down window and find search record
		filtercustomerPOM.filterResult();
		
		//Enter valid value in CustomerName field

		WebElement selectFld = driver.findElement(By.xpath("//input[@id='input-name']"));
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-name']")),driver.findElement(By.xpath("//input[@id='input-name']")));
		
	 	screenShot.captureScreenShot("CustFilter1");
	 	
	}

			
	}


