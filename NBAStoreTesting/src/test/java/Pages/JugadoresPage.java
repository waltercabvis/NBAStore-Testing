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

public class JugadoresPage {

    WebDriver driver;
    WebDriverWait wait;

    public JugadoresPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToJugadores() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("__icommkt_modal_close_button"))).click();

        WebElement jugadores = driver.findElement(By.xpath("//div[contains(text(),'JUGADORES')]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(jugadores).perform();

        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Actuales']")));
        Assert.assertEquals("Actuales", "Actuales");

        WebElement menu1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Históricos']")));
        Assert.assertEquals("Históricos", "Históricos");

        List<WebElement> cantidadDeJugadores = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[contains(@class, 'vtex-rich-text-0-x-paragraph') and contains(@class, 'vtex-rich-text-0-x-paragraph--textmenuPlayers')]")));
        System.out.println("Jugadores encontrados: " + cantidadDeJugadores.size());

        for (WebElement nombreDeJugadores : cantidadDeJugadores) {
            System.out.println("- " + nombreDeJugadores.getText().trim());
        }

        Assert.assertFalse(cantidadDeJugadores.isEmpty(), "No se encontraron jugadores");

        for (WebElement nombreDeJugadores : cantidadDeJugadores) {
            if (nombreDeJugadores.getText().contains("Manu Ginóbili")){
                nombreDeJugadores.click();
                Thread.sleep(2000);
                break;
            }
        }

        String currentUrlJugador = driver.getCurrentUrl();
        Assert.assertTrue(currentUrlJugador.contains("manu"), "No se encontró al jugador requerido");
    }
}