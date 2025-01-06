<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Activity Monitoring</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>User Activity Monitoring</h1>
<table border="1">
    <thead>
    <tr>
        <th>Activity ID</th>
        <th>User</th>
        <th>Action</th>
        <th>Timestamp</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="activity" items="${activities}">
        <tr>
            <td>${activity.id}</td>
            <td>${activity.userName}</td>
            <td>${activity.action}</td>
            <td>${activity.timestamp}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>