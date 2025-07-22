package Test;

import DriverManager.BaseTest;
import Pages.AsistComprasPage;
import org.testng.annotations.Test;

public class AsistComprasTest extends BaseTest {
    @Test
    public void goToCompras() throws InterruptedException {
        AsistComprasPage asistComprasPage = new AsistComprasPage(GetDriver(),GetWait());
        asistComprasPage.goToComprasAsist("Politica de envios");
    }
}
