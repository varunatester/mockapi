package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Ignore;

import static org.testng.Assert.assertEquals;

/**
 * Created by varuna on 8/19/15.
 */
public class GetAddressByIdResponse {

    private String addressId;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String apartmentNo;
    private String title;
    private String firstName;
    private String lastName;
    private String state;
    private String city;
    private String line1;
    private String line2;
    private String line3;

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public void assertAddress(CreateAddressRequest request) {
        assertEquals(getFirstName(),request.getFirstName());
        assertEquals(getLastName(),request.getLastName());
        assertEquals(getTitle(),request.getTitle());
        assertEquals(getCity(),request.getCity());
        assertEquals(getLine1(),request.getLine1());
        assertEquals(getLine2(),request.getLine2());
        assertEquals(getLine3(),request.getLine3());
    }
}
