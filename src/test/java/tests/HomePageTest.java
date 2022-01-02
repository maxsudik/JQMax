package tests;

import driver.Driver;
import model.LandingPage;
import model.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public final class HomePageTest extends BaseTest {

    private HomePageTest() {
    }

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
    public void basePageNavigation(String userName, String password){

        LandingPage landingPage = new LandingPage(Driver.driver);
        LoginPage loginPage = new LoginPage(Driver.driver);

        landingPage.getLinkFormAuthentication().click();
        loginPage.getFieldUserName().sendKeys(userName);
        loginPage.getFieldPassword().sendKeys(password);
        loginPage.getButtonLogin().click();
        Assert.assertTrue(Driver.driver.findElement(By.xpath("//h4[text()='Welcome to the Secure Area. When you are done click logout below.']")).isDisplayed());
        Driver.log.info("Test validation is completed");
    }
}
