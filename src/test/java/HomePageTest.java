import base.BaseTest;
import model.LandingPage;
import model.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class HomePageTest extends BaseTest {


    @Test
    public void basePageNavigation() throws IOException {

        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        landingPage.getLinkFormAuthentication().click();
        loginPage.getFieldUserName().sendKeys("tomsmith");
        loginPage.getFieldPassword().sendKeys("SuperSecretPassword!");
        loginPage.getButtonLogin().click();
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Welcome to the Secure Area. When you are done click logout below.']")).isDisplayed());
        //log.info("Test validation is completed");
    }
}
