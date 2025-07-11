package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExecutionContext {
    protected static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    protected static final ThreadLocal<WebDriverWait> WAIT = new ThreadLocal<>();
}