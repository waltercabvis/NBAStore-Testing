package Test;

import DriverManager.BaseTest;
import Pages.CategoriasPage;
import org.testng.annotations.Test;

public class CategoriasTest extends BaseTest {
    @Test
    public void goToCategoria(){
        CategoriasPage categoriasPage = new CategoriasPage(GetDriver(),GetWait());
        categoriasPage.goToCategorias("Accesorios");
    }

}
