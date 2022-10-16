package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Util util = new Util();
        String query = "CREATE TABLE  IF NOT EXISTS users (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(query)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        Util util = new Util();
        String query = "DROP TABLE IF EXISTS users";
        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util util = new Util();
        System.out.println("User с именем – " + name + " добавлен в базу данных");
        String query = "INSERT INTO users (name, lastName, age) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        Util util = new Util();
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        Util util = new Util();
        String query = "select * from users";
        try (Statement statement = util.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<User> list = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
                System.out.println(user);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        Util util = new Util();
        String query = "DELETE FROM users";
        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
