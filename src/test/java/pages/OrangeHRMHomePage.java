package pages;

import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {

    private final By welcomeDropDownList = By.xpath("//a[@id='welcome']");
    private final By logoutMenu = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickWelcome() {
        click(welcomeDropDownList, "present");
        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        click(logoutMenu, "clickable");
        return new OrangeHRMLoginPage();
    }
}
