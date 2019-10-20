package entities;

import tests.AddressBaseTest;

import java.io.IOException;

import static org.testng.Assert.assertNull;

public class DeleteAddressResponse {
    private String addressId;
    public String getAddressId() {
        return addressId;
    }

    public void assertAddressIsDeleted(String addressId) throws IOException {
        GetAddressByIdResponse addressById = new AddressBaseTest().getAddressById(addressId);
        assertNull(addressById.getAddressId());
    }
}
