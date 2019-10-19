package utils;

import entities.CreateAddressRequest;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

import static java.util.Arrays.asList;

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
    @DataProvider
    public static Iterator<Object[]> nameTestData2() {
        return asList(
                new Object[]{new CreateAddressRequest("Alice", "Smith")},
                new Object[]{ new CreateAddressRequest("John", "Singh")},
                new Object[]{new CreateAddressRequest("Sam", "Raj")},
                new Object[]{ new CreateAddressRequest("Mary", "Ali")}
        ).iterator();
    }
}
