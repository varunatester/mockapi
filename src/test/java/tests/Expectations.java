package tests;

import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.mockserver.model.Parameter;

import java.io.File;

import static com.jayway.restassured.path.json.JsonPath.from;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;


public class Expectations {

    private ClientAndServer mockServer;

    public Expectations(ClientAndServer mockServer) {
        this.mockServer = mockServer;
        setExpectations();
    }

    private void setExpectations() {
        expectationForCreateAddressJson();
        expectationForGetAddressJson();
        expectationForEditAddressJson();
        expectationForGetAddressJsonAfterEdit();
        expectationForCreateAddressJsonForDelete();
        expectationForDeleteAddressJsonForDelete("1");
        expectationForGetAddressByApartmentNo();

    }


    private void expectationForCreateAddressJson() {

        String responseString = "{\"addressId\":\"1\"}";
        mockServer
                .when(
                        request()
                                .withPath("/addresses")
                                .withQueryStringParameter(new Parameter("format", "json"))
                                .withMethod("POST"))
                .respond(
                        response()
                                .withStatusCode(201)
                                .withHeaders(
                                        new Header("Content-Type", "application/json")
                                )
                                .withBody(responseString));
    }

    private void expectationForEditAddressJson() {

        String responseString = "{\"addressId\":\"11\"}";

        mockServer
                .when(
                        request()
                                .withPath("/addresses/1")
                                .withQueryStringParameter(new Parameter("format", "json"))
                                .withMethod("PUT"))
                .respond(
                        response()
                                .withStatusCode(200)
                                .withHeaders(
                                        new Header("Content-Type", "application/json")
                                )
                                .withBody(responseString));
    }

    private void expectationForGetAddressJson() {
        Object o = from(new File("build/resources/test/address.json"))
                .get("address.findAll {r -> r.addressId == '1'}[0]");
        String responseString = RequestHelper.getJsonString(o);

        mockServer
                .when(
                        request()
                                .withPath("/addresses/1")
                                .withQueryStringParameter(new Parameter("format", "json"))
                                .withMethod("GET"))
                .respond(
                        response()
                                .withStatusCode(200)
                                .withHeaders(
                                        new Header("Content-Type", "application/json")
                                )
                                .withBody(responseString));
    }

    private void expectationForGetAddressJsonAfterEdit() {
        Object o = from(new File("build/resources/test/address.json"))
                .get("address.findAll {r -> r.addressId == '11'}[0]");
        String responseString = RequestHelper.getJsonString(o);

        mockServer
                .when(
                        request()
                                .withPath("/addresses/11")
                                .withQueryStringParameter(new Parameter("format", "json"))
                                .withMethod("GET"))
                .respond(
                        response()
                                .withStatusCode(200)
                                .withHeaders(
                                        new Header("Content-Type", "application/json")
                                )
                                .withBody(responseString));
    }

    private void expectationForGetAddressByApartmentNo() {
        Object o = from(new File("build/resources/test/address.json"))
                .get("address.findAll {r -> r.apartmentNo == '3910'}[0]");
        String responseString = RequestHelper.getJsonString(o);

        mockServer
                .when(
                        request()
                                .withPath("/addresses/3910")
                                .withQueryStringParameter(new Parameter("format", "json"))
                                .withMethod("GET"))
                .respond(
                        response()
                                .withStatusCode(200)
                                .withHeaders(
                                        new Header("Content-Type", "application/json")
                                )
                                .withBody(responseString));
    }

    public void expectationForCreateAddressJsonForDelete() {
        String responseString = "{\"addressId\":\"18\"}";

        mockServer
                .when(
                        request()
                                .withPath("/addresses")
                                .withQueryStringParameter(new Parameter("format", "json"))
                                .withMethod("POST"))
                .respond(
                        response()
                                .withStatusCode(201)
                                .withHeaders(
                                        new Header("Content-Type", "application/json")
                                )
                                .withBody(responseString));
    }

    public void expectationForDeleteAddressJsonForDelete(String i) {
        String responseString = "{\"addressId\":\"" + i + "\"}";

        mockServer
                .when(
                        request()
                                .withPath("/addresses/" + i)
                                .withQueryStringParameter(new Parameter("format", "json"))
                                .withMethod("DELETE"))
                .respond(
                        response()
                                .withStatusCode(201)
                                .withHeaders(
                                        new Header("Content-Type", "application/json")
                                )
                                .withBody(responseString));
    }
}
