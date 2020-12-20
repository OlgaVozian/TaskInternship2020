package cucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        glue = {"cucumberSteps"},//Step definitions packages , "com.example.cucumber.config"
        features = {"src/test/java/resources/features"},//feature file directory
        tags = "@Run" //Tags
)
public class CucumberRunner {

}

