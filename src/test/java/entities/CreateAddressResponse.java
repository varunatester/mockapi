package entities;

import requestBuilders.CreateAddressRequestBuilder;
import tests.AddressBaseTest;

public class CreateAddressResponse {

    private String addressId;

    public String getAddressId() {
        return addressId;
    }


    public EditAddressResponse editAddressWithId(String addressId) throws Exception {
        CreateAddressRequest request = new CreateAddressRequestBuilder().withFirstName("Star").withLastName("Canada").build();
        return new AddressBaseTest().editAddress(request,addressId);
    }
}
