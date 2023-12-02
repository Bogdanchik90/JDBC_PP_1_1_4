package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final String URL = "jdbc:mysql://localhost:3306/users_";
    private final String USER = "root";
    private final String PASSWORD = "Balonka123,";
    Connection connection;

    public Util() {
        try  {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            System.out.println("исключение connection");
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

}
