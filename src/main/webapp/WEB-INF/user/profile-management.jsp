<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile Management</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <h1>Manage Your Profile</h1>
</header>

<section>
    <form action="user" method="post">
        <input type="hidden" name="action" value="updateProfile">
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}" required>
        <br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required>
        <br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <br>

        <button type="submit">Update Profile</button>
    </form>
</section>
</body>
</html>