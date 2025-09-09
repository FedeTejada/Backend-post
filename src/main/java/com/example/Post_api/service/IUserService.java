package com.example.Post_api.service;

import com.example.Post_api.entity.User;

import java.util.List;

public interface IUserService {
    public void createUser(User newUser);
    public void editUser(Long id, User user);
    public List<User> getAllUser();
    public User getUser(Long id);
    public void deleteUser(Long id);
}
