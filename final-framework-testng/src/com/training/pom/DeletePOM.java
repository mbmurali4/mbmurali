package com.training.pom;

import static org.testng.Assert.assertSame;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.Assert;

public class DeletePOM {
	private WebDriver driver; 
	
	public DeletePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName;

	
	@FindBy (id="input-password")
	private WebElement password;
	
	@FindBy (xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	@FindBy (xpath="//i[@class='fa fa-shopping-cart fa-fw']")
	private WebElement clickReturns;
	
	//Absolute path used here 
	@FindBy (xpath=("/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[3]/a[1]"))
	private WebElement navReturns;
	
	@FindBy (xpath= ("//tbody//tr[1]//td[1]//input[1]"))
	private WebElement chkBox;
	
	@FindBy (xpath="//i[@class='fa fa-trash-o']")
	private WebElement deletebtn;
	
	@FindBy(xpath = "//*[contains(text(),'Success: You have modified returns!')]")
	private WebElement expectedResult;
	


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
	
	
	//Step 2: Click on Returns 
	
	public void clickReturns() throws InterruptedException  {
		
		
		WebElement clickReturns = driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart fa-fw']"));
		Actions act=new Actions(driver);
		act.moveToElement(clickReturns).build().perform();
		Thread.sleep(3000);
		
		
		WebElement navReturns = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[3]/a[1]"));	
		act.moveToElement(navReturns).click().build().perform();
		
		//Step 3: Click on Check box of the order to delete
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		//Scroll window to select checkbox
     	     
		js.executeScript("arguments[0].scrollIntoView();", chkBox);
		
		//Clicking on the Checkbox
		
		WebElement chkBox = driver.findElement(By.xpath("//tbody//tr[1]//td[1]//input[1]"));
		act.moveToElement(chkBox).click().build().perform();
		Thread.sleep(3000);
		
		JavascriptExecutor jsdeletebtn = (JavascriptExecutor) driver; 
		
		//Scroll window to  find  delete button 
	     
		jsdeletebtn.executeScript("arguments[0].scrollIntoView();", deletebtn);
		
		//Step 4: Click on Delete Icon
		
		WebElement deletebtn = driver.findElement(By.xpath("//i[@class='fa fa-trash-o']"));
		act.moveToElement(deletebtn).click().build().perform();
		Thread.sleep(3000);
		
		// Switching to Alert        
        Alert alert = driver.switchTo().alert();
        
     // Accepting alert		
        alert.accept();	
		
		//Step 5 : Check for Success message after product deletion
        WebElement expectedResult = driver.findElement(By.xpath("//*[contains(text(),'Success: You have modified returns!')]"));
		WebElement actualResult=driver.findElement(By.xpath("//*[contains(text(),'Success: You have modified returns!')]"));
		assertEquals(actualResult,expectedResult);
						
	}
		
	}


	

