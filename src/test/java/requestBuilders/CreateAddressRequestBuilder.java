package requestBuilders;
import entities.CreateAddressRequest;
/**
 * Created by varuna on 8/20/15.
 */
public class CreateAddressRequestBuilder {

    CreateAddressRequest request;

    public CreateAddressRequestBuilder() {
        request = new CreateAddressRequest();
        request.setTitle("Mrs");
        request.setFirstName("Varuna");
        request.setLastName("Srivastava");
        request.setLine1("300 Front St West");
        request.setLine2("Blue building");

        request.setCity("Toronto");
        request.setState("Ontario");
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
