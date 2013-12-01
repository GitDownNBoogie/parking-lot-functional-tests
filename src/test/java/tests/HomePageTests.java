package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import page.HistoryPage;
import page.HomePage;

import static org.fest.assertions.api.Assertions.assertThat;

public class HomePageTests extends FunctionalTest{

    private HomePage homePage;

    @Before
    public void setUp(){
        homePage = new HomePage(driver);
    }

    @Test
    public void companyNameIsCorrect(){

      assertThat(homePage.getCompanyName()).isEqualTo(HomePage.EXPECTED_COMPANY_NAME);
    }

    @Test
    public void welcomeMessageIsCorrect(){

        assertThat(homePage.getWelcomeMessage()).isEqualTo(HomePage.EXPECTED_WELCOME_MESSAGE);
    }

    @Test
    public void longHistoryHasSuccessOption(){

        assertThat(homePage.hasLongHistorySuccessOption()).overridingErrorMessage("Success option not found!!!");
    }

    @Test
    public void getHistoryPage(){

        HistoryPage historyPage = homePage.clickQuickHistory();
        assertThat(historyPage.getTitle()).isEqualTo(HistoryPage.EXPECTED_TITLE);
    }

    @Test(expected = NoSuchElementException.class)
    public void lookForSomethingNotOnPage(){

        homePage.lookForElementNotOnPage();
    }
}
