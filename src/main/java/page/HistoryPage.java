package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage {

    public static final String EXPECTED_TITLE = "Parking Lot: History";

    private final WebDriver driver;
    private static final By BY_TITLE = By.id("title");

    public HistoryPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){

        return driver.findElement(BY_TITLE).getText();
    }
}
