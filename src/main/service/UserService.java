package com.mywebapp.service;

import com.mywebapp.dao.UserDAO;
import com.mywebapp.model.User;

import java.sql.SQLException;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public void registerUser(User user) throws SQLException {
        userDAO.registerUser(user);
    }

    public User getUserByUsername(String username) throws SQLException {
        return userDAO.getUserByUsername(username);
    }
}
