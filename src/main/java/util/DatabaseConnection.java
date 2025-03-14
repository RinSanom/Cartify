package util;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Properties properties = new Properties();

    public static Properties getDataCredential() {
        try (FileReader fileReader = new FileReader("app.properties")) {
            properties.load(fileReader);
            System.out.println("Loaded properties: " + properties); // Debug log
        } catch (Exception e) {
            System.out.println("Error loading properties: " + e.getMessage());
        }
        return properties;
    }

    public static Connection getDataConnection() {
        Properties props = getDataCredential();
        String url = props.getProperty("db_url");
        String username = props.getProperty("db_username");
        String password = props.getProperty("db_password");

        System.out.println("Connecting to: " + url); // Debug log
        System.out.println("Username: " + username); // Debug log

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!"); // Debug log
            return connection;
        } catch (SQLException e) {
            System.out.println("Error during database connection: " + e.getMessage());
        }
        return null;
    }
}