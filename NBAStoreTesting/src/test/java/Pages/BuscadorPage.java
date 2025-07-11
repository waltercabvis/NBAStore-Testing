package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BuscadorPage {

    WebDriver driver;
    WebDriverWait wait;

    public BuscadorPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    public void goToBuscador() {
        

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("__icommkt_modal_close_button"))).click();

        By buscadorXpath = By.xpath("//*[@id=\"downshift-0-input\"]");
        WebElement buscador = wait.until(ExpectedConditions.elementToBeClickable(buscadorXpath));
        buscador.click();

        WebElement masBuscado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='vtex-search-2-x-itemListTitle c-on-base']")));
        Assert.assertEquals(masBuscado.getText().trim(), "TÉRMINOS MÁS BUSCADOS", "No se encontró la lista");

        List<WebElement> masBuscadoLista = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='vtex-search-2-x-itemListLink']")));
        System.out.println("Cantidad de elementos mas buscados: " + masBuscadoLista.size());

        for (WebElement item : masBuscadoLista){
            System.out.println("- " + item.getText().trim());
        }
    }
}
