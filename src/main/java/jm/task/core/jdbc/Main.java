package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl user = new UserServiceImpl();

        user.createUsersTable();
        user.saveUser("Ivan","Ivanov", (byte) 23);
        user.saveUser("Andrey","Andreev", (byte) 25);
        user.saveUser("Olga","Ivanova", (byte) 20);
        user.saveUser("Vitya","Petrov", (byte) 43);
        user.getAllUsers();
        user.removeUserById(1);
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
