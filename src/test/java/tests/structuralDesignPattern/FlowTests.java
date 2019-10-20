package tests.structuralDesignPattern;
import org.testng.annotations.Test;
import tests.AddressBaseTest;

public class FlowTests extends AddressBaseTest {
    @Test
    public void addEditGetDeleteAddress() throws Exception {
        addAddress()
                .editAddressWithId("1")
                .deleteAddress("18")
                .assertAddressIsDeleted("18");

    }
}
