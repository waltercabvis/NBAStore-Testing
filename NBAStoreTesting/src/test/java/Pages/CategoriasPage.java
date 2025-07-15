package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CategoriasPage {

    WebDriver driver;
    WebDriverWait wait;

    public CategoriasPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToCategorias(String categoria) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("__icommkt_modal_close_button"))).click();

        String xpath = "//div[contains(@class, 'vtex-menu-2-x-styledLinkContent') and contains(text(),'" + categoria + "')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        wait.until(ExpectedConditions.urlContains(categoria.toLowerCase()));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.toLowerCase().contains("accesorios"), "No fue re-dirigido a la sección esperada, 'accesorios': " + currentUrl);
    }
}
