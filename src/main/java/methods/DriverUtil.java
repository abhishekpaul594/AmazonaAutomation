package methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import static methods.Constants.*;
import static methods.GlobalProperties.getConfigProperties;

public class DriverUtil {
    private static WebDriver driver;
    private static GlobalProperties configProperties = getConfigProperties();

    //Initialize proper chrome driver in WebDriver object
    public static WebDriver getDefaultDriver() throws MalformedURLException {
        if (driver != null && ((RemoteWebDriver) driver).getSessionId() != null)
            return driver;
        driver = chooseDriver();
        return driver;
    }

    //Choosing appropriate chrome driver
    private static WebDriver chooseDriver() throws MalformedURLException {
        if (configProperties.getProperty("grid").equalsIgnoreCase("true")) {
            System.out.println("======Before driver created======");
            String hubURL = configProperties.getProperty("hub");
            ChromeOptions options = new ChromeOptions();
            if (configProperties.getProperty(HEADLESS).equalsIgnoreCase("true")) {
                options.addArguments("--headless");
            }
            options.addArguments("start-maximized");
            driver = new RemoteWebDriver(new URL(hubURL), options);
            System.out.println("======After driver created======");
        } else {
            driver = null;
            System.out.println("======Before driver created======");
            ChromeOptions chromeOptions = new ChromeOptions();
            if (configProperties.getProperty(HEADLESS).equalsIgnoreCase("true")) {
                chromeOptions.addArguments("--headless");
            }
            chromeOptions.addArguments("start-maximized");
            chromeOptions.setExperimentalOption("excludeSwitches",
                    Collections.singletonList("enable-automation"));
            String os = System.getProperty("os.name");
            if (os.indexOf("win") >= 0) {
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH_WIN);
            } else if (os.indexOf("mac") >= 0) {
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH_MAC);
            } else if (os.indexOf("nux") >= 0) {
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH_LIN);
            }
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("########## After driver created ########");
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    //Wait until jquery js load completes
    public static boolean waitForJqueryJsToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExpectedCondition<Boolean> jqueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    return ((boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0;"));
                } catch (Exception e) {
                    return true;
                } finally {

                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                } catch (Exception e) {
                    return true;
                } finally {

                }
            }
        };
        return wait.until(jqueryLoad) && wait.until(jsLoad);
    }
}
