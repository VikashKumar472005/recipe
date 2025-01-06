<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Recipes</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <h1>My Recipes</h1>
</header>

<section>
    <h2>Your Recipes</h2>
    <table>
        <thead>
        <tr>
            <th>Title</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="recipe" items="${myRecipes}">
            <tr>
                <td>${recipe.title}</td>
                <td>${recipe.approved ? "Approved" : "Pending Approval"}</td>
                <td>
                    <a href="recipe-details.jsp?id=${recipe.id}">View</a> |
                    <a href="edit-recipe.jsp?id=${recipe.id}">Edit</a> |
                    <form action="user" method="post" style="display: inline;">
                        <input type="hidden" name="action" value="deleteRecipe">
                        <input type="hidden" name="recipeId" value="${recipe.id}">
                        <button type="submit" class="delete-button">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>