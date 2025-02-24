package runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilitities.ConfigReader;


@CucumberOptions(features = "src/test/resources/featureFiles/Home.feature",
glue = { "stepDefinitions",
		"hooks" 
		}, plugin = { "pretty", "html:src/test/resources/dsAlgoReports/cucumber-reports.html",
				"json:src/test/resources/dsAlgoReports/cucumber-reports.json", }

//				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
		//monochrome = true
		// tags = "@navigationtoprogrampage"
		 )
public class TestRunner extends AbstractTestNGCucumberTests {

//	@BeforeTest
//	@Parameters("browser")
//	public void defineBrowser(String browser) {
//		ConfigReader.setBrowserType(browser);
//	}

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
}
