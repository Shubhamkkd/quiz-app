<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Application - Home</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 800px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Welcome to the Quiz Application!</h2>
        
        <!-- Displaying any messages if set in the session (success/error messages) -->
        <c:if test="${not empty sessionScope.successMessage}">
            <div class="alert alert-success">
                ${sessionScope.successMessage}
            </div>
        </c:if>
        <c:if test="${not empty sessionScope.errorMessage}">
            <div class="alert alert-danger">
                ${sessionScope.errorMessage}
            </div>
        </c:if>

        <!-- Navigation links for login and registration -->
        <div class="text-center mt-5">
            <h3>What would you like to do?</h3>
            <div class="btn-group-vertical">
                <a href="login.jsp" class="btn btn-primary btn-lg">Login</a>
                <a href="register.jsp" class="btn btn-success btn-lg">Register</a>
                <a href="quizzes.jsp" class="btn btn-info btn-lg">View Quizzes</a>
            </div>
        </div>
        
        <!-- If a user is logged in, display a greeting and profile link -->
        <c:if test="${not empty sessionScope.username}">
            <div class="text-center mt-5">
                <h4>Welcome back, ${sessionScope.username}!</h4>
                <a href="profile.jsp" class="btn btn-warning btn-lg">Go to Profile</a>
            </div>
        </c:if>
    </div>

    <!-- Bootstrap JS and Popper.js (for Bootstrap components like modals) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
