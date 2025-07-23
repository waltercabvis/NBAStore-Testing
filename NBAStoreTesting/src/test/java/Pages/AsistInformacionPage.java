package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AsistInformacionPage {

    WebDriver driver;
    WebDriverWait wait;

    public AsistInformacionPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToInfo(String categoria) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("__icommkt_modal_close_button"))).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        WebElement info= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Información']")));
        Assert.assertTrue(info.isDisplayed(), "No se encontró 'Información'");

        String xpath = "//a[normalize-space(text())='" + categoria + "']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

        String ventana = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(ventana)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/nosotros"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/nosotros", "No se abrió la URL de 'Quienes somos' correctamente");

        /* -- Mi cuenta -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/login?returnUrl=%2Faccount"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/login?returnUrl=%2Faccount", "No se abrió la URL de 'Mi cuenta' correctamente");
         */

        /* -- Términos y condiciones -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.nbastore.com.ar/terminos-y-condiciones"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.nbastore.com.ar/terminos-y-condiciones", "No se abrió la URL de 'Términos y condiciones' correctamente");
         */

        /* -- Defensa al consumidor -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.argentina.gob.ar/economia/industria-y-comercio/defensadelconsumidor"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.argentina.gob.ar/economia/industria-y-comercio/defensadelconsumidor", "No se abrió la URL de 'Defensa al consumidor' correctamente");
         */


    }
}
