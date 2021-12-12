package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    By linkABTesting = By.xpath("//a[@href='/abtest']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLinkABTesting() {
        return driver.findElement(linkABTesting);
    }

}
