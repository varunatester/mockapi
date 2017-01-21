package requestBuilders;

import entities.CreateAddressRequest;

/**
 * Created by varuna on 8/20/15.
 */
public class CreateAddressRequestBuilder {

    CreateAddressRequest request;

    public CreateAddressRequestBuilder() {
        request = new CreateAddressRequest();

        request.setTitle("Mr");
        request.setFirstName("Richard");
        request.setLastName("Parker");

        request.setLine1("Francis Marion University");
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
}
