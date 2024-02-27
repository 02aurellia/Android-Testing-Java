package cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "/Android-Testing-Java/demo/src/test/java/cucumber/features",
    glue = "cucumber.StepPOM",
    tags = "@All",
    plugin = {"html:target/HTML_report.html"}
)

public class runner {
    
}
