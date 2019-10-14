package tests;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import entities.*;
import org.testng.Reporter;
import requestBuilders.CreateAddressRequestBuilder;
import java.io.IOException;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Configuration.getConfiguration;

/**
 * Created by varuna on 8/19/15.
 */
public class AddressBaseTest extends TestBase {

     protected CreateAddressResponse addAddress(CreateAddressRequest request) throws IOException {

        RequestSpecification specification = given().request().with()
                .queryParam("format", "json")
                .body(request);
        Response response = specification.when().post(getConfiguration().getAddressUrl());
        Reporter.log("AddAddress Response --- " + response.asString(), true);

        return (CreateAddressResponse) ResponseHelper
                .getResponseObject(response.asString(), CreateAddressResponse.class);

    }
     CreateAddressResponse addAddress() throws IOException {
        CreateAddressRequest request = new CreateAddressRequestBuilder().build();
        RequestSpecification specification = given().request().with()
                .queryParam("format", "json")
                .body(request);
        Response response = specification.when().post(getConfiguration().getAddressUrl());
        Reporter.log("AddAddress Response --- " + response.asString(), true);

        return (CreateAddressResponse) ResponseHelper
                .getResponseObject(response.asString(), CreateAddressResponse.class);

    }

     GetAddressByIdResponse getAddressById(String addressId) throws IOException {

        String url = getConfiguration().getAddressUrl() + "/" + addressId;
        RequestSpecification specification = given()
                .request().with()
                .queryParam("format", "json");
        Response response = specification.when().get(url);
        assertEquals(response.getStatusCode(), 200);
        return (GetAddressByIdResponse) ResponseHelper
                .getResponseObject(response.asString(), GetAddressByIdResponse.class);
    }

    public EditAddressResponse editAddress(CreateAddressRequest editRequest, String addressId) throws Exception {
        String url = getConfiguration().getAddressUrl()+ "/" + addressId;
        RequestSpecification specification = given().request().with()
                .queryParam("format", "json")
                .body(editRequest);
        Response response = specification.when().put(url);
        Reporter.log("EditAddress Response --- " + response.asString(), true);

        return (EditAddressResponse) ResponseHelper
                .getResponseObject(response.asString(), EditAddressResponse.class);
    }

     DeleteAddressResponse deleteAddress(String addressId) throws IOException {
        String url = getConfiguration().getAddressUrl()+ "/" + addressId;
        RequestSpecification specification = given().request().with()
                .queryParam("format", "json")
                ;

        Response response = specification.when().delete(url);
        Reporter.log("DeleteAddress Response --- " + response.asString(), true);

        return (DeleteAddressResponse) ResponseHelper
                .getResponseObject(response.asString(), DeleteAddressResponse.class);
    }
}
