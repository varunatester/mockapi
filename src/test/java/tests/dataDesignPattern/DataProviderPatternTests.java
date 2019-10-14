package tests.dataDesignPattern;
import entities.CreateAddressRequest;
import org.testng.annotations.Test;
import requestBuilders.CreateAddressRequestBuilder;
import tests.AddressBaseTest;
import utils.NameTestData;
import java.io.IOException;

public class DataProviderPatternTests extends AddressBaseTest {

    @Test(dataProviderClass= NameTestData.class,dataProvider = "nameTestData")
    public void shouldCreateAddressWithMultipleNames(String firstName,String lastName) throws IOException {
        CreateAddressRequest request =
                new CreateAddressRequestBuilder()
                        .withFirstName(firstName)
                        .withLastName(lastName)
                        .build();
        addAddress(request);
    }
    @Test(dataProviderClass= NameTestData.class,dataProvider = "nameTestData2")
    public void shouldCreateAddress(CreateAddressRequest addressRequest) throws IOException {
        CreateAddressRequest request =
                new CreateAddressRequestBuilder()
                        .withFirstName(addressRequest.getFirstName())
                        .withLastName(addressRequest.getLastName())
                        .build();
        addAddress(request);
    }
}
