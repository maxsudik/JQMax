package tests;

import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class BaseTest {

    protected BaseTest() {
    }

    @BeforeMethod
    protected void setUp(Object[] data) throws Exception {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initializeDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

    public String getScreenshot(String testMethodName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/reports/" + testMethodName + ".png";
        FileUtils.copyFile(file, new File(destinationFile));
        return destinationFile;
    }
}
