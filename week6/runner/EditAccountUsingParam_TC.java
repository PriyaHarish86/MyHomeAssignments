package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/SalesforceUsingParameterization.feature", glue="stepDefinition1", monochrome=true, publish = false)

public class EditAccountUsingParam_TC extends AbstractTestNGCucumberTests{

}
