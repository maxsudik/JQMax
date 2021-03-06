package constants;

import enums.ConfigProperties;
import utils.PropertyUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public final class FrameworkConstants {

    private static final int EXPLICIT_WAIT = 3;
    private static final String RESOURCE_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCE_FILE_PATH + "/config/config.properties";
    private static final String JSON_CONFIG_FILE_PATH = RESOURCE_FILE_PATH + "/config/config.json";
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static final String EXCEL_PATH = RESOURCE_FILE_PATH + "/excel/testdata.xlsx";
    private static final String RUN_MANAGER_SHEET = "RUNMANAGER";
    private static final String ITERATION_DATA_SHEET = "DATA";
    private static String extentReportFilePath = "";

    private FrameworkConstants() {
    }

    public static String getRunManagerSheet() {
        return RUN_MANAGER_SHEET;
    }

    public static String getIterationDataSheet() {
        return ITERATION_DATA_SHEET;
    }

    public static String getExcelPath() {
        return EXCEL_PATH;
    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

    public static String getJsonConfigFilePath() {
        return JSON_CONFIG_FILE_PATH;
    }

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENT_REPORT_FOLDER_PATH + LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).toString().replace(":", "_") + "/index.html";
        } else {
            return EXTENT_REPORT_FOLDER_PATH + "/index.html";
        }
    }
}