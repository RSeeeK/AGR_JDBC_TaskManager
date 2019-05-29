package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    //private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "sa";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            //Class.forName(DB_DRIVER);
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection - OK");
        } catch (SQLException ex) {
            System.out.println("Connection - ERROR");
            ex.printStackTrace();
        }
        return connection;
    }

}
