package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest extends ExecutionContext {
    @BeforeTest
    public void SetUp(){
        WebDriver driver = DriverManager.SetUp("chrome");
        DRIVER.set(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WAIT.set(wait);

        driver.get("https://www.nbastore.com.ar/");
    }

    @AfterTest
    public void tearDown(){
        if(GetDriver() != null)
            GetDriver().quit();
    }

    public static WebDriver GetDriver(){
        return DRIVER.get();
    }

    public static WebDriverWait GetWait(){
        return WAIT.get();
    }
}