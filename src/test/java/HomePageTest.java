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

    @Test
    public void basePageNavigation() throws IOException {

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        landingPage.getLinkFormAuthentication().click();
        loginPage.getFieldUserName().sendKeys("tomsmith");
        loginPage.getFieldPassword().sendKeys("SuperSecretPassword!");
        loginPage.getButtonLogin().click();
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Welcome to the Secure Area. When you are done click logout below.']")).isDisplayed());
        log.info("Test validation is completed");
    }
}
