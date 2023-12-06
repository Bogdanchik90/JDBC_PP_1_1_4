package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService us = new UserServiceImpl();

        us.createUsersTable();
        us.saveUser("Ivan","Ivanov", (byte) 23);
        us.saveUser("Andrey","Andreev", (byte) 25);
        us.saveUser("Olga","Ivanova", (byte) 20);
        us.saveUser("Vitya","Petrov", (byte) 43);
        us.getAllUsers();
        us.removeUserById(1);
        us.cleanUsersTable();
        us.dropUsersTable();




        /*UserServiceImpl user = new UserServiceImpl();

        user.createUsersTable();
        user.saveUser("Ivan","Ivanov", (byte) 23);
        user.saveUser("Andrey","Andreev", (byte) 25);
        user.saveUser("Olga","Ivanova", (byte) 20);
        user.saveUser("Vitya","Petrov", (byte) 43);
        user.getAllUsers();
        user.removeUserById(1);
        user.cleanUsersTable();
        user.dropUsersTable();*/
    }
}
