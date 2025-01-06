<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recipe Management</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Recipe Management</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Approved</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="recipe" items="${recipes}">
        <tr>
            <td>${recipe.id}</td>
            <td>${recipe.title}</td>
            <td>${recipe.userId}</td>
            <td>${recipe.approved ? "Yes" : "No"}</td>
            <td>
                <form action="admin" method="post" style="display: inline;">
                    <input type="hidden" name="action" value="approveRecipe">
                    <input type="hidden" name="recipeId" value="${recipe.id}">
                    <button type="submit">Approve</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>