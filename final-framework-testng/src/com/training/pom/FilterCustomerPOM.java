/*

Tester Name# BalaMurali M

Test Description : To Verify whether application allows the admin to filter the customer details in Customer List

Pre Condition : 
1. user should launch the application by entering valid URL
2. Login as admin  

Test case number : UNF_020


*/

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterCustomerPOM {
	private WebDriver driver; 
	
	public FilterCustomerPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName;

	
	@FindBy (id="input-password")
	private WebElement password;
	
	@FindBy (xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	@FindBy (xpath="//i[@class='fa fa-user fa-fw']")
	private WebElement clickOnCustomer;
	
	@FindBy (xpath="//input[@id='input-name']")
	private WebElement selectFld;
	
	@FindBy (xpath="//button[@id='button-filter']")
	private WebElement selectFilter;
	
	@FindBy (xpath ="//input[@id='input-email']")
	private WebElement emailField;
	
	@FindBy (xpath="//button[@id='button-filter']")
	private WebElement selctFilter;
	
	@FindBy (xpath="//*[@id=\"form-customer\"]/div/table/tbody/tr/td[2]")
	private WebElement confirmSearch;
	
	//Login in as Admin
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String inputPassword) {
		this.password.clear(); 
		this.password.sendKeys(inputPassword); 
	}
	
	
	
	// Click on the Login Button
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickCustomer() throws InterruptedException {

		//Select icon to view Customers 
		
	WebElement clickOnCustomer = driver.findElement(By.xpath("//i[@class='fa fa-user fa-fw']"));
	Actions act=new Actions(driver);
	act.moveToElement(clickOnCustomer).build().perform();
	Thread.sleep(3000);
	
	//Click on the Customers
			
	WebElement selectCustomer = driver.findElement(By.xpath("//li[@id='customer']//ul//li//a[contains(text(),'Customers')]"));
	act.moveToElement(selectCustomer).click().build().perform();
		
	}
	
	//Enter valid value in CustomerName field
	
	public void customerName() { 
	WebElement selectFld = driver.findElement(By.xpath("//input[@id='input-name']"));
		}
	
	//Click on Filter button
	
	public void clckFilter() {
		WebElement selectFilter = driver.findElement(By.xpath("//button[@id='button-filter']"));
		selectFilter.click();
	}
	
	//Enter valid value in E-mail field
	
	public void emailName() {
		WebElement emailField = driver.findElement(By.xpath("//input[@id='input-email']"));
		emailField.sendKeys("Neha@gmail.com");
	}
	
	//Click on Filter button to search with email
	
		public void clickFilter() {
			WebElement selctFilter = driver.findElement(By.xpath("//button[@id='button-filter']"));
			selctFilter.click();
		}
	
		public void filterResult() throws InterruptedException {
		
		//Scroll down window to find the records with name as Neha 	
					
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView();", confirmSearch);	
		
		Actions act=new Actions(driver);
		act.moveToElement(confirmSearch).build().perform();
		Thread.sleep(3000);

		// Find the search record with Name as Neha
		
		WebElement confirmSearch = driver.findElement(By.xpath("//*[@id=\"form-customer\"]/div/table/tbody/tr/td[2]"));
		
		
		}
		
	
}

