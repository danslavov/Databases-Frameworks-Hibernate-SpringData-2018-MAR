package T06_DBApps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyDriver {

    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/%s?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";


    public static Connection getConnection(String database) throws SQLException {
        String finalConnectionString = String.format(CONNECTION_STRING, database);
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        return DriverManager.getConnection(finalConnectionString, props);
    }
}