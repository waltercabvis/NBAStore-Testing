package Test;

import DriverManager.BaseTest;
import Pages.RedesSocialesPage;
import org.testng.annotations.Test;

public class RedesSocialesTest extends BaseTest {
    @Test
    public void goToRedes() throws InterruptedException {
        RedesSocialesPage redesSocialesPage = new RedesSocialesPage(GetDriver(),GetWait());
        redesSocialesPage.goToRedes("ig");
    }
}
