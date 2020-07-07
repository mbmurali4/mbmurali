/*

Test Objective : To verify whether application allows admin to edit Customer details & add reward points


Pre Condition : 
1. user should have launched the application & placed the order
2. admin should launch the application by entering valid URL
3. Login as admin
4. User should have placed order  

Test case : UNF_050
*/

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.ScreenShot;

public class adminEditDetailsAddRewardPOM {
	private WebDriver driver; 

	
	public adminEditDetailsAddRewardPOM(WebDriver driver) {
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
	
	@FindBy (xpath="//*[@id=\"form-customer\"]/div/table/tbody/tr[1]/td[8]/a")
	private WebElement editBtn;
	
	@FindBy (xpath="//*[@id='input-firstname']")
	private WebElement firstName;

	@FindBy (xpath="//*[@id='address-add']")
	private WebElement clickAddress;
	
	@FindBy (xpath="//a[contains(@href,'#tab-address1')]")
	private WebElement addressTab;
	
	@FindBy (xpath="//*[@id='input-reward-description']")
	private WebElement desctextbox;

	@FindBy (xpath="//*[@id='input-points']")
	private WebElement points;
	
	@FindBy (xpath="//*[@id='button-reward']")
	private	WebElement AddReward;
	
	@FindBy (xpath="//*[@class='btn btn-default']")
	private WebElement savePoints;

	@FindBy (xpath="//*[@class='alert alert-success']")
	private WebElement saveSucess;


	
	
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
	
	public void editAddReward() throws InterruptedException {
		
		// Click on Customer icon
		
		WebElement clickOnCustomer = driver.findElement(By.xpath("//i[@class='fa fa-user fa-fw']"));
		Actions act=new Actions(driver);
		act.moveToElement(clickOnCustomer).build().perform();
		Thread.sleep(3000);
				
				
		//Click on Customers link
		
		WebElement selectCustomer = driver.findElement(By.xpath("//li[@id='customer']//ul//li//a[contains(text(),'Customers')]"));
		act.moveToElement(selectCustomer).click().build().perform();
		
		// Click on Edit icon of the Customer
		
		driver.navigate().refresh();
		WebElement editBtn = driver.findElement(By.xpath("//*[@id=\"form-customer\"]/div/table/tbody/tr[1]/td[8]/a"));
		act.moveToElement(editBtn).click().build().perform();
		Thread.sleep(2000);

		//Clear First Name textbox
		WebElement firstName = driver.findElement(By.xpath("//*[@id='input-firstname']"));
		firstName.clear();
		
		//Enter valid credentials in First Name textbox as Chitra

		firstName.sendKeys("Chitra");
		
	
		//Click on Add Address link
		WebElement clickAddress = driver.findElement(By.xpath("//*[@id='address-add']"));
		act.moveToElement(clickAddress).click().build().perform();

		//Click on Address1 tab
				
		WebElement addressTab = driver.findElement(By.xpath("//a[contains(@href,'#tab-address1')]"));
		act.moveToElement(addressTab).click().build().perform();
		Thread.sleep(3000);
		
		//Enter valid credentials in PostCode textbox as 560097
				
		WebElement postCode = driver.findElement(By.xpath("//*[@id='input-postcode1']"));
		postCode.sendKeys("560097");
			
		//Click on Reward Points tab
		
		WebElement rewardPoint = driver.findElement(By.xpath("//*[@href='#tab-reward']"));
		rewardPoint.click();
			
		//Enter valid credentials in Description textbox as bonus
			
		WebElement desctextbox	= driver.findElement(By.xpath("//*[@id='input-reward-description']"));
		desctextbox.sendKeys("Bonus");
		
		//Enter valid credentials in Points textbox as 20
		
		WebElement points = driver.findElement(By.xpath("//*[@id='input-points']"));
		points.sendKeys("20");
		

		//Click on Add reward Points button
		
		WebElement AddReward = driver.findElement(By.xpath("//*[@id='button-reward']"));
		AddReward.click();
		
		//Click on Save button
		WebElement savePoints = driver.findElement(By.xpath("//*[@class='btn btn-default']"));
		savePoints.click();

		
		//Sucess message displayed after saving the points
		//WebElement saveSucess = driver.findElement(By.xpath("//*[@class='alert alert-success']"));
		
	}
}
