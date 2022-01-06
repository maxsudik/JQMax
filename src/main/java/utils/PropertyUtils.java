package utils;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import exceptions.InvalidPathForPropertyFileException;
import exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public final class PropertyUtils {

    private static final Map<String, String> CONFIG_MAP = new HashMap<>();
    private static Properties property = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(fileInputStream);
            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
        } catch (IOException e) {
            throw new InvalidPathForPropertyFileException("Please check the path of the config file");
        }
    }

    private PropertyUtils() {
    }

    public static String get(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase(Locale.ROOT)))) {
            throw new PropertyFileUsageException("Property name " + key + " is not found. Please check config.properties");
        }
        return CONFIG_MAP.get(key.name().toLowerCase(Locale.ROOT));
    }
}
