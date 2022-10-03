package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.beans.Transient;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl UsDao = new UserDaoJDBCImpl();

    public void createUsersTable() {
        UsDao.createUsersTable();

    }

    public void dropUsersTable() {
        UsDao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        UsDao.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        try {
            UsDao.removeUserById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        return UsDao.getAllUsers();

    }

    public void cleanUsersTable() {
        UsDao.cleanUsersTable();

    }
}
