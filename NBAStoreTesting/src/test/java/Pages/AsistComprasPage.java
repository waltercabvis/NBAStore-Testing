package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AsistComprasPage {

    WebDriver driver;
    WebDriverWait wait;

    public AsistComprasPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToComprasAsist(String categoria) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("__icommkt_modal_close_button"))).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        WebElement compras= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Compras']")));
        Assert.assertTrue(compras.isDisplayed(), "No se encontró 'Compras'");

        String xpath = "//a[normalize-space(text())='" + categoria + "']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

        String ventana = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(ventana)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/envios"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/envios", "No se abrió la URL de la 'Politica de envios' correctamente");

        /* -- Politica de cambios -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/cambios-y-devoluciones"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/cambios-y-devoluciones", "No se abrió la URL de 'Politica de cambios' correctamente");
         */

        /* -- Formas de pago -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/formas-de-pago"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/formas-de-pago", "No se abrió la URL de 'Formas de pago' correctamente");
         */

        /* -- Retiros en local -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/retiro-y-customizaciones"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/retiro-y-customizaciones", "No se abrió la URL de 'Retiros en local'' correctamente");
         */


    }
}
