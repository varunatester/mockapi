package tests;

import entities.CreateAddressRequest;
import org.testng.annotations.Test;
import requestBuilders.CreateAddressRequestBuilder;

import static org.testng.Assert.assertEquals;

/**
 * Created by varuna on 8/20/15.
 */
public class DeleteAddressTests extends AddressBaseTest{

    @Test
    public void shouldBeAbleToDeleteAddress() throws Exception {

        CreateAddressRequest request = new CreateAddressRequestBuilder().build();
        String addressId = addAddress(request).getAddressId();

        String addressIdDeleted = deleteAddress(addressId).getAddressId();
        assertEquals(addressIdDeleted, addressId);
    }


}
