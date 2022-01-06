package tests;

import annotations.FrameworkAnnotation;
import enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

import java.util.Map;

public final class OrangeHRMAuthExcelDataFetchTest extends BaseTest {

    private OrangeHRMAuthExcelDataFetchTest() {
    }

    @FrameworkAnnotation(author = {"Max Sudik", "John Doe"}, category = CategoryType.SMOKE)
    @Test
    public void loginTestUsingExcelData(Map<String, String> data) {
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }

    @FrameworkAnnotation(author = "John Doe", category = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test
    public void newTestUsingExcelData(Map<String, String> data) {
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }
}