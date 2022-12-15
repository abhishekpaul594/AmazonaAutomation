package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import methods.DriverUtil;
import methods.PageObjectGenerator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

@CucumberOptions(tags = "@test",
        features = {"src/test/resources/features"},
        glue = {"methods"},
        plugin = {"pretty", "html:target/cucumberHtmlReport.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        PageObjectGenerator.getPageObject();
    }


    @AfterClass
    public static void destroy() throws MalformedURLException {
        System.out.println("After executed");
        WebDriver driver=DriverUtil.getDefaultDriver();
        DriverUtil.closeDriver();
    }
}
