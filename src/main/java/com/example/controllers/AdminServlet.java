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

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
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
            case "listUsers":
                List<User> users = userDAO.getAllUsers();
                request.setAttribute("users", users);
                request.getRequestDispatcher("/WEB-INF/views/admin/user-management.jsp").forward(request, response);
                break;

            case "listRecipes":
                List<Recipe> recipes = recipeDAO.getAllRecipes();
                request.setAttribute("recipes", recipes);
                request.getRequestDispatcher("/WEB-INF/views/admin/recipe-management.jsp").forward(request, response);
                break;

            default:
                response.sendRedirect("admin?action=listUsers");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("deleteUser".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            userDAO.deleteUser(userId);
            response.sendRedirect("admin?action=listUsers");
        } else if ("approveRecipe".equals(action)) {
            int recipeId = Integer.parseInt(request.getParameter("recipeId"));
            recipeDAO.approveRecipe(recipeId);
            response.sendRedirect("admin?action=listRecipes");
        }
    }
}