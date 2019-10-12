package tests;
import org.mockserver.integration.ClientAndServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    private ClientAndServer mockServer;
    private Expectations expectations;

    @BeforeMethod(alwaysRun = true)
    public void startMockServer() {
        mockServer = new ClientAndServer(8080);
        expectations = new Expectations(mockServer);
    }

   @AfterMethod(alwaysRun = true)
    public void stopMockServer() {
       mockServer.stop();
    }
}
