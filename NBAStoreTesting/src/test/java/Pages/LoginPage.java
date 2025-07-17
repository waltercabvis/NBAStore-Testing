package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToLogin() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("__icommkt_modal_close_button"))).click();

        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Mi cuenta']")));
        login.click();

        String ventana = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(ventana)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/login?returnUrl=%2Faccount"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/login?returnUrl=%2Faccount", "No se ingresó al login correctamente");

        String mail = "waltertests@hotmail.com";
        String pass = "Pruebatest123";

        WebElement cuenta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Ej.: ejemplo@mail.com']")));
        wait.until(ExpectedConditions.elementToBeClickable(cuenta));
        cuenta.sendKeys(mail);

        WebElement pwd= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Ingrese su contraseña ']")));
        wait.until(ExpectedConditions.elementToBeClickable(pwd));
        pwd.sendKeys(pass);

        WebElement botonEntrar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".vtex-button__label")));
        wait.until(ExpectedConditions.elementToBeClickable(botonEntrar));
        botonEntrar.click();


        String urlCuenta = driver.getCurrentUrl();
        Assert.assertTrue(urlCuenta.contains("account"), "No se logueo correctamente.");
    }
}
