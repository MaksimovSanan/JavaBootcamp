package edu.school21.repositories;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepositoryImpl implements UsersRepository{

    private final DataSource dataSource;

    public UsersRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User findByLogin(String login) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE login = ?");
            stmt.setString(1, login);
            ResultSet resultSet = stmt.executeQuery();
            if(!resultSet.next()) {
                throw new AlreadyAuthenticatedException("User not found");
            }
            return new User(
                    resultSet.getLong("identifier"),
                    resultSet.getString("login"),
                    resultSet.getString("password")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement
                    ("UPDATE users SET login = ?, password = ?, status = ? WHERE identifier = ?");

            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setBoolean(3, user.getAuthenticationSuccessStatus());
            stmt.setLong(4, user.getIdentifier());
            int rowsUpdated = stmt.executeUpdate();
            if(rowsUpdated == 0) {
                throw new AlreadyAuthenticatedException("User not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
