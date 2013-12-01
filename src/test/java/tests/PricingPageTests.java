package tests;

import org.junit.Before;
import org.junit.Test;
import page.PricingPage;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PricingPageTests extends FunctionalTest{

    private PricingPage pricingPage;

    @Before
    public void setUp(){
        pricingPage = new PricingPage(driver);
    }

    @Test
    public void threeRateTypesAvailable(){

        assertThat(pricingPage.getRateTypes().size()).isEqualTo(3);
    }

    @Test
    public void hourDayWeekPricesAvailable(){

        List<String> rateTypes = pricingPage.getRateTypes();
        assertThat(rateTypes).containsExactly("Hour","Day","Week");
    }
}
