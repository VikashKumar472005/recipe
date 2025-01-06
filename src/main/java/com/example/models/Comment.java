package com.example.models;

public class Comment {
    private int id;
    private String content;
    private int userId;
    private int recipeId;

    // Constructor
    public Comment(String content, int userId, int recipeId) {
        this.content = content;
        this.userId = userId;
        this.recipeId = recipeId;
    }

    // Overloaded Constructor with ID for database retrieval
    public Comment(int id, String content, int userId, int recipeId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.recipeId = recipeId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}