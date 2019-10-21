package tests.dataDesignPattern;
import entities.CreateAddressRequest;
import tests.AddressBaseTest;
import org.testng.annotations.Test;
import requestBuilders.CreateAddressRequestBuilder;
import utils.Categories;
import java.io.IOException;

public class BuilderPatternTests extends AddressBaseTest {

    @Test(groups = Categories.SANITY)
    public void shouldCreateAddress() throws IOException {
        //TODO: Introduce a builder pattern

    }
}
