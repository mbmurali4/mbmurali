/*

Tester Name# BalaMurali M

Test Description : To verify whether application allows admins to return product of customer & delete from return list

Pre Condition : 
1. user should have launched the application & placed the order
2. admin should launch the application by entering valid URL
3. Login as admin
4. User should have placed order


Test case number : UNF_049


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
import com.training.pom.adminReturnDeletePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class adminReturnDelete {
	
	private WebDriver driver;
	private String baseUrl;
	private adminReturnDeletePOM adminPOM;
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
	adminPOM = new adminReturnDeletePOM(driver); 
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
@Test
public void validLoginTest() throws InterruptedException {
	//Send Login field value 
	adminPOM.sendUserName("admin");
	
	//Send Password field value 
	adminPOM.sendPassword("admin@123");
	
	//Click on the Login button
	adminPOM.clickLoginBtn(); 
	
	//Create a new record and delete  
	adminPOM.cartSelection();
 
	//Screencapture the results
	screenShot.captureScreenShot("adminReturn");
}

}
		




