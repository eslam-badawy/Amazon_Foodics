package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = "Steps",
    plugin = {
        "html:target/reports/report.html"
    },
    dryRun = false
)public class TestRunner {
}