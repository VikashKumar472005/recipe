<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recipe History</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <h1>Your Recipe History</h1>
</header>

<section>
    <h2>Recently Interacted Recipes</h2>
    <table>
        <thead>
        <tr>
            <th>Title</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="history" items="${recipeHistory}">
            <tr>
                <td>${history.title}</td>
                <td>${history.lastAccessed}</td>
                <td>
                    <a href="recipe-details.jsp?id=${history.id}">View</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>