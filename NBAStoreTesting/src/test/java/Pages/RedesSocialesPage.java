package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RedesSocialesPage {

    WebDriver driver;
    WebDriverWait wait;

    public RedesSocialesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToRedes(String RedSocial) throws InterruptedException {

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);


        String xpath = "//img[@data-src='https://essential.vtexassets.com/arquivos/nba-store-social-" + RedSocial + ".png']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

        String ventana = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(ventana)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        wait.until(ExpectedConditions.urlToBe("https://www.instagram.com/nbastorear/"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.instagram.com/nbastorear/", "No se abrió el link a Instagram correctamente");

        /* -- X -- */

        /* wait.until(ExpectedConditions.urlToBe("https://x.com/nbastorear"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://x.com/nbastorear", "No se abrió el link a X correctamente");
         */

        /* -- Tik Tok -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.tiktok.com/@nbastore.ar"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.tiktok.com/@nbastore.ar", "No se abrió el link a TikTok correctamente");
         */

        /* -- Facebook -- */

        /* wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/people/NBA-Store-AR/61574850856276/"));

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.facebook.com/people/NBA-Store-AR/61574850856276/", "No se abrió el link a Facebook correctamente");
         */



    }
}
