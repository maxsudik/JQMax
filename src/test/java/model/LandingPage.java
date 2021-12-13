package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    private By linkABTesting = By.xpath("//a[@href='/abtest']");
    private By linkFormAuthentication = By.xpath("//a[@href='/login']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLinkABTesting() {
        return driver.findElement(linkABTesting);
    }

    public WebElement getLinkFormAuthentication(){
        return driver.findElement(linkFormAuthentication);
    }
}
