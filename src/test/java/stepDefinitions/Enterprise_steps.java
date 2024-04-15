package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Business_page;
import utilities.ExcelUtility;

public class Enterprise_steps {
	WebDriver driver =BaseClass.getDriver();
	Business_page bp=new Business_page(driver);

	String path=System.getProperty("user.dir")+"\\testData\\OutputData.xlsx";
	ExcelUtility excelWrite=new ExcelUtility(path);
	
	String error_message;
	
	
	@Given("user click on contact sales which is in business page")
	public void user_click_on_contact_sales_which_is_in_business_page() {
		BaseClass.getLogger().info("Click on contact sales in bussiness page.........");
	    bp.go_to_form();
	    BaseClass.getLogger().info("Form will appear.........");
	}

	@When("user fill the form and submit it")
	public void user_fill_the_form_and_submit_it() {
		BaseClass.getLogger().info("Fill the form with some data and for email give invalid email.........");
		BaseClass.getLogger().info("After filling the form click on submit.........");
	    bp.fill_form();
	}

	@Then("get error message")
	public void get_error_message() {
		BaseClass.getLogger().info("Error message will be displayed.........");
		BaseClass.getLogger().info("Get that error message.........");
	    error_message=bp.email_error_msg.getText();
	}

	@Then("store the error message in excel sheet")
	public void store_the_error_message_in_excel_sheet() {
		BaseClass.getLogger().info("Store error message into excel sheet.........");
		 try {
			excelWrite.write_Data("Sheet3",error_message,1,0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
