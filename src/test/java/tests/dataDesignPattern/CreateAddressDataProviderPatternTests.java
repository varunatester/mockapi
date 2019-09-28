package tests.dataDesignPattern;
import entities.CreateAddressRequest;
import org.testng.annotations.Test;
import requestBuilders.CreateAddressRequestBuilder;
import tests.AddressBaseTest;
import utils.NameTestData;
import java.io.IOException;

public class CreateAddressDataProviderPatternTests extends AddressBaseTest {

    @Test(dataProviderClass= NameTestData.class,dataProvider = "nameTestData")
    public void shouldCreateAddress(String firstName,String lastName) throws IOException {
        CreateAddressRequest request =
                new CreateAddressRequestBuilder()
                .withFirstName(firstName).withLastName(lastName)
                .build();
        addAddress(request);
    }
}
