import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Daniel Solo on 17.08.2016.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        loadDriver();
        LOGGER.info("Connecting to restaurant database.");
        String URL = "jdbc:postgresql://localhost:5432/Restaurant";
        String user = "Daniel";
        String password = "130392";
        try {
            Connection connection = DriverManager.getConnection(URL,user,password);
            LOGGER.info("Successfully connected to database.");
        } catch (SQLException e) {
            LOGGER.error("Failed to connect");
        }
    }

    private static void loadDriver() {
        try {
            LOGGER.info("Loading JDBC Driver: org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Driver was successfully loaded.");
        } catch (ClassNotFoundException e) {
           LOGGER.error("CANNOT FIND DRIVER: org.postgresql.Driver");
            throw new RuntimeException(e);
        }
    }
}
