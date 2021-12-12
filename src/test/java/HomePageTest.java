import base.BaseTest;
import model.LandingPage;
import model.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseTest {

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "invalidlogin@gmai.com";
        data[0][1] = "Invalid Password";

        data[1][0] = "tomsmith";
        data[1][1] = "SuperSecretPassword!";
        return data;
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String userName, String password) throws IOException {
        driver = initializeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        landingPage.getLinkFormAuthentication().click();
        loginPage.getFieldUserName().sendKeys(userName);
        loginPage.getFieldPassword().sendKeys(password);
        loginPage.getButtonLogin().click();
    }
}
