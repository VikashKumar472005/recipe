<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Discover Recipes</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <h1>Discover Recipes</h1>
</header>

<section>
    <h2>Available Recipes</h2>
    <table>
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="recipe" items="${discoverRecipes}">
            <tr>
                <td>${recipe.title}</td>
                <td>${recipe.userName}</td>
                <td>
                    <a href="recipe-details.jsp?id=${recipe.id}">View</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>