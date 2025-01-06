package com.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import com.model.User;

public class UserDAOTest {
    @Test
    public void testRegisterUser() throws Exception {
        User user = new User("testUser", "password123", "test@domain.com");
        UserDAO userDAO = new UserDAO();
        boolean isRegistered = userDAO.registerUser(user);
        assertTrue(isRegistered);
    }

    @Test
    public void testGetUserById() throws Exception {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(1);  // Assuming user with ID 1 exists
        assertNotNull(user);
        assertEquals("testUser", user.getUsername());
    }
}
