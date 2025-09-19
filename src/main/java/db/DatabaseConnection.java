package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection databaseConnection;
    private Connection connection;

    private DatabaseConnection(){
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_ICET","root","1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static DatabaseConnection getInstance(){
        if (databaseConnection==null){
            databaseConnection=new DatabaseConnection();
        }
        return databaseConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
