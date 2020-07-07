/*
Tester Name# BalaMurali M

Test Description : To Verify whether application allows the admin to delete Customer details from Customer list

Pre Condition : 
1. user should launch the application by entering valid URL
2. Login as admin  

Test case number : UNF_021
*/


package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDeletePOM {
	private WebDriver driver; 
	
	public CustomerDeletePOM(WebDriver driver) {
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
	
	@FindBy (xpath="//li[@id='customer']//ul//li//a[contains(text(),'Customers')]")
	private WebElement selectCustomer;
	
	@FindBy  (xpath="//div[@id='container']//tbody//tr[1]//td[2]")
	private WebElement chekBox;
	
	@FindBy (xpath="//i[@class='fa fa-trash-o']")
	private WebElement deletebtn;
	
		
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
		
		//Step 2. Click on Customers link
		
		public void clickOnCustomer () throws InterruptedException {
			
		WebElement clickOnCustomer = driver.findElement(By.xpath("//i[@class='fa fa-user fa-fw']"));
		Actions act=new Actions(driver);
		act.moveToElement(clickOnCustomer).build().perform();
		Thread.sleep(3000);
				
		WebElement selectCustomer = driver.findElement(By.xpath("//li[@id='customer']//ul//li//a[contains(text(),'Customers')]"));
		act.moveToElement(selectCustomer).click().build().perform();
					
		// Step 3. Click on Check box of the customer to delete
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		//Scroll window to select check boxes
     	     
		js.executeScript("arguments[0].scrollIntoView();", chekBox);
		
		//clicking on check box
		WebElement chekBox = driver.findElement(By.xpath("//tbody//tr[1]//td[1]//input[1]"));
		act.moveToElement(chekBox).click().build().perform();
		Thread.sleep(3000);
		
		//Step 4: Scroll window to  find  delete button 
		
		JavascriptExecutor jsdeletebtn = (JavascriptExecutor) driver; 
			     
		jsdeletebtn.executeScript("arguments[0].scrollIntoView();", deletebtn);
		
		
		WebElement deletebtn = driver.findElement(By.xpath("//i[@class='fa fa-trash-o']"));
		act.moveToElement(deletebtn).click().build().perform();
		Thread.sleep(3000);
		
		//Switching to Alert        
        Alert alert = driver.switchTo().alert();
        
        //Accepting alert		
        alert.accept();	
		
        
		 //Step 5. Click on Ok button of window
	
        WebElement expectedResult = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		WebElement actualResult=driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		assertEquals(actualResult,expectedResult);
		
		}
	

}
