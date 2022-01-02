package tests;

import driver.Driver;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public final class HomePageTest extends BaseTest {

    private HomePageTest() {
    }

    @Test()
    public void basePageNavigation() {

        DriverManager.getDriver().findElement(By.xpath("//a[@href='/login']")).click();
        DriverManager.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        DriverManager.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
        DriverManager.getDriver().findElement(By.xpath("//button[@class='radius']")).click();
        Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//h4[text()='Welcome to the Secure Area. When you are done click logout below.']")).isDisplayed());
        Driver.log.info("Test validation is completed");
    }
}
