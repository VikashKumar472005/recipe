package com.example.models;

public class Recipe {
    private int id;
    private String title;
    private String ingredients;
    private String instructions;
    private int userId;
    private boolean approved;

    // Constructor
    public Recipe(String title, String ingredients, String instructions, int userId) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.userId = userId;
        this.approved = false; // Default value
    }

    // Overloaded Constructor with ID for database retrieval
    public Recipe(int id, String title, String ingredients, String instructions, int userId) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.userId = userId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}