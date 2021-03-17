package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(

		features = "src/test/resources/appfeatures", glue = { "stepDefinition",
				"appHooks" }, monochrome = true, strict = true, plugin = { "pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"

		},

		publish = true

)

public class MyTestRunner {

}
