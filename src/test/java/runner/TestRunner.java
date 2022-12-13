package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import methods.DriverUtil;
import methods.PageObjectGenerator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;

@CucumberOptions(tags="@test",
        features = {"src/test/resources/features"},
        glue={"methods"},
        plugin = {"pretty","html:target/cucumberHtmlReport.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        PageObjectGenerator.getPageObject();
    }

    @AfterClass
    public static void destroy() {
        DriverUtil.closeDriver();
    }
}
