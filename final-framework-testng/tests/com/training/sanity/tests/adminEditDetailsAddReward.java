/*

Test Objective : To verify whether application allows admin to edit Customer details & add reward points


Pre Condition : 
1. user should have launched the application & placed the order
2. admin should launch the application by entering valid URL
3. Login as admin
4. User should have placed order  

Test case : UNF_050
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
import com.training.pom.FilterCustomerPOM;
import com.training.pom.adminEditDetailsAddRewardPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

@Test
public class adminEditDetailsAddReward {
	
	private WebDriver driver;
	private String baseUrl;
	private adminEditDetailsAddRewardPOM addrewardPOM;
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
		addrewardPOM = new adminEditDetailsAddRewardPOM (driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod

	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
public void LoginTest() throws InterruptedException {
		
		//Send admin field  value 
	addrewardPOM.sendUserName("admin");
		
		//Send the password field value 
	addrewardPOM.sendPassword("admin@123");
		
		//Click on the Login button
	addrewardPOM.clickLoginBtn(); 
	
	//Work on EditAddReward 
	addrewardPOM.editAddReward();
	
	
 	screenShot.captureScreenShot("AddReward");

			
	}

}
