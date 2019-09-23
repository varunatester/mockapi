package tests;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import entities.CreateAddressRequest;
import entities.CreateAddressResponse;
import entities.GetAddressByIdResponse;
import org.testng.Reporter;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Configuration.getConfiguration;

/**
 * Created by varuna on 8/19/15.
 */
public class AddressBaseTest extends TestBase {

    CreateAddressResponse addAddress(CreateAddressRequest request) throws IOException {

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

    CreateAddressResponse editAddress(CreateAddressRequest editRequest, String addressId) throws IOException {
        String url = getConfiguration().getAddressUrl()+ "/" + addressId;
        RequestSpecification specification = given().request().with()
                .queryParam("format", "json")
                .body(editRequest);
        Response response = specification.when().put(url);
        Reporter.log("EditAddress Response --- " + response.asString(), true);

        return (CreateAddressResponse) ResponseHelper
                .getResponseObject(response.asString(), CreateAddressResponse.class);
    }

    CreateAddressResponse deleteAddress(String addressId) throws IOException {
        String url = getConfiguration().getAddressUrl()+ "/" + addressId;
        RequestSpecification specification = given().request().with()
                .queryParam("format", "json")
                ;

        Response response = specification.when().delete(url);
        Reporter.log("DeleteAddress Response --- " + response.asString(), true);

        return (CreateAddressResponse) ResponseHelper
                .getResponseObject(response.asString(), CreateAddressResponse.class);
    }
}
