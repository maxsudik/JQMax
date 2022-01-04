package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import reports.ExtentLogger;

public final class OrangeHRMLoginPage extends BasePage {

    private final By usernameField = By.xpath("//input[@id='txtUsername']");
    private final By passwordField = By.xpath("//input[@id='txtPassword']");
    private final By loginButton = By.xpath("//input[@id='btnLogin']");


    public OrangeHRMLoginPage enterUserName(String username) {
        sendKeys(usernameField, username, WaitStrategy.PRESENCE, usernameField.getClass().getName());
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(passwordField, password, WaitStrategy.PRESENCE, passwordField.getClass().getName());
        return this;
    }

    public OrangeHRMHomePage clickLoginButton() {
        click(loginButton, WaitStrategy.PRESENCE, loginButton.getClass().getName());
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
