package Test;

import DriverManager.BaseTest;
import Pages.AsistInformacionPage;
import org.testng.annotations.Test;

public class AsistInformacionTest extends BaseTest {
    @Test
    public void goToInfo() throws InterruptedException {
        AsistInformacionPage asistInformacionPage = new AsistInformacionPage(GetDriver(),GetWait());
        asistInformacionPage.goToInfo("Quienes somos");
    }
}
