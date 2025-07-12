package Test;

import DriverManager.BaseTest;
import Pages.EquiposPage;
import org.testng.annotations.Test;

public class EquiposTest extends BaseTest {
    @Test
    public void goToEquipos() throws InterruptedException {
        EquiposPage equiposPage = new EquiposPage(GetDriver(),GetWait());
        equiposPage.goToEquipos();
    }
}
