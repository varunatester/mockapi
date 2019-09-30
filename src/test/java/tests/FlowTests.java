package tests;

import org.testng.annotations.Test;

import java.io.IOException;


public class FlowTests extends AddressBaseTest {
    @Test
    public void addEditGetDeleteAddress() throws IOException {
        addAddress()
                .editAddress()
                .deleteAddress("11")
                .assertAddressIsDeleted();

    }
}
