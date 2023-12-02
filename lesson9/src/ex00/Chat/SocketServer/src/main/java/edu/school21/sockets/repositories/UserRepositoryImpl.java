package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryImpl implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jdbcTemplate.query(
                "SELECT FROM users WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(User.class)
                )
                .stream()
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update(
                "INSERT INTO users(username, password) VALUES(?, ?)",
                entity.getUsername(),
                entity.getPassword()
        );
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update(
                "UPDATE users SET username = ?, password = ? WHERE id = ?",
                entity.getUsername(),
                entity.getPassword(),
                entity.getId()
        );
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(
                "DELETE FROM users WHERE id = ?",
                id
        );
    }
}
