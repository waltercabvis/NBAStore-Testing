package Pages;

import DriverManager.Utils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ProdEquiposPage {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest test;
    Utils utils;

    public ProdEquiposPage(WebDriver driver, WebDriverWait wait, ExtentTest test, Utils utils) {
        this.driver = driver;
        this.wait = wait;
        this.test = test;
        this.utils = utils;
        PageFactory.initElements(this.driver, this);
    }

    public void goToProdEquipos() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("__icommkt_modal_close_button"))).click();

        WebElement team = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@data-src='https://essential.vtexassets.com/arquivos/atlanta-hawks.svg']")));
        wait.until(ExpectedConditions.elementToBeClickable(team));
        team.click();

        wait.until(ExpectedConditions.urlContains("HAWKS"));

        wait.until(ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(By.className("vtex-product-summary-2-x-container")), ExpectedConditions.presenceOfElementLocated(By.className("vtex-search-result-3-x-searchNotFoundOops"))));

        List<WebElement> productos = driver.findElements(By.className("vtex-product-summary-2-x-container"));

        if (productos.isEmpty()) {
            System.out.println("No hay productos para este equipo.");
            String screenshotFile = utils.TakeScreenShot("productos_hawks");
            test.fail("No se encontraron productos en la sección del equipo seleccionado.").addScreenCaptureFromPath(screenshotFile);
            Assert.fail("No se encontraron productos en la sección del equipo seleccionado.");
        } else {
            System.out.println("Productos encontrados: " + productos.size());
            test.pass("Se encontraron " + productos.size() + " productos.");
        }
    }
}
