package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;
import utils.DataProviderUtils;

import java.util.Map;

public final class OrangeHRMAuthExcelDataFetchTest extends BaseTest {

    private OrangeHRMAuthExcelDataFetchTest() {
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void loginTestUsingExcelData(Map<String,String> data) throws Exception {
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void newTestUsingExcelData(Map<String,String> data) throws Exception {
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
                .clickWelcome().clickLogout()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("OrangeHRM");
    }
}