package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory;
    public UserDaoHibernateImpl(Util util) {
        this.sessionFactory = util.getSessionFactory();
    }


    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String str = "CREATE TABLE IF NOT EXISTS `users_`.`new_table` (\n" +
                "  `id` BIGINT(5) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `last_name` VARCHAR(45) NULL,\n" +
                "  `age` TINYINT(3) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;";
        Query query = session.createSQLQuery(str).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXISTS new_table";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = sessionFactory.openSession()) {
            session.save(new User(name,lastName,age));
            System.out.printf("User с именем %s добавлен в таблицу\n",name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.openSession()){
            User userDel = session.find(User.class,id);
            Transaction transaction = session.beginTransaction();
            if (userDel != null) {
                session.remove(userDel);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> us = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM" + User.class.getSimpleName(), User.class);
            us = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()){
            session.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
