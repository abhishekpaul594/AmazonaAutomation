package methods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.*;

public class StepDefinition {
    protected static WebDriver driver;
    private WebElement elem;

    private Map<String, String> storeCapturedValue = new HashMap<>();
    private List<WebElement> elementList = new ArrayList<>();
    private String mainWindow = "";
    ReusableMethods predef = new ReusableMethods();

    public StepDefinition() {
        this.driver = DriverUtil.getDefaultDriver();
    }
    @Given("^I navigate to Home page$")
    public void navigate_to() throws FileNotFoundException {
        String url = "";
        String environment = GlobalProperties.getConfigProperties().getProperty("environment");
        String filePath = Constants.ENVIRONMENT;
        Map<String, String> envData = new YAMLReader(filePath).getYmlData();
        url = envData.get(environment);
        driver.get(url);
        predef.waitPageLoad();
        System.out.println("Home page opened");
    }

    @Then("^I click on element (.+)$")
    public void clickElement(String element) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        elem = predef.findElement(element);
        DriverUtil.waitForJqueryJsToLoad();
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
        DriverUtil.waitForJqueryJsToLoad();
        predef.waitPageLoad();
        System.out.println("Clicked on element "+element);
    }
    @Then("^I validate element (.+)$")
    public void validateElement(String element) throws Exception {
        elem = predef.findElement(element);
        if (!elem.isEnabled())
            throw new Exception("Element not found");
        System.out.println("Validated element "+element);
    }

    @And("^I log (.+) list element text in console")
    public void logTextListElement(String element){
        elementList=predef.findElements(element);
        System.out.println("Logging element text "+element);
        for(int i=0;i< elementList.size();i++)
            System.out.println(elementList.get(i).getText());
    }
    @And("^I switch to child window (.+)$")
    public void switchToChildWindow(int n) {
        int count = 0;
        int flag = 0;
        mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> windowIterator = windows.iterator();
        windowIterator.next();
        while (windowIterator.hasNext()) {
            String childWindow = windowIterator.next();
            if (!childWindow.equalsIgnoreCase(mainWindow)) {
                count++;
                if (count == n) {
                    driver.switchTo().window(childWindow);
                    flag = 1;
                    break;
                }
            }
            System.out.println("Switched to child window "+n);
        }
        if (flag == 0)
            System.out.println("Child window " + n + " not found");
    }
}
