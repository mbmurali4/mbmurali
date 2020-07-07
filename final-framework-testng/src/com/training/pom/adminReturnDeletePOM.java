/*

Tester Name# BalaMurali M

Test Description : To verify whether application allows admin to return product of customer & delete from return list

Pre Condition : 
1. user should have launched the application & placed the order
2. admin should launch the application by entering valid URL
3. Login as admin
4. User should have placed order


Test case number : UNF_049


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

import common.Assert;

public class adminReturnDeletePOM {
	private WebDriver driver; 
	
	public adminReturnDeletePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName;

	
	@FindBy (id="input-password")
	private WebElement password;
	
	@FindBy (xpath="//*[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	@FindBy (xpath="//*[@class=\"fa fa-shopping-cart fa-fw\"]")
	private WebElement selectCart;
	
	@FindBy (xpath="\"//i[@class='fa fa-plus']\"")
	private WebElement clickAdd;
	
	@FindBy (xpath = "//input[@id=\"input-order-id\"]")
	private WebElement selectFld;
	
	
	@FindBy (xpath = "//input[@id='input-customer']")
	private WebElement custFld;
	
	@FindBy (xpath="//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy (xpath = "//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy (xpath="//input[@id='input-email']")
	private WebElement eMail;
	
	@FindBy (xpath="//input[@id='input-telephone']")
	private WebElement phoneNumber;
	
	@FindBy (xpath="//input[@id='input-product']")
	private WebElement productField;
	
	@FindBy (xpath="//input[@id='input-model']")
	private WebElement modelField;
	
	@FindBy (xpath = "//*[@class='btn btn-primary']")
	private WebElement clickSave;
	
	@FindBy (xpath="//input[@name='selected[]']")
	private WebElement chckbo;
	
	@FindBy (xpath="//*[@class='btn btn-danger']")
	private WebElement selectdelicon;
	
	@FindBy (xpath="//*[@class='alert alert-success']")
	private WebElement actualResult;
	
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
	
	public void cartSelection() throws InterruptedException {
		
		//Click on the Cart icon 
		
		WebElement clickOnCustomer = driver.findElement(By.xpath("//*[@class=\"fa fa-shopping-cart fa-fw\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(selectCart).build().perform();
		Thread.sleep(3000);
		
		//Click on Returns 
		
		WebElement navReturns = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[3]/a[1]"));	
		act.moveToElement(navReturns).click().build().perform();
		
		//Click on Add icon 
		WebElement clickAdd = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));
		act.moveToElement(clickAdd).click().build().perform();
		
		// Enter valid credential in Order ID textbox
		WebElement selectFld = driver.findElement(By.xpath("//input[@id=\"input-order-id\"]"));
		selectFld.sendKeys("25");
		
		//  Enter valid credential in Customer textbox
		
		WebElement custFld = driver.findElement(By.xpath("//input[@id='input-customer']"));
		custFld.sendKeys("Renu Mathur");
		
		
		//Enter valid credential in First Name textbox as 'Renu'
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		firstName.sendKeys("Renu");
		
		//Enter valid credential in Last Name textbox as mathur
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lastName.sendKeys("mathur2");
		
		// Enter valid credential in E-Mail textbox as renu.mathur1@gmail.com
		
		WebElement eMail = driver.findElement(By.xpath("//input[@id='input-email']"));
		eMail.sendKeys("renu.mathur2@gmail.com");
		
		//Enter valid credential in Phone textbox as 9453234555
		
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		phoneNumber.sendKeys("9453234554");
		
		// Enter valid credential in Product textbox as  Blazer Girls
		
		WebElement productField = driver.findElement(By.xpath("//input[@id='input-product']"));
		productField.sendKeys("Blazer Girls");
		
		// Enter valid credential in Model textbox as BLG-112
		
		WebElement modelField = driver.findElement(By.xpath("//input[@id='input-model']"));
		modelField.sendKeys("BLG-112");
		
		
		// Click on Save icon
		
		WebElement clickSave = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
		act.moveToElement(clickSave).click().build().perform();
				
		
		// Click on checkboxes beside return product
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView();", chckbo);	
		
		WebElement chckbo = driver.findElement(By.xpath("//input[@name='selected[]']"));
		act.moveToElement(chckbo).click().build().perform();
		
		// Click on Delete icon
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver; 
		js1.executeScript("arguments[0].scrollIntoView();", selectdelicon);
		
		WebElement selectdelicon = driver.findElement(By.xpath("//*[@class='btn btn-danger']"));
		act.moveToElement(selectdelicon).click().build().perform();
		
		//Switching to Alert        
        Alert alert = driver.switchTo().alert();
        
        //Accepting alert		
        alert.accept();	
		
		// Click on OK button and verify the success message
		
		 WebElement expectedResult = driver.findElement(By.xpath("//*[contains(text(),'Success: You have modified returns!')]"));
		 WebElement actualResult=driver.findElement(By.xpath("//*[contains(text(),'Success: You have modified returns!')]"));
		 assertEquals(actualResult,expectedResult); 
        
        /*String expectedResult = "Success: You have modified returns!";
        String actualResult = 	driver.findElement(By.xpath("//*[@class='alert alert-success']")).getText();	
        assertEquals(actualResult, expectedResult);*/
	}
}
