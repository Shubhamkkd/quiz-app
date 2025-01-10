package com.quiz.dao;

import com.quiz.model.User;

import java.sql.*;

public class UserDAO {

    private Connection connection;

    public UserDAO() {
        connection = DatabaseUtil.getConnection();
    }

    public void saveUser(User user) throws SQLException {
        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
        }
    }

    public User getUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("user_id"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("first_name"), rs.getString("last_name"));
            }
        }
        return null;
    }
}
