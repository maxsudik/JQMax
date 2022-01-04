package constants;

public final class FrameworkConstants {

    private static final String RESOURCE_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIG_FILE_PATH = RESOURCE_FILE_PATH + "/config/config.properties";
    private static final String JSON_CONFIG_FILE_PATH = RESOURCE_FILE_PATH + "/config/config.json";
    private static final int EXPLICIT_WAIT = 10;


    private FrameworkConstants() {
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
}
