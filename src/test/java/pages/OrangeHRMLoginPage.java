package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import reports.ExtentManager;

public final class OrangeHRMLoginPage extends BasePage {

    private final By usernameField = By.xpath("//input[@id='txtUsername']");
    private final By passwordField = By.xpath("//input[@id='txtPassword']");
    private final By loginButton = By.xpath("//input[@id='btnLogin']");


    public OrangeHRMLoginPage enterUserName(String username) {
        sendKeys(usernameField, username, WaitStrategy.PRESENCE);
        ExtentManager.getExtentTest().pass("entered username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(passwordField, password, WaitStrategy.PRESENCE);
        ExtentManager.getExtentTest().pass("entered password");
        return this;
    }

    public OrangeHRMHomePage clickLoginButton() {
        click(loginButton, WaitStrategy.PRESENCE);
        ExtentManager.getExtentTest().pass("clicked login button");
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
