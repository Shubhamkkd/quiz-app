package com.mywebapp.service;

import com.mywebapp.dao.UserDAO;
import com.mywebapp.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;
    private UserDAO userDAOMock;

    @BeforeEach
    public void setUp() {
        userDAOMock = mock(UserDAO.class);
        userService = new UserService();
    }

    @Test
    public void testRegisterUser() throws Exception {
        User user = new User("testuser", "password123", "John", "Doe", "john.doe@example.com");

        doNothing().when(userDAOMock).registerUser(user);

        userService.registerUser(user);
        
        verify(userDAOMock).registerUser(user);
    }

    @Test
    public void testGetUserByUsername() throws Exception {
        User user = new User("existinguser", "password123", "Jane", "Doe", "jane.doe@example.com");
        when(userDAOMock.getUserByUsername("existinguser")).thenReturn(user);

        User retrievedUser = userService.getUserByUsername("existinguser");
        
        assertNotNull(retrievedUser);
        assertEquals("existinguser", retrievedUser.getUsername());
    }
}
