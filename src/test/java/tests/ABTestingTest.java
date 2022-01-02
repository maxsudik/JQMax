package tests;

import driver.Driver;
import model.ABTestingPage;
import model.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class ABTestingTest extends BaseTest{

    private final String expectedTitle = "A/B Test Variation 1";
    private final String expectedPageText = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";

    private ABTestingTest() {
    }

    @Test
    public void verifyABTestPageTitle() {
        LandingPage landingPage = new LandingPage(Driver.driver);
        ABTestingPage abTestingPage = new ABTestingPage(Driver.driver);

        landingPage.getLinkABTesting().click();
        String abTestPageTitle = abTestingPage.getABTestPageTitle().getText();
        Assert.assertEquals(abTestPageTitle, expectedTitle);
    }

    @Test
    public void verifyABTestPageText() {
        LandingPage landingPage = new LandingPage(Driver.driver);
        ABTestingPage abTestingPage = new ABTestingPage(Driver.driver);

        landingPage.getLinkABTesting().click();
        String abTestPageText = abTestingPage.getABTestPageText().getText();
        Assert.assertEquals(abTestPageText, expectedPageText);
    }
}
