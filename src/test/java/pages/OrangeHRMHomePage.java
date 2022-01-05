package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {

    private final By welcomeDropDownList = By.xpath("//a[@id='welcome']");
    private final By logoutMenu = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() throws Exception {
        click(welcomeDropDownList, WaitStrategy.PRESENCE, welcomeDropDownList.getClass().getName());
        return this;
    }

    public OrangeHRMLoginPage clickLogout() throws Exception {
        click(logoutMenu, WaitStrategy.CLICKABLE, logoutMenu.getClass().getName());
        return new OrangeHRMLoginPage();
    }
}
