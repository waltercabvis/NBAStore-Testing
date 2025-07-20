package Test;

import DriverManager.BaseTest;
import DriverManager.Utils;
import Pages.ProdEquiposPage;
import org.testng.annotations.Test;

public class ProdEquiposTest extends BaseTest {
    @Test
    public void goToNavEquipo(){
        THREAD_LOCAL_EXTENT_TEST = THREAD_LOCAL_EXTENT_REPORTS.createTest("Productos", "Se desea probar la correcta visibilidad de los productos");
        ProdEquiposPage prodEquiposPage = new ProdEquiposPage(GetDriver(),GetWait(), GetExtentTest(), new Utils(GetDriver()));
        prodEquiposPage.goToProdEquipos();
    }
}
