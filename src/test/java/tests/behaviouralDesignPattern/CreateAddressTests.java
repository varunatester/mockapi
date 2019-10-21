package tests.behaviouralDesignPattern;

import entities.CreateAddressRequest;
import entities.CreateAddressResponse;
import org.testng.annotations.Test;
import requestBuilders.CreateAddressRequestBuilder;
import tests.AddressBaseTest;
import utils.Categories;
import java.io.IOException;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.testng.AssertJUnit.assertNotNull;


/**
 * Created by varuna on 8/20/15.
 */
public class CreateAddressTests extends AddressBaseTest {
    @Test
    public void shouldCreateAddress() {
        given().request().with()
                .queryParam("format", "json")
                .body(new CreateAddressRequestBuilder().build())
                .when()
                .post("http://localhost:8080/addresses")
                .then()
                .assertThat()
                .statusCode(201)
                .body("addressId", notNullValue());
    }
    @Test(groups = Categories.SANITY)
   public void refactoredTests() {
        //createAddress
        //assertAddress is created
    }
}
