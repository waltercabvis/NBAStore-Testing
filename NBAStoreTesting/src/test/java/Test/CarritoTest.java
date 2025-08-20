package Test;

import DriverManager.BaseTest;
import DriverManager.Utils;
import Pages.CarritoPage;
import org.testng.annotations.Test;

public class CarritoTest extends BaseTest {
    @Test
    public void goToCarrito() throws InterruptedException {
        THREAD_LOCAL_EXTENT_TEST = THREAD_LOCAL_EXTENT_REPORTS.createTest("Compra Falsa", "Se desea probar una compra mediante datos falsos");
        CarritoPage carritoPage = new CarritoPage(GetDriver(),GetWait(), GetExtentTest(), new Utils(GetDriver()));
        carritoPage.goToCarrito();
    }
}
