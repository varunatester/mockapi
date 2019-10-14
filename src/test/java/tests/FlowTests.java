package tests;
import org.testng.annotations.Test;



public class FlowTests extends AddressBaseTest {
    @Test
    public void addEditGetDeleteAddress() throws Exception {
        addAddress()
                .editAddressWithId("1")
                .deleteAddress("1")
                .assertAddressIsDeleted();

    }
}
