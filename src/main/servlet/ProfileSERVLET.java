package com.mywebapp.servlet;

import com.mywebapp.model.User;
import com.mywebapp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        try {
            User user = userService.getUserByUsername(username);
            if (user != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
            } else {
                response.getWriter().println("User not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error fetching user profile.");
        }
    }
}

