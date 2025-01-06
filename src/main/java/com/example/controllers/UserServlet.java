package com.example.controllers;

import com.example.dao.RecipeDAO;
import com.example.dao.UserDAO;
import com.example.models.Recipe;
import com.example.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;
    private RecipeDAO recipeDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        recipeDAO = new RecipeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "myRecipes":
                int userId = Integer.parseInt(request.getParameter("userId"));
                List<Recipe> userRecipes = recipeDAO.getRecipesByUserId(userId);
                request.setAttribute("recipes", userRecipes);
                request.getRequestDispatcher("/WEB-INF/views/user/my-recipes.jsp").forward(request, response);
                break;

            case "discover":
                List<Recipe> allRecipes = recipeDAO.getAllRecipes();
                request.setAttribute("recipes", allRecipes);
                request.getRequestDispatcher("/WEB-INF/views/user/discover-recipes.jsp").forward(request, response);
                break;

            default:
                response.sendRedirect("user?action=discover");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("shareRecipe".equals(action)) {
            String title = request.getParameter("title");
            String ingredients = request.getParameter("ingredients");
            String instructions = request.getParameter("instructions");
            int userId = Integer.parseInt(request.getParameter("userId"));

            Recipe recipe = new Recipe(title, ingredients, instructions, userId);
            recipeDAO.addRecipe(recipe);
            response.sendRedirect("user?action=myRecipes&userId=" + userId);
        } else if ("updateProfile".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            User user = new User(userId, name, email);
            userDAO.updateUser(user);
            response.sendRedirect("user?action=myRecipes&userId=" + userId);
        }
    }
}