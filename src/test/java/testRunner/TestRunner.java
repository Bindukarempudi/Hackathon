package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features/"},

		glue="stepDefinitions",
		plugin= {"pretty","html:reports/myreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt"
		},
		dryRun=false,
		monochrome=true,
		publish=true
				
		)
public class TestRunner extends AbstractTestNGCucumberTests
 {

}
