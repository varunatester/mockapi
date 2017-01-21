package tests;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import entities.*;
import org.testng.Reporter;
import utils.Properties;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * Created by varuna on 8/19/15.
 */
public class AddressBaseTest extends TestBase {

    public CreateAddressResponse addAddress(CreateAddressRequest request) throws IOException {

        RequestSpecification specification = given().request().with()
                .queryParam("format", "json")
                .body(request);
        Response response = specification.when().post(Properties.addressUrl);
        Reporter.log("AddAddress Response --- " + response.asString(), true);

        return (CreateAddressResponse) ResponseHelper
                .getResponseObject(response.asString(), CreateAddressResponse.class);

    }

    public GetAddressByIdResponse getAddressById(String addressId) throws IOException {

        String url = Properties.addressUrl + "/" + addressId;
        RequestSpecification specification = given()
                .request().with()
                .queryParam("format", "json");
        Response response = specification.when().get(url);
        assertEquals(response.getStatusCode(), 200);
        return (GetAddressByIdResponse) ResponseHelper
                .getResponseObject(response.asString(), GetAddressByIdResponse.class);
    }

    public CreateAddressResponse editAddress(CreateAddressRequest editRequest, String addressId) throws IOException {
        String url = Properties.addressUrl+ "/" + addressId;
        RequestSpecification specification = given().request().with()
                .queryParam("format", "json")
                .body(editRequest);
        Response response = specification.when().put(url);
        Reporter.log("EditAddress Response --- " + response.asString(), true);

        return (CreateAddressResponse) ResponseHelper
                .getResponseObject(response.asString(), CreateAddressResponse.class);
    }

    public CreateAddressResponse deleteAddress(String addressId) throws IOException {
        String url = Properties.addressUrl+ "/" + addressId;
        RequestSpecification specification = given().request().with()
                .queryParam("format", "json")
                ;

        Response response = specification.when().delete(url);
        Reporter.log("DeleteAddress Response --- " + response.asString(), true);

        return (CreateAddressResponse) ResponseHelper
                .getResponseObject(response.asString(), CreateAddressResponse.class);
    }
}
