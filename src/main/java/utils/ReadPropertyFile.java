package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

    private static final Map<String, String> CONFIG_MAP = new HashMap<>();
    private static Properties property = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/local.properties");
            property.load(fileInputStream);

            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ReadPropertyFile() {
    }

    /**
     * Use this method for retrieving large numbers of values from .property file
     *
     * @param key from .property file
     * @return CONFIG_MAP of keys and values from .property file
     * @throws Exception
     */

    public static String get(String key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key))) {
            throw new Exception("Property name " + key + " is not found. Please check local.properties");
        }
        return CONFIG_MAP.get(key);
    }

    /**
     * Use this method for retrieving small numbers of values from .property file
     *
     * @param key from .property file
     * @return CONFIG_MAP of keys and values from .property file
     * @throws Exception
     */
    public static String getValue(String key) throws Exception {
        if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
            throw new Exception("Property name " + key + " is not found. Please check local.properties");
        }
        return property.getProperty(key);
    }
}
