package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class Util {
    // реализуйте настройку соеденения с БД
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL,"jdbc:mysql://localhost:3306/users_?useSSL=false");
                settings.put(Environment.USER,"root");
                settings.put(Environment.PASS,"Balonka123,");
                settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL,"true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

                settings.put(Environment.HBM2DDL_AUTO,"create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("соединение не установлено");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }










    /*private final String URL = "jdbc:mysql://localhost:3306/users_";
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
    }*/

}
