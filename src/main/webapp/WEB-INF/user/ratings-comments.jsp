<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ratings and Comments</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <h1>Ratings and Comments</h1>
</header>

<section>
    <h2>${recipe.title}</h2>
    <p>${recipe.instructions}</p>

    <h3>Submit Your Rating</h3>
    <form action="user" method="post">
        <input type="hidden" name="action" value="rateRecipe">
        <input type="hidden" name="recipeId" value="${recipe.id}">
        <label for="rating">Rating (1-5):</label>
        <input type="number" id="rating" name="rating" min="1" max="5" required>
        <br>
        <label for="comment">Comment:</label>
        <textarea id="comment" name="comment"></textarea>
        <br>
        <button type="submit">Submit</button>
    </form>

    <h3>Reviews</h3>
    <ul>
        <c:forEach var="review" items="${reviews}">
            <li>
                <strong>${review.userName}</strong>: ${review.content} (Rating: ${review.rating})
            </li>
        </c:forEach>
    </ul>
</section>
</body>
</html>