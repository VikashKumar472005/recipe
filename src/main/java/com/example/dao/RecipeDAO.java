package com.example.dao;

import com.example.models.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {
    private Connection connection;

    public RecipeDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe_app", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM recipes");
            while (rs.next()) {
                recipes.add(new Recipe(rs.getInt("id"), rs.getString("title"), rs.getString("ingredients"), rs.getString("instructions"), rs.getInt("user_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    public List<Recipe> getRecipesByUserId(int userId) {
        List<Recipe> recipes = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM recipes WHERE user_id = ?")) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                recipes.add(new Recipe(rs.getInt("id"), rs.getString("title"), rs.getString("ingredients"), rs.getString("instructions"), rs.getInt("user_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO recipes (title, ingredients, instructions, user_id) VALUES (?, ?, ?, ?)")) {
            pstmt.setString(1, recipe.getTitle());
            pstmt.setString(2, recipe.getIngredients());
            pstmt.setString(3, recipe.getInstructions());
            pstmt.setInt(4, recipe.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void approveRecipe(int recipeId) {
        try (PreparedStatement pstmt = connection.prepareStatement("UPDATE recipes SET approved = 1 WHERE id = ?")) {
            pstmt.setInt(1, recipeId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}