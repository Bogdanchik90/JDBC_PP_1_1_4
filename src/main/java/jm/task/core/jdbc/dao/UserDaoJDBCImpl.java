package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();
    Statement statement;

    private final String create = "CREATE TABLE IF NOT EXISTS `users_`.`new_table` (\n" +
            "  `id` MEDIUMINT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NULL,\n" +
            "  `last_name` VARCHAR(45) NULL,\n" +
            "  `age` TINYINT(3) NULL,\n" +
            "  PRIMARY KEY (`id`))\n" +
            "ENGINE = InnoDB\n" +
            "DEFAULT CHARACTER SET = utf8;";
    private final String query = "SELECT * FROM new_table";
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            statement = util.getConnection().createStatement();
            statement.execute(create);
        } catch (SQLException e) {
            System.out.println("исключение в методе createUsersTable");
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void dropUsersTable() {
        try {
            statement = util.getConnection().createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS new_table");
        } catch (SQLException e) {
            System.out.println("исключение в методе dropUsersTable");
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String str = String.format("INSERT INTO new_table (name, last_name, age) VALUES ('%s','%s',%s)", name, lastName, age);
        try {
            statement = util.getConnection().createStatement();
            statement.executeUpdate(str);
            System.out.println("User с именем – " + name + " добавлен в базу данных ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("исключение в методе saveUser");
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void removeUserById(long id) {
        String str = String.format("DELETE FROM new_table WHERE id = %s", id);
        try {
            statement = util.getConnection().createStatement();
            statement.executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("исключение в методе removeUserById");
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            statement = util.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("исключение в методе getAllUsers");
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return users;
    }

    public void cleanUsersTable() {
        try {
            statement = util.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM new_table");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("исключение в методе cleanUsersTable");
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
