<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recipe Statistics</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Recipe Statistics</h1>
<!-- Placeholder for graphs and charts -->
<div>
    <h3>Submission Trends</h3>
    <img src="submission-trends.png" alt="Submission Trends">
</div>
<div>
    <h3>Top Rated Recipes</h3>
    <table border="1">
        <thead>
        <tr>
            <th>Title</th>
            <th>Rating</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="recipe" items="${topRatedRecipes}">
            <tr>
                <td>${recipe.title}</td>
                <td>${recipe.rating}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>