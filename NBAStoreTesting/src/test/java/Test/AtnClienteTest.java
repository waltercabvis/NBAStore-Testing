package Test;

import DriverManager.BaseTest;
import Pages.AtnClientePage;
import org.testng.annotations.Test;

public class AtnClienteTest extends BaseTest {
    @Test
    public void goToAtencionCliente() throws InterruptedException {
        AtnClientePage atnClientePage = new AtnClientePage(GetDriver(),GetWait());
        atnClientePage.goToAtnCliente("Chateá con un asesor");
    }
}