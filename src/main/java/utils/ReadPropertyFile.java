package utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private ReadPropertyFile() {
    }

    public static String getValue(String key) throws Exception {
        String value = "";
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/local.properties");
        property.load(fileInputStream);
        value = property.getProperty(key);
        if (Objects.isNull(value)) {
            throw new Exception("Property name " + key + " is not found. Please check local.properties");
        }
        return property.getProperty(key);
    }
}
