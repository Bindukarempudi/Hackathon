package testRunner;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features/1_courses.feature"},
	  /*features= {"@target/rerun.txt"},*/
		
		glue="stepDefinitions",
		plugin= {"pretty","html:reports/myreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt",
               
				
		},
				dryRun=false,    // checks mapping between scenario steps and step definition methods
				monochrome=true,    // to avoid junk characters in output
				publish=true   // to publish report in cucumber server
				
				
		)
public class TestRunner extends AbstractTestNGCucumberTests
 {
	

}
