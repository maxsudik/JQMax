package tests;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class ABTestingTest extends BaseTest {

    private ABTestingTest() {
    }

    @Test
    public void verifyABTestPageTitle() {
        DriverManager.getDriver().findElement(By.xpath("//a[@href='/abtest']")).click();
        String abTestPageTitle = DriverManager.getDriver().findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(abTestPageTitle, "A/B Test Variation 1");
    }

    @Test
    public void verifyABTestPageText() {
        DriverManager.getDriver().findElement(By.xpath("//a[@href='/abtest']")).click();
        String abTestPageText = DriverManager.getDriver().findElement(By.xpath("//p")).getText();
        Assert.assertEquals(abTestPageText, "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).");
    }
}
