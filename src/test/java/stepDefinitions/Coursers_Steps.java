package stepDefinitions;


import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Home_page;
import utilities.ExcelUtility;

public class Coursers_Steps {
	
	public WebDriver driver;
	Properties p;
	 Home_page hp;
	 String firstWindow;
	 String[] data;
	 String dataPath=System.getProperty("user.dir")+"\\testData\\OutputData.xlsx";
	 ExcelUtility excel;
	
	@Given("User opens the application with provided URL")
	public void user_opens_the_application_with_provided_url() {
		BaseClass.getLogger().info("Open application with provided URL.........");
    	driver=BaseClass.getDriver();
		hp=new Home_page(driver);
	    excel=new ExcelUtility(dataPath);
	}

	@When("User search for {string} courses and clicks on search button")
	public void user_search_for_courses_and_clicks_on_search_button(String course) {
		BaseClass.getLogger().info("Enter the text('Web development') in search box and click on search button.........");
		hp.enter_text_in_SearchBox(course);
		
	}

	@When("select the English Language filter option")
	public void select_the_english_language_filter_option() {
		BaseClass.getLogger().info("Apply english language filter.........");
		hp.select_English_Language();
	}

	@When("select the Beginner level filter option")
	public void select_the_beginner_level_filter_option() {
		BaseClass.getLogger().info("Apply beginner level filter.........");
	   hp.select_Beginner_Level();
	}

	@When("user click on the first course")
	public void user_click_on_the_first_course() {
		BaseClass.getLogger().info("The list of courses will appear.........");
		BaseClass.getLogger().info("Click on the first course.........");
		hp.click_On_First_Course();
	}

	@Then("user should naviagate to new window for first course")
	public void user_should_naviagate_to_new_window_for_first_course() {
		BaseClass.getLogger().info("Navigate to new window for first course.........");
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!hp.originalWindow.equals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        firstWindow=driver.getWindowHandle();
		        break;
		    }
		}
	}

	@Then("Collect the title,rating and duration of course in hours")
	public void collect_the_title_rating_and_duration_of_course_in_hours() {
		BaseClass.getLogger().info("Collect the details like title,rating,duration of course in hours.........");
	    data=hp.collect_details();
	}

	@Then("add first course data to excel")
	public void add_first_course_data_to_excel() {
		BaseClass.getLogger().info("Store first course data into excel sheet.........");
		for(int i=1;i<=3;i++) {
		   excel.writeData(dataPath,"Sheet1", i, 1, data[i-1]);
		}
	}

	@Then("After gathering the data,user should navigate back to parent window from child window")
	public void after_gathering_the_data_user_should_navigate_back_to_parent_window_from_child_window() {
		BaseClass.getLogger().info("Navigate back to parent window from child window.........");
		driver.switchTo().window(hp.originalWindow);
	}

	@When("Now User click on the second course")
	public void now_user_click_on_the_second_course() {
	   BaseClass.getLogger().info("Click on the second course.........");
	   hp.click_On_second_Course();
	}

	@Then("user should naviagate to new window for second course")
	public void user_should_naviagate_to_new_window_for_second_course() {
		BaseClass.getLogger().info("Navigate to new window for second course.........");
		for (String windowHandle : driver.getWindowHandles()) {
		    if((!hp.originalWindow.equals(windowHandle)) && (!firstWindow.equals(windowHandle))) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
	}

	@Then("add second course data to excel")
	public void add_second_course_data_to_excel() {
		BaseClass.getLogger().info("Store second course data into excel sheet.........");
		for(int i=1;i<=3;i++) {
			   excel.writeData(dataPath,"Sheet1", i, 2, data[i-1]);
			}
	}


}
