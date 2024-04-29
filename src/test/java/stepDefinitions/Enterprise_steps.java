package stepDefinitions;




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
	
	
	
	@Given("user is in business page")
	public void user_is_in_business_page() {
	    bp.go_to_business_page();
	    BaseClass.getLogger().info("User in bussiness page.........");
	}

	@When("user scroll down to form")
	public void user_scroll_down_to_form() {
		BaseClass.getLogger().info("Clicking on contact sales in bussiness page.........");
	    bp.go_to_form();
	    BaseClass.getLogger().info("Form will appear.........");
	}

	@When("user fill the form and submit it")
	public void user_fill_the_form_and_submit_it() {
		BaseClass.getLogger().info("Filling the form with any one  invalid input.........");
		BaseClass.getLogger().info("After filling the form click on submit.........");
	    bp.fill_form();
	}

	@Then("get error message")
	public void get_error_message() {
		BaseClass.getLogger().info("Error message will be displayed.........");
		BaseClass.getLogger().info("Getting that error message.........");
		try {
		
	    error_message=bp.email_error_msg.getText();
	    
	    System.out.println("Error message for Invalid email-id: ");
	    System.out.println(error_message);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Then("store the error message in excel sheet")
	public void store_the_error_message_in_excel_sheet() {
		BaseClass.getLogger().info("Storing error message into excel sheet.........");
		 try {
			excelWrite.write_Data("Error_Message",error_message,1,0);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}



}
