package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class EquiposPage {

    WebDriver driver;
    WebDriverWait wait;

    public EquiposPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToEquipos() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("__icommkt_modal_close_button"))).click();

        WebElement equipos = driver.findElement(By.xpath("//div[contains(text(),'EQUIPO')]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(equipos).perform();

        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Conferencia Oeste']")));
        Assert.assertTrue(menu.isDisplayed(), "No se pueden observar los equipos");

        Thread.sleep(3000);

        List<WebElement> cantidadDeEquipos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div//a[contains(@class, 'vtex-menu-2-x-styledLink') and contains(@class, 'vtex-menu-2-x-styledLink--menuItemSecondLevel')]")));
        System.out.println("Cantidad de Equipos encontrados: " + cantidadDeEquipos.size());

        for (WebElement nombreDeEquipos : cantidadDeEquipos) {
            System.out.println("- " + nombreDeEquipos.getText().trim());
        }

        Assert.assertFalse(cantidadDeEquipos.isEmpty(), "Se espera ver la lista de equipos NBA, pero no se encontraron");

        for (WebElement nombreDeEquipos : cantidadDeEquipos) {
            if (nombreDeEquipos.getText().contains("Spurs")) {
                nombreDeEquipos.click();
                Thread.sleep(3000);
                break;
            }
        }

        String currentUrlEquipo = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlEquipo.contains("spurs"), "No se seleccionó el equipo correcto.");
    }
}