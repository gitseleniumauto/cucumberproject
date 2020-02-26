package runners;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//Online project : https://github.com/midmihua/CucumberToolsQa

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue = "stepDefinitions",
        // plugin = { "pretty" },
        // plugin = { "usage" },
        // plugin = { "pretty", "html:target/cucumber-reports" },
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports"
        },
        monochrome = true
)
public class TestRunner {
}
