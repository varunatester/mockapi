package requestBuilders;

import entities.CreateAddressRequest;
import entities.LocalAddress;

/**
 * Created by varuna on 8/20/15.
 */
public class CreateAddressRequestBuilder {

    CreateAddressRequest request;

    public CreateAddressRequestBuilder() {
        request = new LocalAddress();

        request.setTitle("Mrs");
        request.setFirstName("Varuna");
        request.setLastName("Srivastava");

        request.setLine1("300 Front St West");
        request.setLine2("5130 E Palmetto St Box 147");
        request.setLine3("Box");
        request.setCity("Florence");
        request.setState("SC");
    }

    public CreateAddressRequest build() {
        return request;
    }

    public CreateAddressRequestBuilder withFirstName(String firstName) {
        request.setFirstName(firstName);
        return this;
    }

    public CreateAddressRequestBuilder withLastName(String lastName) {
        request.setLastName(lastName);
        return this;
    }
    public CreateAddressRequestBuilder withApartmentNo(String apartmentNo) {
        request.setApartmentNo(apartmentNo);
        return this;
    }
}
