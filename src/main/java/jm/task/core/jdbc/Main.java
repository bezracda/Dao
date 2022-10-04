package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserDaoHibernateImpl user = new UserDaoHibernateImpl();
        user.createUsersTable();
        user.saveUser("Вася", "Петров", (byte) 9);
        user.saveUser("Вася", "Петров", (byte) 77);
        user.saveUser("Вася", "Петров", (byte) 59);
        user.removeUserById(1L);
        user.cleanUsersTable();
        user.dropUsersTable();
        user.getAllUsers();


//        Util.getConnection();
//        UserDao userDao = new UserDaoJDBCImpl();
//
//
        //    userDao.createUsersTable();
//        userDao.saveUser("Name1", "LastName1", (byte) 20);
//        userDao.saveUser("Name2", "LastName2", (byte) 25);
//        userDao.saveUser("Name3", "LastName3", (byte) 31);
//        userDao.saveUser("Name4", "LastName4", (byte) 38);
//        userDao.removeUserById(2);
//        userDao.getAllUsers();
//        userDao.cleanUsersTable();
    }
}
