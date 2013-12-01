package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    public static final String EXPECTED_COMPANY_NAME = "Parking Lot";
    public static final String EXPECTED_WELCOME_MESSAGE = "Welcome to Parking Lot";
    public static final String EXPECTED_NONEXISTENT_MESSAGE = "blah's value";
    public static final String EXPECTED_LONG_HISTORY_SUCCESS_VALUE = "success";

    private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);
    private final WebDriver driver;
    private static final String BASE_URL = "http://localhost:3000";

    private static final String VALUE = "value";
    private static final By BY_COMPANY_NAME = By.id("companyName");
    private static final By BY_WELCOME_MESSAGE = By.id("welcomeMessage");
    private static final By BY_DOES_NOT_EXIST = By.id("blahsId");
    private static final By BY_LONG_HISTORY = By.id("longHistory");
    private static final By BY_LONG_HISTORY_OPTIONS = By.id("longHistoryOptions");
    private static final By BY_QUICK_HISTORY = By.id("quickHistory");

    private static final String MSG_GETTING_COMPANY_NAME = "Getting company name from home page.";

    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.get(BASE_URL);
    }

    public String getCompanyName(){

        LOG.debug(MSG_GETTING_COMPANY_NAME);
        return driver.findElement(BY_COMPANY_NAME).getText();
    }

    public String getWelcomeMessage() {
        return driver.findElement(BY_WELCOME_MESSAGE).getText();
    }

    public WebElement lookForElementNotOnPage(){

        return driver.findElement(BY_DOES_NOT_EXIST);
    }

    public HistoryPage clickQuickHistory(){

        driver.findElement(BY_QUICK_HISTORY).click();
        return new HistoryPage(driver);
    }

    public boolean hasLongHistorySuccessOption(){

        boolean found = false;

        driver.findElement(BY_LONG_HISTORY).click();

        //simpleWaitLongHistoryOpts();
        fluentWaitLongHistoryOpts();

        List<WebElement> options = driver.findElement(BY_LONG_HISTORY_OPTIONS).findElements(By.tagName("option"));

        for(WebElement option : options){

            String value = option.getAttribute(VALUE);
            LOG.debug("Value: {}", value);

            if(value.equals(EXPECTED_LONG_HISTORY_SUCCESS_VALUE)){
                found = true;
            }
        }
        return found;
    }

    // Default polling = 500ms
    private void simpleWaitLongHistoryOpts(){

        WebElement longHistoryOptions = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(BY_LONG_HISTORY_OPTIONS));
    }

    private void fluentWaitLongHistoryOpts(){

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(BY_LONG_HISTORY_OPTIONS));
    }
}
