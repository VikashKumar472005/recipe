<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Recipe Share</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<!-- Main Content -->
<div id="main-content">
    <section class="intro">
        <h1>Welcome to Recipe Share</h1>
        <p>Share your best recipes with the world and discover exciting dishes from others!</p>
        <a href="discover-recipes.jsp" class="btn-primary">Discover Recipes</a>
    </section>

    <section class="features">
        <div class="feature">
            <h3>Discover Recipes</h3>
            <p>Find and try out recipes shared by our vast user base.</p>
        </div>
        <div class="feature">
            <h3>Manage Your Recipes</h3>
            <p>Track the recipes you’ve created and shared in one place.</p>
        </div>
        <div class="feature">
            <h3>Connect with the Community</h3>
            <p>Rate, comment on, and recommend recipes to others.</p>
        </div>
    </section>

    <section class="cta">
        <h2>Get Started Now!</h2>
        <a href="register.jsp" class="btn-primary">Sign Up</a>
    </section>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>