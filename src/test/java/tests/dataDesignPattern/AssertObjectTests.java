package tests.dataDesignPattern;

import entities.CreateAddressRequest;
import entities.EditAddressResponse;
import entities.GetAddressByIdResponse;
import org.testng.annotations.Test;
import requestBuilders.CreateAddressRequestBuilder;
import tests.AddressBaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by varuna on 8/20/15.
 */
public class AssertObjectTests extends AddressBaseTest {

    @Test
    public void shouldBeAbleToEditAddress() throws Exception {
        String addressId = addAddress(new CreateAddressRequestBuilder().build())
                .getAddressId();
        CreateAddressRequest editRequest = new CreateAddressRequestBuilder()
                .withFirstName("Star")
                .withLastName("Canada").build();
        EditAddressResponse editAddressResponse = editAddress(editRequest, addressId);
        String editedAddressId = editAddressResponse.getAddressId();
        assertNotEquals(editedAddressId, addressId);

        GetAddressByIdResponse getAddressResponse = getAddressById(editedAddressId);
        //TODO: Refactor this to assert object
        assertEquals(getAddressResponse.getAddressId(), editAddressResponse.getAddressId());
        assertEquals(getAddressResponse.getFirstName(), editRequest.getFirstName());
        assertEquals(getAddressResponse.getLastName(), editRequest.getLastName());
        assertEquals(getAddressResponse.getTitle(), editRequest.getTitle());
        assertEquals(getAddressResponse.getLine1(), editRequest.getLine1());
        assertEquals(getAddressResponse.getLine2(), editRequest.getLine2());
        assertEquals(getAddressResponse.getCity(), editRequest.getCity());
        assertEquals(getAddressResponse.getState(), editRequest.getState());
    }
}
