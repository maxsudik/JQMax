package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {

    private final By welcomeDropDownList = By.xpath("//a[@id='welcome']");
    private final By logoutMenu = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() {
        click(welcomeDropDownList, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        click(logoutMenu, WaitStrategy.CLICKABLE);
        return new OrangeHRMLoginPage();
    }
}
