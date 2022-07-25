package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "F:\\MavenProject\\Feature\\EToE.feature"
  ,glue = "stepDefinition3"
  )

public class EToETest {

}
