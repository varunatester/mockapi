package utils;

import org.testng.annotations.DataProvider;

public class NameTestData {
    @DataProvider
    public static Object[][] nameTestData() {
        return new Object[][]{
                {"Alice", "Smith"},
                {"John", "Singh"},
                {"Sam", "Raj"},
                {"Mary", "Lu"}
        };
    }
}
