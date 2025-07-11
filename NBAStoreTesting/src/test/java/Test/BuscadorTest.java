package Test;

import DriverManager.BaseTest;
import Pages.BuscadorPage;
import org.testng.annotations.Test;

public class BuscadorTest extends BaseTest{
    @Test
    public void GoToBuscador() {
        BuscadorPage buscadorPage = new BuscadorPage(GetDriver(),GetWait());
        buscadorPage.goToBuscador();
    }
}
