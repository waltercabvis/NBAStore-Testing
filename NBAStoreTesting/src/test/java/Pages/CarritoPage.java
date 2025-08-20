package Pages;

import DriverManager.Utils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CarritoPage {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest test;
    Utils utils;

    public CarritoPage(WebDriver driver, WebDriverWait wait, ExtentTest test, Utils utils) {
        this.driver = driver;
        this.wait = wait;
        this.test = test;
        this.utils = utils;
        PageFactory.initElements(this.driver, this);
    }

    public void goToCarrito() throws InterruptedException {

        By buscadorXpath = By.xpath("//*[@id=\"downshift-0-input\"]");

        WebElement buscador = wait.until(ExpectedConditions.elementToBeClickable(buscadorXpath));
        buscador.sendKeys("Curry");
        buscador.sendKeys(Keys.ENTER);

        WebElement producto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='BANDERÍN WINCRAFT GOLDEN STATE WARRIORS STEPHEN CURRY UNISEX']")));
        producto.click();

        WebElement boton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='vtex-add-to-cart-button-0-x-buttonText vtex-add-to-cart-button-0-x-buttonText--buttonAddToCart']")));
        boton1.click();

        WebElement boton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Ir al checkout')]")));
        boton2.click();

        WebElement boton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='cart-to-orderform']")));
        boton3.click();

        WebElement botonEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("client-pre-email")));
        botonEmail.sendKeys("test5@test.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-client-pre-email"))).click();

        WebElement botonNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-first-name")));
        botonNombre.sendKeys("Prueba");

        WebElement botonApellido = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-last-name")));
        botonApellido.sendKeys("Selenium");

        WebElement botonDocumento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-document")));
        botonDocumento.sendKeys("12345678");

        WebElement botonTelefono = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-phone1")));
        botonTelefono.sendKeys("11");

        WebElement botonTelefono2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-phone3")));
        botonTelefono2.sendKeys("98765432");

        WebElement boton4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("go-to-shipping")));
        boton4.click();

        WebElement botonPostal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ship-postalCode")));
        botonPostal.sendKeys("1111");

        WebElement botonDireccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ship-street")));
        botonDireccion.sendKeys("Test");

        WebElement botonNumero = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ship-number")));
        botonNumero.sendKeys("999");

        WebElement botonDepto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ship-complement")));
        botonDepto.sendKeys("A");

        WebElement botonDestinatario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ship-receiverName")));
        botonDestinatario.sendKeys("Prueba Selenium");

        WebElement boton5 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-go-to-payment")));
        boton5.click();


        By iframeLocator = By.xpath("//*[@id='iframe-placeholder-creditCardPaymentGroup']/iframe");
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", iframe);
        wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);


        WebElement numeroTarjeta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("creditCardpayment-card-0Number")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", numeroTarjeta);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", numeroTarjeta);
        numeroTarjeta.sendKeys("4638397200419812");
        Thread.sleep(1000);


        WebElement nombreTarjeta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("creditCardpayment-card-0Name")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nombreTarjeta);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", nombreTarjeta);
        nombreTarjeta.sendKeys("Prueba Falsa");
        Thread.sleep(1000);

        WebElement mes = wait.until(ExpectedConditions.elementToBeClickable(By.id("creditCardpayment-card-0Month")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mes);
        new Select(mes).selectByValue("07");
        Thread.sleep(1000);

        WebElement anio = wait.until(ExpectedConditions.elementToBeClickable(By.id("creditCardpayment-card-0Year")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", anio);
        new Select(anio).selectByValue("30");
        Thread.sleep(1000);

        WebElement cvv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("creditCardpayment-card-0Code")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cvv);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", cvv);
        cvv.sendKeys("564");
        Thread.sleep(1000);

        driver.switchTo().defaultContent();

        WebElement boton9 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[3]")));
        boton9.click();

        Thread.sleep(9000);

        WebElement cartelError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-large payment-unauthorized-button']")));
        String screenshotFile = utils.TakeScreenShot("tarjeta_invalida_rechazada");

        if (cartelError.isDisplayed()) {
            test.pass("Se mostró correctamente el cartel de rechazo de tarjeta.").addScreenCaptureFromPath(screenshotFile);
        } else {
            test.fail("No se mostró el cartel de rechazo de tarjeta.").addScreenCaptureFromPath(screenshotFile);
            Assert.fail("No se mostró el cartel de rechazo de tarjeta.");
        }
    }
}
