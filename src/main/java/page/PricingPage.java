package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PricingPage {

    private static final Logger LOG = LoggerFactory.getLogger(PricingPage.class);
    private static final By LIST_ITEM_PRICE = By.className("price");
    private static final String BASE_URL = "http://localhost:3000/pricing";
    private final WebDriver driver;

    public PricingPage(WebDriver driver){
        this.driver = driver;
        driver.get(BASE_URL);
    }

    public List<String> getRateTypes(){

        ArrayList results = new ArrayList();
        for(WebElement priceMapping : driver.findElements(LIST_ITEM_PRICE)){

            results.add(priceMapping.getText().split(":")[0]);
        }

        return results;
    }
}
