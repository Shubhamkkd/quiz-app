package com.mywebapp.servlet;

import com.mywebapp.model.User;
import com.mywebapp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");

        User user = new User(username, password, firstName, lastName, email);
        try {
            userService.registerUser(user);
            response.sendRedirect("ProfileServlet?username=" + username);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error during registration.");
        }
    }
}
