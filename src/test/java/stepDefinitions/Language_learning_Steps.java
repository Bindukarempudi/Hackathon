package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Home_page;
import utilities.ExcelUtility;

public class Language_learning_Steps {
	  
	WebDriver driver;
	Home_page hp;
	String dataPath=System.getProperty("user.dir")+"\\testData\\Data.xlsx";
	String path=System.getProperty("user.dir")+"\\testData\\OutputData.xlsx";
	ExcelUtility excelWrite;
	ExcelUtility excelRead;
	int cnt;
	
	String data[];
	@Given("User open the application")
	public void user_open_the_application() {
		BaseClass.getLogger().info("Opened application with provided URL.........");
		driver=BaseClass.getDriver();
		hp=new Home_page(driver);
	    excelWrite=new ExcelUtility(path);
	    excelRead=new ExcelUtility(dataPath);
	}

	@When("user click on explore dropdown")
	public void user_click_on_explore_dropdown() {
	   BaseClass.getLogger().info("Clicking on explore.........");
	   hp.go_to_explore();
	}

	@When("select the language learning subject")
	public void select_the_language_learning_subject() {
		BaseClass.getLogger().info("Going to language learning subject.........");
	    hp.go_to_language_learning();
	}

	@When("select All language courses under Popular skills section")
	public void select_all_language_courses_under_Popular_skills_section() {
	   BaseClass.getLogger().info("Clicking on 'All Language Course'.........");
	   hp.click_on_all_langs_courses();
	}

	@Then("it should load a new page with all courses")
	public void it_should_load_a_new_page_with_all_courses() {
		BaseClass.getLogger().info("New page will be loaded.........");
	    String expect_heading=excelRead.getCellData("expectedData", 0, 0);
	    String actual_heading=hp.get_Language_Page_heading();
	    Assert.assertEquals(actual_heading, expect_heading);
	}

	@When("user click on show more option under language section")
	public void user_click_on_show_more_option_under_language_section() {
		BaseClass.getLogger().info("Clicking on show more button under language section.........");
	    hp.click_on_show_more_button();
	}

	@Then("all languages will be displayed,collect all languages")
	public void all_languages_will_be_displayed_collect_all_languages() {
		BaseClass.getLogger().info("Collecting all languages.........");
	    cnt=hp.langs.size();
	    System.out.println("Total languages count: "+cnt);
	    data=new String[cnt];
	    System.out.println("Language names:");
	    for(int i=0;i<cnt;i++) {
	    	String s[]=hp.langs.get(i).getText().split(" ");
	    	data[i]=s[0];
	    	System.out.println(s[0]);
	    }
	    
	    
	}

	@Then("store all languages in excel sheet")
	public void store_all_languages_in_excel_sheet() throws IOException {
		BaseClass.getLogger().info("Storing all languages in excel sheet.........");
		excelWrite.write_Data("Language&Levels",String.valueOf(cnt),1,0);
		for(int i=1;i<=cnt;i++) {
		   excelWrite.write_Data("Language&Levels",data[i-1],i,1);
		}
		
	}
	
	@When("user click on close button")
	public void user_click_on_close_button() {
		BaseClass.getLogger().info("Clicking on close button.........");
	    hp.click_On_close();
	}
	@Then("collect all levels under level section")
	public void collect_all_levels_under_level_section() {
		BaseClass.getLogger().info("Collecting all levels .........");
		cnt=hp.levels.size();
	    System.out.println("Levels count: "+cnt);
	    System.out.println("Level names:");
	    for(int i=0;i<cnt;i++) {
	    	String s[]=hp.levels.get(i).getText().split(" ");
	    	data[i]=s[0];
	    	System.out.println(s[0]);
	    }
	    
	}

	@Then("store all levels in excel sheet")
	public void store_all_levels_in_excel_sheet() throws IOException {
		BaseClass.getLogger().info("Storing all levels in excel sheet.........");
		excelWrite.write_Data("Language&Levels",String.valueOf(cnt),1,3);
		for(int i=1;i<=cnt;i++) {
		   excelWrite.write_Data("Language&Levels",data[i-1],i,2);
		}
	}


}
