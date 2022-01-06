package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;
import enums.ConfigProperties;
import exceptions.JsonFileUsageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class JsonUtils {

    private static Map<String, String> CONFIG_MAP;

    static {
        try {
            CONFIG_MAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonConfigFilePath()),
                    new TypeReference<HashMap<String, String>>() {
                    });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JsonUtils() {
    }

    public static String get(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase(Locale.ROOT)))) {
            throw new JsonFileUsageException("Property name " + key + " is not found. Please check config.properties");
        }
        return CONFIG_MAP.get(key.name().toLowerCase(Locale.ROOT));
    }
}