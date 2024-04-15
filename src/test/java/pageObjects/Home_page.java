package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	
	public WebDriver driver;
	 public String originalWindow;
	 public String firstWindow;
	 
	 JavascriptExecutor js;
	public Home_page(WebDriver driver) {

		this.driver = driver;
		 js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
		originalWindow = driver.getWindowHandle();
	}
	
	
	
	@FindBy(xpath="//input[@role='textbox']")
	public WebElement searchBox;
	
	@FindBy(xpath="//form[@role='search']//button[@aria-label='Submit Search'][2]")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Language']//span[text()='English']")
	public WebElement englishLanguage;
	
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Level']//span[text()='Beginner']")
	public WebElement beginnerLevel;
	
	
	@FindBy(xpath="//ul[contains(@class,'css-reop')]/li[1]//div[@class='cds-ProductCard-header']/div[2]/a")
			//ul[contains(@class,'css-reop')]/li[1]//div[@class='cds-ProductCard-header']//a")
	public WebElement firstCourse;
	
	@FindBy(xpath="//ul[contains(@class,'css-reop')]/li[2]//div[@class='cds-ProductCard-header']//a")
	public WebElement secondCourse;
	
	@FindBy(xpath="//div[@data-e2e='key-information']//div[contains(@class,'css-guxf')]/div[contains(@class,'Typography')]")
	public WebElement rating1;
	
	@FindBy(xpath="//div[@data-track-component='syllabus']/div/div//span[contains(text(),'hour')]")
	public List<WebElement> hours;
	
	@FindBy(xpath="//h1[@data-e2e='hero-title']")
	public WebElement name;
	
	
	
	@FindBy(xpath="//div[@id='MegamenuWrapperDiv']//span[text()='Explore']")
	public WebElement explore;
	
	@FindBy(xpath="//ul[@class='css-aezbxk']//span[text()='Language Learning']")
	public WebElement language_learning;
	
	@FindBy(xpath="//a[text()='All Language Courses']")
	public WebElement all_langs_courses;
	
	@FindBy(xpath="//h2[contains(text(),'Build Essential')]")
	public WebElement languagePage;
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Language']//span[text()='Show more']")
	public WebElement show_more_button;
	
	
	@FindBy(xpath="//div[@id='checkbox-group']//div[@class='css-zweepb']//span[contains(@class,'labelContent')]/span")
	public List<WebElement> langs;
	
	@FindBy(xpath="//div[@role='dialog']//span[text()='Close']")
	public WebElement close;
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Level']//span[contains(@class,'labelContent')]/span")
	public List<WebElement> levels;
	
	public void enter_text_in_SearchBox(String course) {
		searchBox.sendKeys(course);
		js.executeScript("arguments[0].click()",searchButton);
		//searchButton.click();
	}
	
	public void select_English_Language() {
		//englishLanguage.click();
		js.executeScript("arguments[0].click()",englishLanguage);
	}
	
	public void select_Beginner_Level() {
		//beginnerLevel.click();
		js.executeScript("arguments[0].click()",beginnerLevel);
	}
	
	
	public void click_On_First_Course() {
		
		
		
		//firstCourse.click();
		js.executeScript("arguments[0].click()",firstCourse);
//		for (String windowHandle : driver.getWindowHandles()) {
//		    if(!originalWindow.equals(windowHandle)) {
//		        driver.switchTo().window(windowHandle);
//		        firstWindow=driver.getWindowHandle();
//		        break;
//		    }
//		}
		
		
	}
	
	
	
	public void click_On_second_Course() {
	
		js.executeScript("arguments[0].click()",secondCourse);
//		for (String windowHandle : driver.getWindowHandles()) {
//		    if((!originalWindow.equals(windowHandle)) && (!firstWindow.equals(windowHandle))) {
//		        driver.switchTo().window(windowHandle);
//		        break;
//		    }
//		}
	}
	
	public String[] collect_details() {
		String[] data=new String[3];
		int totalhrs=0;
		String nm=name.getText();
       String  rating=rating1.getText();
        
        for(WebElement h:hours) {
       	 js.executeScript("arguments[0].scrollIntoView();",h);
       	String hr= h.getText();
       	String[] s=hr.split(" ");
       	totalhrs=totalhrs+Integer.parseInt(s[0]);
        }
        data[0]=nm;
        data[1]=rating;
        data[2]=String.valueOf(totalhrs);
       System.out.println(nm);
       System.out.println(rating);
       System.out.println(totalhrs);
       return data;
	}
	
	
//	public void click_on_show_more() {
//	
//		js.executeScript("arguments[0].click()",show_more_button);
//		
//	}
	
	public void display_languages() {
		Actions act=new Actions(driver);
		act.moveToElement(explore);
		act.moveToElement(language_learning);
		//js.executeScript("arguments[0].click()",explore);
		//js.executeScript("arguments[0].click()",language_learning);
		js.executeScript("arguments[0].click()",all_langs_courses);
		js.executeScript("arguments[0].click()",show_more_button);
		
		int cnt =langs.size();
		System.out.println(cnt);
		for(WebElement l:langs) {
			System.out.println(l.getText());
		}
		js.executeScript("arguments[0].click()",close);
	}
	
	public void go_to_explore() {
		Actions act=new Actions(driver);
		act.moveToElement(explore);
	}
	
	public void go_to_language_learning() {
		Actions act=new Actions(driver);
		act.moveToElement(language_learning);
		
	}
	
	public void click_on_all_langs_courses() {
		js.executeScript("arguments[0].click()",all_langs_courses);
	}
	
	public String get_Language_Page_heading() {
		String heading=languagePage.getText();
		return heading;
	}
	
	public void click_on_show_more_button() {
		js.executeScript("arguments[0].click()",show_more_button);
	}
	public void click_On_close() {
		js.executeScript("arguments[0].click()",close);
	}
	
	public void display_levels() {
		int cnt =levels.size();
		System.out.println(cnt);
		for(WebElement l:levels) {
			System.out.println(l.getText());
		}
	}
	
	
	
	
	

}
