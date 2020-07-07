/*Test Objective : To verify whether application allows admin to create a group & register new user to the group


Pre Condition : 
1. user should have launched the application & placed the order
2. admin should launch the application by entering valid URL
3. Login as admin  

Test case : UNF_051
*/

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class adminCreateRegisterGroupPOM {
	
	private WebDriver driver; 
	
	public adminCreateRegisterGroupPOM(WebDriver driver) {
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
	
	@FindBy (xpath="//*[@id=\"customer\"]/ul/li[2]/a")
	private WebElement clickCustgroup;
	
	@FindBy (xpath="//i[@class='fa fa-plus']")
	private WebElement Addbtn;
	
	@FindBy (xpath="//*[@class='form-control']")
	private WebElement customerName;
	
	@FindBy(xpath="//*[@id='input-description1']")
	private WebElement descField;
	
	@FindBy (xpath="//input[@type='radio']")
	private WebElement radioBtn;
	
	@FindBy (xpath="//*[@class='btn btn-primary']")
	private WebElement saveBtn;
	
	@FindBy (xpath="//i[@class='fa fa-user fa-fw']")
	private WebElement clickonCust;
	
	@FindBy (xpath="//li[@id='customer']//ul//li//a[contains(text(),'Customers')]")
	private WebElement selectCust;
	
	@FindBy (xpath="//i[@class='fa fa-plus']")
	private WebElement Addbtn1;
	
	@FindBy (xpath=("//*[@id='input-customer-group']"))
	private WebElement customerGroup;
	
	@FindBy (xpath="//input[@id='input-firstname']")
	private WebElement firstName; 
	
	@FindBy (xpath="//input[@id='input-lastname']")
	private WebElement lastName; 

	@FindBy (xpath="//input[@id='input-email']")
	private WebElement eMail; 
	
	@FindBy (xpath="//input[@id='input-telephone']")
	private WebElement telePhone; 
	
	@FindBy (xpath="//input[@id='input-password']")
	private WebElement passWord; 
	
	@FindBy (xpath="//input[@id='input-confirm']")
	private WebElement conFirm; 
	
	@FindBy (xpath="//*[@id='address-add']")
	private WebElement clickAddress;
	
	@FindBy (xpath ="//a[contains(@href,'#tab-address1')]")
	private WebElement addressTab;
	
	@FindBy (xpath="//input[@id='input-firstname1']")
	private WebElement firstName1;
	
	@FindBy (xpath="//input[@id='input-lastname1']")
	private WebElement lastName1;
	
	@FindBy (xpath="//*[@id='input-address-11']")
	private WebElement address1;
	
	@FindBy (xpath="//*[@id='input-address-21']")
	private WebElement address2;
	
	@FindBy (xpath="//*[@id='input-city1']")
	private WebElement city;
	
	@FindBy (xpath="//*[@id='input-postcode1']")
	private WebElement postCode;
	
	@FindBy (xpath="//*[@id='input-country1']")
	private WebElement country;

	@FindBy (xpath="//*[@id='input-zone1']")
	private WebElement state;
	
	@FindBy (xpath="//*[@class='fa fa-save']")
	private WebElement saveButton;


	
		
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
	
	public void createRegisterGroup() throws InterruptedException {
		
		//Step 1 Click on the Customers
		
		WebElement clickOnCustomer = driver.findElement(By.xpath("//i[@class='fa fa-user fa-fw']"));
		Actions act=new Actions(driver);
		act.moveToElement(clickOnCustomer).build().perform();
		Thread.sleep(3000);

		//Step 2 Click on Customer Groups link
		WebElement clickCustgroup= driver.findElement(By.xpath("//*[@id=\"customer\"]/ul/li[2]/a"));
		act.moveToElement(clickCustgroup).click().build().perform();
		Thread.sleep(3000);
		
		
		//Step 3 Click on Add New icon
		
		JavascriptExecutor jsdeletebtn = (JavascriptExecutor) driver; 
	     
		jsdeletebtn.executeScript("arguments[0].scrollIntoView();", Addbtn);
		
		
		WebElement Addbtn = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));
		act.moveToElement(Addbtn).click().build().perform();
		Thread.sleep(3000);
				
		//Step 4 Enter valid credentials in Customer Group Name textbox as Premium Member
		 WebElement customerName = driver.findElement(By.xpath("//*[@class='form-control']"));
		 customerName.sendKeys("Premium Member");
		 				
		// Step 5 Enter valid credentials in Description textbox 
		 
		 WebElement descField = driver.findElement(By.xpath("//*[@id='input-description1']"));
		 descField.sendKeys("New Group Creation");
		 
				
		//Step 6 Click yes radio button of Approve New Customers section
	
		 WebElement radioBtn = driver.findElement(By.xpath("//input[@type='radio']"));

		 act.moveToElement(radioBtn).click().build().perform();
		 
		 
		// Step 7 Click on Save button
		 
		 WebElement saveBtn = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
		 act.moveToElement(saveBtn).click().build().perform();
		 
		 
		//Step 8 Click on Customer icon
		 
		 WebElement clickOnCust = driver.findElement(By.xpath("//i[@class='fa fa-user fa-fw']"));
		 act.moveToElement(clickOnCust).build().perform();
		 Thread.sleep(3000);
		 
				
		// Step 9 Click on Customers link
		 
		 WebElement selectCust = driver.findElement(By.xpath("//li[@id='customer']//ul//li//a[contains(text(),'Customers')]"));
		 act.moveToElement(selectCust).click().build().perform();
				
		//Step 10 Click on Add new icon
		 WebElement Addbtn1 = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));
		act.moveToElement(Addbtn1).click().build().perform();
		Thread.sleep(3000);
		 	
		//Step 11 Select valid credentials in Customer group list box as Premium Member
		Select customerGroup = new Select (driver.findElement(By.xpath("//*[@id='input-customer-group']")));
		customerGroup.selectByVisibleText("Premium Member");
						
		//Enter valid credentials in First Name textbox as Reena
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		firstName.sendKeys("Reena");
				
		//Enter valid credentials in Last Name textbox as Sharma
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lastName.sendKeys("Sharma");
				
		//Enter valid credentials in E-Mail textbox reenasharma@gmail.com
		
		WebElement eMail = driver.findElement(By.xpath("//input[@id='input-email']"));
		eMail.sendKeys("reenasharma@gmail.com");
		
				
		//Enter valid credentials in Telephone textbox as 9765433214
		
		WebElement telePhone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		telePhone.sendKeys("9765433214");
		
		//Enter valid credentials in Password textbox as reenas123
		
		WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
		passWord.sendKeys("reenas123");
				
		//Enter valid credentials in Confirm password textbox as reenas123
		
		WebElement conFirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		conFirm.sendKeys("reenas123");
				
		//Click on Add Address link
		WebElement clickAddress = driver.findElement(By.xpath("//*[@id='address-add']"));
		act.moveToElement(clickAddress).click().build().perform();

		//Click on Address1 tab
		
		WebElement addressTab = driver.findElement(By.xpath("//a[contains(@href,'#tab-address1')]"));
		act.moveToElement(addressTab).click().build().perform();
		Thread.sleep(3000);
				
		//Enter First Name value again
		
		/*WebElement firstName1 = driver.findElement(By.xpath("//input[@id='input-firstname1']"));
		act.moveToElement(firstName1).build().perform();
		firstName.sendKeys("Reena");*/

				
		//Enter Last Name value again
		
		WebElement lastName1 = driver.findElement(By.xpath("//input[@id='input-lastname1']"));
		lastName1.sendKeys("Sharma");
		
		//Enter valid credentials in Address1 textbox as 4th Block
		
		WebElement address1 = driver.findElement(By.xpath("//*[@id='input-address-11']"));
		address1.sendKeys("4th Block");
				
		//Enter valid credentials in Address2 textbox as Jayanagar
		WebElement address2 = driver.findElement(By.xpath("//*[@id='input-address-21']"));
		address2.sendKeys("Jayanagar");
		
				
		//Enter valid credentials in City textbox  as Bangalore
		
		WebElement city = driver.findElement(By.xpath("//*[@id='input-city1']"));
		city.sendKeys("Bangalore"); 
		
		// Enter valid credentials in Post Code textbox as 560014
		
		WebElement postCode = driver.findElement(By.xpath("//*[@id='input-postcode1']"));
		postCode.sendKeys("560014");
				
		//Select credentials from Country list box as India
		
		Select country = new Select (driver.findElement(By.xpath("//*[@id='input-country1']")));
		country.selectByVisibleText("India");
	
		//Select credentials from Region/State list box as Karnataka
		
		Select state = new Select (driver.findElement(By.xpath("//*[@id='input-zone1']")));
		state.selectByVisibleText("Karnataka");
		
		//Click on save icon
		
		JavascriptExecutor jssavebtn = (JavascriptExecutor) driver; 
	     
		jssavebtn.executeScript("arguments[0].scrollIntoView();", saveButton);
				
		WebElement saveButton = driver.findElement(By.xpath("//*[@class='fa fa-save']"));
		act.moveToElement(saveButton).click().build().perform();
		Thread.sleep(3000);
	
	}
	
}
