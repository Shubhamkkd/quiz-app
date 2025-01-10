package com.quiz.dao;

import com.quiz.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

public class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        userDAO = new UserDAO();
    }

    @Test
    public void testSaveUser() throws SQLException {
        User user = new User("testuser", "password123", "testuser@example.com");
        userDAO.saveUser(user);
        
        User fetchedUser = userDAO.getUserByUsername("testuser");
        assertNotNull(fetchedUser);
        assertEquals("testuser", fetchedUser.getUsername());
    }

    @Test
    public void testGetUserByUsername() throws SQLException {
        User user = new User("john_doe", "password", "john@example.com");
        userDAO.saveUser(user);

        User fetchedUser = userDAO.getUserByUsername("john_doe");
        assertNotNull(fetchedUser);
        assertEquals("john_doe", fetchedUser.getUsername());
    }
}
