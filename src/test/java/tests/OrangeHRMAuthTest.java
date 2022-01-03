package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

public final class OrangeHRMAuthTest extends BaseTest {

    private OrangeHRMAuthTest() {
    }

    @Test
    public void loginTest() {
        String title = new OrangeHRMLoginPage()
                .enterUserName("Admin").enterPassword("admin123").clickLoginButton()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }
}
