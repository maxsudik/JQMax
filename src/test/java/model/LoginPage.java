package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    private By fieldUserName = By.xpath("//input[@name='username']");
    private By fieldPassword = By.xpath("//input[@name='password']");
    private By buttonLogin = By.xpath("//button[@class='radius']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFieldUserName() {
        return driver.findElement(fieldUserName);
    }

    public WebElement getFieldPassword() {
        return driver.findElement(fieldPassword);
    }

    public WebElement getButtonLogin() {
        return driver.findElement(buttonLogin);
    }
}
