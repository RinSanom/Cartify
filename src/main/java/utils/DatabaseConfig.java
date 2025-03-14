package utils;

import java.io.FileReader;
import java.util.Properties;

public class DatabaseConfig {
    private static Properties properties = new Properties();
    public static Properties getProperties() {
        try(FileReader fileReader = new FileReader("app.properties")){
            properties.load(fileReader);
        }catch (Exception exception){
            System.out.println("[!] Error during get data connection : " + exception.getMessage());
        }
        return properties;
    }
}
