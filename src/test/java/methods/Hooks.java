package methods;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import methods.DriverUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.TestRunner;

import java.net.MalformedURLException;

public class Hooks{

    @After
    public void beforeScript(Scenario scenario) throws MalformedURLException {
        WebDriver driver=DriverUtil.getDefaultDriver();
        if (scenario.isFailed()) {
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "Failed Screen");
        }
    }

}
