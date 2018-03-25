package ebay.qa.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
plugin = {"json:build/cucumber.json"},
features = "features",
glue= {"stepDefinitions"},
dryRun=false,
strict = true
)

public class TestRunner {
	
}
