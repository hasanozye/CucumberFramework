package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        features = {"src/test/resources/features/Wishlist.feature"},
        glue = {"stepdefs"},
        tags = "@tc3",
        plugin = {"pretty",
                "json:test-output/cucumber-reports/cucumber.json",
                "html:test-output/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunnerLogin extends AbstractTestNGCucumberTests {


}
