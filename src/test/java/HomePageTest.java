import base.BaseTest;
import model.LandingPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseTest {

    @Test
    public void basePageNavigation() throws IOException {
        driver = initializeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLinkABTesting().click();
    }
}
