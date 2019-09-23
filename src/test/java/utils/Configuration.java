package utils;

/**
 * Created by varuna on 8/20/19.
 */
public class Configuration {
    private final PropertyReader propertiesReader;

    private static Configuration configuration;

    private Configuration() {
        propertiesReader = new PropertyReader();
    }

    public static synchronized Configuration getConfiguration() {
        if (configuration == null)
            configuration = new Configuration();
        return configuration;
    }

    public String getAddressUrl() {
        return propertiesReader.getAddressUrl();
    }
}

