package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AtnClientePage {

    WebDriver driver;
    WebDriverWait wait;

    public AtnClientePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToAtnCliente(String categoria) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("__icommkt_modal_close_button"))).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        WebElement atencionCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Atención al cliente']")));
        Assert.assertTrue(atencionCliente.isDisplayed(), "No se encontró 'Atención al cliente'");

        String xpath = "//a[normalize-space(text())='" + categoria + "']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

        String ventana = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(ventana)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.urlToBe("https://api.whatsapp.com/send/?phone=541136735460&text=Hola%21+&type=phone_number&app_absent=0"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://api.whatsapp.com/send/?phone=541136735460&text=Hola%21+&type=phone_number&app_absent=0", "No se abrió la URL del chat con un asesor correctamente");

        /* -- Preguntas Frecuentes -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/faqs"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/faqs", "No se abrió la URL de Preguntas Frecuentes correctamente");
         */

        /* -- Seguimiento de envíos -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/seguimiento-logisticas"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/seguimiento-logisticas", "No se abrió la URL de Seguimiento de envíos correctamente");
         */

        /* -- Arrepentimiento de Compras -- */

        /* wait.until(ExpectedConditions.urlToBe("https://api.whatsapp.com/send/?phone=541136735460&text=Hola%21+&type=phone_number&app_absent=0"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://api.whatsapp.com/send/?phone=541136735460&text=Hola%21+&type=phone_number&app_absent=0", "No se abrió la URL de Arrepentimiento de Compras correctamente");
         */

    }
}