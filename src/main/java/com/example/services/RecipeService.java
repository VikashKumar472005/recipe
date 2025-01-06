package com.example.services;

import com.example.dao.RecipeDAO;
import com.example.models.Recipe;

import java.util.List;

public class RecipeService {
    private RecipeDAO recipeDAO;

    public RecipeService() {
        recipeDAO = new RecipeDAO();
    }

    // Retrieve all recipes
    public List<Recipe> getAllRecipes() {
        return recipeDAO.getAllRecipes();
    }

    // Retrieve recipes by user ID
    public List<Recipe> getRecipesByUserId(int userId) {
        return recipeDAO.getRecipesByUserId(userId);
    }

    // Add a new recipe
    public void addRecipe(String title, String ingredients, String instructions, int userId) {
        Recipe recipe = new Recipe(title, ingredients, instructions, userId);
        recipeDAO.addRecipe(recipe);
    }

    // Approve a recipe
    public void approveRecipe(int recipeId) {
        recipeDAO.approveRecipe(recipeId);
    }

    // Delete a recipe
    public void deleteRecipe(int recipeId) {
        recipeDAO.deleteRecipe(recipeId);
    }
}