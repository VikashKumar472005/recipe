<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>System Settings</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>System Settings</h1>
<form action="admin" method="post">
    <label for="setting1">Setting 1:</label>
    <input type="text" id="setting1" name="setting1" value="Existing value">
    <br><br>
    <label for="setting2">Setting 2:</label>
    <input type="text" id="setting2" name="setting2" value="Existing value">
    <br><br>
    <button type="submit">Save Settings</button>
</form>
</body>
</html>