package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import reports.ExtentManager;

public final class OrangeHRMHomePage extends BasePage {

    private final By welcomeDropDownList = By.xpath("//a[@id='welcome']");
    private final By logoutMenu = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() {
        click(welcomeDropDownList, WaitStrategy.PRESENCE);
        ExtentManager.getExtentTest().pass("welcome button clicked");
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        click(logoutMenu, WaitStrategy.CLICKABLE);
        ExtentManager.getExtentTest().pass("logout button clicked");
        return new OrangeHRMLoginPage();
    }
}
