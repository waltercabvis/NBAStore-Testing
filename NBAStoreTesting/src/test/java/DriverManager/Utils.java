package DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Utils {

    private static Properties props = new Properties();

    static {
        try (InputStream input = Utils.class.getClassLoader().getResourceAsStream("credentials.properties")) {
            if (input != null) {
                props.load(input);
            } else {
                throw new RuntimeException("No se pudo encontrar credentials.properties");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error cargando el archivo de propiedades", e);
        }
    }

    public static String getEmail() {
        return props.getProperty("email");
    }

    public static String getPassword() {
        return props.getProperty("password");
    }

    WebDriver driver;

    public Utils(){}

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public static String GetDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd___HH-mm-ss"));
    }

    public String TakeScreenShot(String fileName){
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String file = fileName + '-'+ GetDate() + ".PNG";

        String name ="src/test/resources/reportes/" + file;
        try {
            FileUtils.copyFile(screenshotFile, new File(name));
            System.out.println("Se sacó la foto correctamente");
        } catch (Exception e) {
            System.out.println("Falló la foto: " + e.getMessage());
        }
        return file;
    }
}