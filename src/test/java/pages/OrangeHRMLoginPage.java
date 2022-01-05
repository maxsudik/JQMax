package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {

    private final By usernameField = By.xpath("//input[@id='txtUsername']");
    private final By passwordField = By.xpath("//input[@id='txtPassword']");
    private final By loginButton = By.xpath("//input[@id='btnLogin']");


    public OrangeHRMLoginPage enterUserName(String username) throws Exception {
        sendKeys(usernameField, username, WaitStrategy.PRESENCE, usernameField.getClass().getName());
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) throws Exception {
        sendKeys(passwordField, password, WaitStrategy.PRESENCE, passwordField.getClass().getName());
        return this;
    }

    public OrangeHRMHomePage clickLoginButton() throws Exception {
        click(loginButton, WaitStrategy.PRESENCE, loginButton.getClass().getName());
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
