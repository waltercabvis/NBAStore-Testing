package DriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest extends ExecutionContext {
    @BeforeTest
    public void SetUp(){
        THREAD_LOCAL_SPARK_REPORTER = new ExtentSparkReporter(System.getProperty("user.dir")+
                "\\src\\test\\resources\\reportes\\"+ DATE + ".html");

        THREAD_LOCAL_EXTENT_REPORTS = new ExtentReports();
        THREAD_LOCAL_EXTENT_REPORTS.attachReporter(THREAD_LOCAL_SPARK_REPORTER);

        THREAD_LOCAL_SPARK_REPORTER.config().setOfflineMode(true);
        THREAD_LOCAL_SPARK_REPORTER.config().setDocumentTitle("NBAStore");
        THREAD_LOCAL_SPARK_REPORTER.config().setReportName("Test Report");
        THREAD_LOCAL_SPARK_REPORTER.config().setTheme(Theme.DARK);
        THREAD_LOCAL_SPARK_REPORTER.config().setTimeStampFormat("dd/MM/yyyy HH:mm");
        THREAD_LOCAL_SPARK_REPORTER.config().setEncoding("UTF-8");

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
        THREAD_LOCAL_EXTENT_REPORTS.flush();
    }

    public static WebDriver GetDriver(){
        return DRIVER.get();
    }

    public static WebDriverWait GetWait(){
        return WAIT.get();
    }

    public static ExtentTest GetExtentTest(){
        return THREAD_LOCAL_EXTENT_TEST;
    }
}