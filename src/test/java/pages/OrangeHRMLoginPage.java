package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {

    private final By usernameField = By.xpath("//input[@id='txtUsername']");
    private final By passwordField = By.xpath("//input[@id='txtPassword']");
    private final By loginButton = By.xpath("//input[@id='btnLogin']");


    public OrangeHRMLoginPage enterUserName(String username) {
        sendKeys(usernameField, username, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(passwordField, password, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeHRMHomePage clickLoginButton() {
        click(loginButton, WaitStrategy.PRESENCE);
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
