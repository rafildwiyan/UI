package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/java/features/"},
        tags= ("@Register or @Login"),
        glue= {"steps"},
        plugin = { "json:target/cucumber.json","pretty" }


)
public class TestRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
