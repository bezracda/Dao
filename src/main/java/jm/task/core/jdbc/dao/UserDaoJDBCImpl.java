package jm.task.core.jdbc.dao;
import java.sql.DriverManager;
import com.sun.xml.bind.v2.model.core.ID;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import javax.management.Query;
import java.sql.*;
import java.util.*;
import static org.hibernate.hql.internal.antlr.HqlTokenTypes.WHERE;
import static org.hibernate.sql.ast.Clause.LIMIT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {


    static Connection connect = Util.getConnection();


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        //РАБОТАЕТ
        try {
            Statement  st = connect.createStatement();
            String sqlCommand = "CREATE TABLE users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), lastName VARCHAR(100), age INT)";
            st.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            System.out.println("Такая таблица уже есть!");
        }


    }

    public void dropUsersTable() {
        // РАБОТАЕТ
        try {
            Statement  st = connect.createStatement();
            String sqlCommand = "DROP TABLE IF EXISTS users";
            st.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        //Работает
        try {
            String sqlCommand = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
            PreparedStatement prepar = connect.prepareStatement(sqlCommand);
            prepar.setString(1, name);
            prepar.setString(2, lastName);
            prepar.setByte(3, age);
            prepar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) throws SQLException {
        //Работает
        try {
            String sqlCommand = "DELETE FROM users WHERE id = ?";
            PreparedStatement prepar = connect.prepareStatement(sqlCommand);
            prepar.setLong(1, id);
            prepar.executeUpdate();
        } catch (SQLException e) {
            System.out.println("По данному ID элемент не найден");
        }



    }

    public List<User> getAllUsers() {
        //Работает
        Statement st = null;
        List<User> list;
        try {
            list = new ArrayList<>();
            st = connect.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                String str = rs.getString("name");
                String str1 = rs.getString("lastName");
                byte i = rs.getByte("age");
                User user = new User(str, str1, i);
                list.add(user);

            }
            System.out.println(list);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void cleanUsersTable() {
        //РАБОТАЕТ
        try {
            Statement  st = connect.createStatement();
            String sqlCommand = "DELETE FROM users ";
            st.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            System.out.println("Таблица уже пуста!");
        }

    }
}
