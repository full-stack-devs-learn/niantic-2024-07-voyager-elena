package com.niantic.services;

import com.niantic.models.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/budget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource() {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();

        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while (row.next()) {
            users.add(new User(
                    row.getInt("user_id"),
                    row.getString("user_name"),
                    row.getString("first_name"),
                    row.getString("last_name"),
                    row.getString("phone"),
                    row.getString("email")
            ));
        }

        return users;
    }

    public User getUserById(int userId) {
        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users
                WHERE user_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, userId);

        if (row.next()) {
            return new User(
                    row.getInt("user_id"),
                    row.getString("user_name"),
                    row.getString("first_name"),
                    row.getString("last_name"),
                    row.getString("phone"),
                    row.getString("email")
            );
        }

        return null;
    }

    public ArrayList<User> getUsersByName(String userName) {
        ArrayList<User> users = new ArrayList<>();

        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users
                WHERE user_name = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userName);

        while (row.next()) {
            users.add(new User(
                    row.getInt("user_id"),
                    row.getString("user_name"),
                    row.getString("first_name"),
                    row.getString("last_name"),
                    row.getString("phone"),
                    row.getString("email")
            ));
        }

        return users;
    }

    public User getUserByName(String userName) {
        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users
                WHERE user_name = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userName);

        if (row.next()) {
            return new User(
                    row.getInt("user_id"),
                    row.getString("user_name"),
                    row.getString("first_name"),
                    row.getString("last_name"),
                    row.getString("phone"),
                    row.getString("email")
            );
        }

        return null;
    }

    public void addUser(User user) {
        String sql = """
                INSERT INTO users (
                    user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                    )
                VALUES (?,?,?,?,?);
                """;

        jdbcTemplate.update(sql,
                user.getUserName(),
                user.getFirstName(),
                user.getLastname(),
                user.getPhone(),
                user.getEmail()
        );
    }

    public void updateUser(User user) {
        String sql = """
                UPDATE users
                SET user_name = ?
                    , first_name = ?
                    , last_name = ?
                    , phone = ?
                    , email = ?
                WHERE user_id = ?;
                """;

        jdbcTemplate.update(sql,
                user.getUserName(),
                user.getFirstName(),
                user.getLastname(),
                user.getPhone(),
                user.getEmail()
        );
    }

    public void deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?;";

        jdbcTemplate.update(sql, userId);
    }

}
