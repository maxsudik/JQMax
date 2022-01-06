package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import reports.ExtentLogger;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
        ExtentLogger.pass(elementName + " clicked", true);
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(value);
        ExtentLogger.pass(value + " is entered successfully in " + elementName, true);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
