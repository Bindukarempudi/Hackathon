package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtility;

public class Business_page {
	
	public WebDriver driver;
	JavascriptExecutor js;
	String dataPath=System.getProperty("user.dir")+"\\testData\\Data.xlsx";
	ExcelUtility excelRead;
	
	// Constructor that will be automatically called as soon as the object of the class is created
	public Business_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js=(JavascriptExecutor)driver;
		excelRead=new ExcelUtility(dataPath);

	}
	
	
	//Locating all the needed elements for the Scenario
	@FindBy(xpath="//div[@role='navigation']/a[2]")
	public WebElement business;
	
	@FindBy(id="FirstName")
	public WebElement firstName;
	
	@FindBy(id="LastName")
	public WebElement lastName;
	
	@FindBy(id="Email")
	public WebElement email;
	
	@FindBy(id="Phone")
	public WebElement phone;
	
	@FindBy(id="Title")
	public WebElement jobTitle;
	
	
	@FindBy(id="Self_reported_employees_to_buy_for__c")
	public WebElement expect_learners;
	
	@FindBy(id="Country")
	public WebElement country;
	
	@FindBy(id="State")
	public WebElement state;
	
	@FindBy(id="What_the_lead_asked_for_on_the_website__c")
	public WebElement describe_needs;
	
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submit;
	
	@FindBy(id="ValidMsgEmail")
	public WebElement email_error_msg;
	
	
	//Click on contactSales for navigating to form
	public void go_to_form() {
		js.executeScript("arguments[0].scrollIntoView();",firstName);
		
		 
	}
	
	//Click on For Business 
	public void go_to_business_page() {
		js.executeScript("arguments[0].click()",business);
	}
	
	//Fill the form
	public void fill_form() {
		String[] data=new String[9];
		for(int i=0;i<9;i++) {
			data[i]=excelRead.getCellData("FormData", i+1, 0);
		}
		firstName.sendKeys(data[0]);
		lastName.sendKeys(data[1]); 
		email.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		jobTitle.sendKeys(data[4]);
		Select s=new Select(expect_learners);
		s.selectByVisibleText(data[5]);
		Select s1=new Select(country);
		s1.selectByVisibleText(data[6]);
		Select s2=new Select(state);
		s2.selectByVisibleText(data[7]);
		Select s3=new Select(describe_needs);
		s3.selectByVisibleText(data[8]);
		
		js.executeScript("arguments[0].click()",submit);

		
	}
	
	
	
	

}
