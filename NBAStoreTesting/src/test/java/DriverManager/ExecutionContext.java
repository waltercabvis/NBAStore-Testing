package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExecutionContext {
    protected static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    protected static final ThreadLocal<WebDriverWait> WAIT = new ThreadLocal<>();
    @SuppressWarnings("static-access")
    public static final String DATE = new Utils().GetDate();
    public static ExtentSparkReporter THREAD_LOCAL_SPARK_REPORTER;
    public static ExtentReports THREAD_LOCAL_EXTENT_REPORTS;
    public static ExtentTest THREAD_LOCAL_EXTENT_TEST;
}