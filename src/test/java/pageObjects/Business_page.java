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
	public Business_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js=(JavascriptExecutor)driver;
		excelRead=new ExcelUtility(dataPath);

	}
	
	@FindBy(xpath="//div[@role='navigation']/a[2]")
	public WebElement business;
	
	@FindBy(xpath="//span[text()='Contact Sales']")
	public WebElement contactSales;
	
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
	
	@FindBy(id="What_the_lead_asked_for_on_the_website__c")
	public WebElement describe_needs;
	
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submit;
	
	@FindBy(id="ValidMsgEmail")
	public WebElement email_error_msg;
	
	
	public void go_to_form() {
		js.executeScript("arguments[0].click()",business);
		js.executeScript("arguments[0].click()",contactSales);
		 
	}
	
	public void fill_form() {
		String[] data=new String[8];
		for(int i=0;i<8;i++) {
			data[i]=excelRead.getCellData("Sheet2", i, 0);
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
		Select s2=new Select(describe_needs);
		s2.selectByVisibleText(data[7]);
		
		js.executeScript("arguments[0].click()",submit);	
		
	}
	
	public void get_error_msg() {
		System.out.println(email_error_msg.getText());
	}
	
	

}
