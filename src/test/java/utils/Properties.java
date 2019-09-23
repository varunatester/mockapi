package utils;

/**
 * Created by varuna on 8/20/19.
 */
public class Properties {
    private static final PropertyReader propertiesReader = new PropertyReader();
    public static final String addressUrl = propertiesReader.getAddressUrl();
}

