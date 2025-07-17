package DriverManager;

import java.io.IOException;
import java.io.InputStream;
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
}