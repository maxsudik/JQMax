package pages;

import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {

    private final By usernameField = By.xpath("//input[@id='txtUsername']");
    private final By passwordField = By.xpath("//input[@id='txtPassword']");
    private final By loginButton = By.xpath("//input[@id='btnLogin']");


    public OrangeHRMLoginPage enterUserName(String username) {
        sendKeys(usernameField, username, "present");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(passwordField, password, "present");
        return this;
    }

    public OrangeHRMHomePage clickLoginButton() {
        click(loginButton, "present");
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
