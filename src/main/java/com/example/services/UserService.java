package com.example.services;

import com.example.dao.UserDAO;
import com.example.models.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    // Retrieve all users
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // Retrieve user by ID
    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    // Create a new user
    public void createUser(String name, String email, String password, String role) {
        User user = new User(name, email, password, role);
        userDAO.createUser(user);
    }

    // Update an existing user
    public void updateUser(int id, String name, String email) {
        User user = new User(id, name, email);
        userDAO.updateUser(user);
    }

    // Delete a user
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}