/*Test Objective : To verify whether application allows admin to create a group & register new user to the group


Pre Condition : 
1. user should have launched the application & placed the order
2. admin should launch the application by entering valid URL
3. Login as admin  

Test case : UNF_051
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
import com.training.pom.LoginPOM;
import com.training.pom.adminCreateRegisterGroupPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

@Test
public class adminCreateRegisterGroup {
	
	private WebDriver driver;
	private String baseUrl;
	private adminCreateRegisterGroupPOM groupRegisterPOM;
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
		groupRegisterPOM = new adminCreateRegisterGroupPOM(driver); 
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
		groupRegisterPOM.sendUserName("admin");
		
		//Send the password field value 
		groupRegisterPOM.sendPassword("admin@123");
		
		//Click on the Login button
		groupRegisterPOM.clickLoginBtn(); 
		
		//click on the Customers
		groupRegisterPOM.createRegisterGroup();
		
					
	
	}


}
