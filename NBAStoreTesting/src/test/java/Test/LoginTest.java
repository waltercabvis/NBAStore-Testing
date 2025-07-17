package Test;

import DriverManager.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void goToLogin() {
        LoginPage loginPage = new LoginPage(GetDriver(),GetWait());
        loginPage.goToLogin();
    }
}
