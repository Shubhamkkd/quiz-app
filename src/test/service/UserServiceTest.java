package com.quiz.service;

import com.quiz.dao.UserDAO;
import com.quiz.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;
    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        // Mock the UserDAO
        userDAO = Mockito.mock(UserDAO.class);
        userService = new UserService(userDAO); // Inject mock DAO into service
    }

    // Test for user registration logic
    @Test
    public void testRegisterUser() {
        User user = new User("newuser", "password123", "newuser@example.com");
        
        try {
            // Simulate the DAO method call
            Mockito.doNothing().when(userDAO).saveUser(user);

            // Call the service method
            userService.registerUser(user);

            // Verify that saveUser was called in the DAO
            Mockito.verify(userDAO).saveUser(user);
        } catch (Exception e) {
            fail("Exception should not be thrown during registration");
        }
    }

    // Test for user login logic (simple check)
    @Test
    public void testLoginUser() {
        String username = "existinguser";
        String password = "password123";
        User user = new User(username, password, "existinguser@example.com");

        try {
            // Simulate DAO returning a user on login
            Mockito.when(userDAO.getUserByUsername(username)).thenReturn(user);

            // Simulate a successful login
            User loggedInUser = userService.loginUser(username, password);
            assertNotNull(loggedInUser);
            assertEquals(username, loggedInUser.getUsername());
        } catch (Exception e) {
            fail("Exception should not be thrown during login");
        }
    }

    // Test for login failure (wrong password)
    @Test
    public void testLoginUserFailure() {
        String username = "existinguser";
        String password = "wrongpassword";
        
        try {
            Mockito.when(userDAO.getUserByUsername(username)).thenReturn(new User(username, "password123", "existinguser@example.com"));

            User loggedInUser = userService.loginUser(username, password);
            assertNull(loggedInUser); // Login should fail with wrong password
        } catch (Exception e) {
            fail("Exception should not be thrown during login failure");
        }
    }
}
