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

public class BaseTest {

    protected BaseTest() {

    }

    @BeforeMethod
    public void setUp() throws IOException {
        Driver.initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
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
