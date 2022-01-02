package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ABTestingPage {

    public WebDriver driver;

    private By pageTitle = By.xpath("//h3[text()='A/B Test Variation 1']");
    private By pageText = By.xpath("//p");

    public ABTestingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getABTestPageTitle() {
        return driver.findElement(pageTitle);
    }

    public WebElement getABTestPageText() {
        return driver.findElement(pageText);
    }
}
