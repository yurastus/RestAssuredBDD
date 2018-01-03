package tools;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROP_FILE = "/API.properties";
    private static Properties properties;

    static {
        properties = new Properties();

        try {
            properties.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyLoader(){}

    public static String load(String name) {
        return properties.getProperty(name);
    }

}