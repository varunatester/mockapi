package tests.dataDesignPattern;
import entities.CreateAddressRequest;
import org.testng.annotations.Test;
import utils.Categories;
import java.io.IOException;

public class CreateAddressValueObjectTests {

    public CreateAddressRequest createAddress(String firstName, String lastName, String title,
                                              String apartmentNo, String line1, String city,
                                              String state){
        CreateAddressRequest request = new CreateAddressRequest();
        request.setFirstName(firstName);
        request.setLastName(lastName);
        request.setTitle(title);
        request.setApartmentNo(apartmentNo);
        request.setLine1(line1);
        request.setCity(city);
        request.setState(state);
        return request;
    }
    public CreateAddressRequest createAddress(CreateAddressRequest address) throws IOException {
        CreateAddressRequest request = new CreateAddressRequest();
        request.setFirstName(address.getFirstName());
        request.setLastName(address.getLastName());
        request.setTitle(address.getTitle());
        request.setLine1(address.getLine1());
        request.setLine2(address.getLine2());
        request.setLine3(address.getLine3());
        request.setCity(address.getCity());
        request.setState(address.getState());
        return request;
    }

    @Test(groups = Categories.SANITY)
    public void shouldCreateAddress() throws IOException {
        CreateAddressRequest request = createAddress(new CreateAddressRequest());
        createAddress(request);
    }
}
