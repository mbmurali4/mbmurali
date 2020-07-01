package com.training.sanity.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import com.training.generics.ScreenShot;
import com.training.pom.DeletePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class deleteReturnedProduct {

	private WebDriver driver;
	private String baseUrl;
	private DeletePOM deletePOM;
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
	deletePOM = new DeletePOM(driver); 
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
	deletePOM.sendUserName("admin");
	deletePOM.sendPassword("admin@123");
	deletePOM.clickLoginBtn(); 
	deletePOM.clickReturns();
 //deletePOM.chkBox();
	screenShot.captureScreenShot("Checkbox1");
}


}
	

