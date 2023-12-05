package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService us = new UserServiceImpl();


       // us.dropUsersTable();

        //us.createUsersTable();

        /*us.saveUser("bogdan","bulgakov",(byte)27);
        us.saveUser("andrey","smolyaninov",(byte)24);
        us.saveUser("liza","bulgakova",(byte)25);
        us.saveUser("max","myagkov",(byte)33);*/

        //us.removeUserById(2);

        //us.cleanUsersTable();
        //us.getAllUsers();






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
