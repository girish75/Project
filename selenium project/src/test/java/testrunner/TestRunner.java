package testrunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features",
glue = {"stepdefination","hooks"},
monochrome = true,
dryRun = false,
//tags = {"@Regression","@Smoke"},  //Tags using AND Condition
//tags = {"@Regression,@Smoke"}, //Tags using OR condition
//tags = {"~@Regression"},  //Skips the Tag
plugin = {"pretty","html:reports/htmlreport","json:reports/jsonreport.json","junit:reports/xmlreport.xml"})


public class TestRunner {

}
