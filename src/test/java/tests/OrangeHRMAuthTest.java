package tests;

import listeners.RetryFailedTests;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

public final class OrangeHRMAuthTest extends BaseTest {

    private OrangeHRMAuthTest() {
    }

    @DataProvider(name = "LoginTestDataProvider", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"Admin", "admin123"},
                {"Admin123", "admin1234"}
        };
    }

    @Test(dataProvider = "LoginTestDataProvider", retryAnalyzer = RetryFailedTests.class)
    public void loginTest(String username, String password) throws Exception {
        String title = new OrangeHRMLoginPage()
                .enterUserName(username).enterPassword(password).clickLoginButton()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }

    @Test(dataProvider = "LoginTestDataProvider", retryAnalyzer = RetryFailedTests.class)
    public void newTest(String username, String password) throws Exception {
        String title = new OrangeHRMLoginPage()
                .enterUserName(username).enterPassword(password).clickLoginButton()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }
}
