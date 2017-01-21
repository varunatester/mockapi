package tests;

import entities.CreateAddressRequest;
import entities.CreateAddressResponse;
import entities.GetAddressByIdResponse;
import org.testng.annotations.Test;
import requestBuilders.CreateAddressRequestBuilder;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * Created by varuna on 8/20/15.
 */
public class GetAddressTests extends AddressBaseTest {

    @Test
    public void shouldCreateAndGetAddress() throws IOException {

        CreateAddressRequest request = new CreateAddressRequestBuilder().build();
        CreateAddressResponse addAddressResponse = addAddress(request);
        String expectedAddressId = addAddressResponse.getAddressId();
        assertNotNull(expectedAddressId);
        GetAddressByIdResponse getAddressResponse = getAddressById(expectedAddressId);
        assertEquals(getAddressResponse.getAddressId(), expectedAddressId);
        getAddressResponse.assertAddress(request);
    }
}
