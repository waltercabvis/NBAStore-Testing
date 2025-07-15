package Test;

import DriverManager.BaseTest;
import Pages.JugadoresPage;
import org.testng.annotations.Test;

public class JugadoresTest extends BaseTest {
    @Test
    public void goToJugadores() throws InterruptedException {
        JugadoresPage jugadoresPage = new JugadoresPage(GetDriver(),GetWait());
        jugadoresPage.goToJugadores();
    }
}
