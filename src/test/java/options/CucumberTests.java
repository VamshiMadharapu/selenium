package options;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"json:build/reports/json/testresult.json",
				"junit:target/junit/cucumber.xml"
		},
		glue = {"stepdefs"},
		tags = {"@Smoke"},
		features = {"src/test/features"})
public class CucumberTests {

}


