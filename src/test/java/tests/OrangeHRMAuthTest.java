package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import reports.ExtentReport;

public final class OrangeHRMAuthTest extends BaseTest {

    private OrangeHRMAuthTest() {
    }

    @Test(dataProvider = "LoginTestDataProvider")
    public void loginTest(String username, String password) {
        ExtentReport.createTest("loginTest");
        String title = new OrangeHRMLoginPage()
                .enterUserName(username).enterPassword(password).clickLoginButton()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }

    @DataProvider(name = "LoginTestDataProvider", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"Admin", "admin123"},
                {"Admin123", "admin1234"}
        };
    }
}
