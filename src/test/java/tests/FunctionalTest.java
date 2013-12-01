package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public abstract class FunctionalTest {

    private static final Logger LOG = LoggerFactory.getLogger(FunctionalTest.class);
    public static ChromeDriver driver;

    public FunctionalTest(){
    }

    @BeforeClass
    public static void createDriver(){
        LOG.debug("Instantiating new driver.");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void closeDriver(){
        LOG.debug("Closing driver.");
        driver.close();
    }
}
