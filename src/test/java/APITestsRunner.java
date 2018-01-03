import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
        glue = {"steps"}
        //,tags = "@Regression"
)
public class APITestsRunner { }