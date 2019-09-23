package utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    Properties properties = new Properties();
    InputStream inputStream = null;

    public PropertyReader() {
        loadProperties();
    }
    private void loadProperties() {
        try {
            String env = System.getProperty("env");
            System.out.println("ENV: " + env);
            System.out.println("ContentType: " + System.getProperty("contentType"));

            if (null == env) env = "local";

            String propertiesFilePath = env + ".properties";
            InputStream inputStream =
                    this
                    .getClass()
                    .getClassLoader()
                    .getResourceAsStream(propertiesFilePath);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }
    public String getAddressUrl() {
        return properties.getProperty("addressUrl");
    }
}


