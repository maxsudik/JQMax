import base.BaseTest;
import model.LandingPage;
import model.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;


public class HomePageTest extends BaseTest {
    public static Logger log = LogManager.getLogger(BaseTest.class.getName());
    public WebDriver driver;

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][2];
        data[0][0] = "invalidlogin@gmai.com";
        data[0][1] = "Invalid Password";

        data[1][0] = "tomsmith";
        data[1][1] = "SuperSecretPassword!";
        return data;
    }

    @BeforeMethod
    public void initializeTest() throws IOException {

        driver = initializeDriver();
        driver.get(properties.getProperty("url"));
        log.info("Driver successfully initialized");
    }

    @AfterTest
    public void stopDriver() {
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String userName, String password) throws IOException {

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        landingPage.getLinkFormAuthentication().click();
        loginPage.getFieldUserName().sendKeys(userName);
        loginPage.getFieldPassword().sendKeys(password);
        loginPage.getButtonLogin().click();
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Welcome to the Secure Area. When you are done click logout below.']")).isDisplayed());
        log.info("Test validation is completed");
    }
}
