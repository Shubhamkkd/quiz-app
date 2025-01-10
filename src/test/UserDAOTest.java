package com.mywebapp.dao;

import com.mywebapp.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        userDAO = new UserDAO();
    }

    @Test
    public void testRegisterUser() throws Exception {
        User user = new User("testuser", "password123", "John", "Doe", "john.doe@example.com");
        userDAO.registerUser(user);
        
        User retrievedUser = userDAO.getUserByUsername("testuser");
        assertNotNull(retrievedUser);
        assertEquals("testuser", retrievedUser.getUsername());
    }

    @Test
    public void testGetUserByUsername() throws Exception {
        User user = userDAO.getUserByUsername("existinguser");
        assertNotNull(user);
        assertEquals("existinguser", user.getUsername());
    }
}
