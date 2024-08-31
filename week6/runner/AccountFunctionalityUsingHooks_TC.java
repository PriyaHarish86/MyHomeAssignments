package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/LeafTapsAppForAccountMod.feature", 
glue={"stepDefinition", "hooks"},
monochrome=true, publish = true, tags="@CreateAccount or @EditAccount or @DeleteAccount")

public class AccountFunctionalityUsingHooks_TC extends AbstractTestNGCucumberTests {

}
