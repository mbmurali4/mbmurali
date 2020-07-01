package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterCustomerPOM {
	

	private WebDriver driver; 
	
	public void FilterCustomerPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
			
	}
	
	
	@FindBy(id="input-username")
	private WebElement userName;

	
	@FindBy (id="input-password")
	private WebElement password;
	
	@FindBy (xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn;

	//Step 1: Login as Admin
	
		public void sendUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
		
		public void sendPassword(String inputPassword) {
			this.password.clear(); 
			this.password.sendKeys(inputPassword); 
		}
			
		public void clickLoginBtn() {
			this.loginBtn.click(); 
		}
		
	// Step 2: Click on Customer icon
		
		
		
		
	// Step 3: Click on Customers link
		
	// Step 4: Enter valid credentials in Customer Name textbox
		
	// Step 5: Click on Filter button
		
	// Step 6: Enter Valid credentials in E-Mail textbox
		
	// Step 7: Click on Filter button
}

