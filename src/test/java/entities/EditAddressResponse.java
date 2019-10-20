package entities;
import tests.AddressBaseTest;

import java.io.IOException;

public class EditAddressResponse {
    private String addressId;

    public String getAddressId() {
        return addressId;
    }

    public DeleteAddressResponse deleteAddress(String addressId) throws IOException {
        return new AddressBaseTest().deleteAddress(addressId);
    }
}
