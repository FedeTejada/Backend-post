package com.example.Post_api.service;

import com.example.Post_api.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Override
    public void createUser(User newUser) {

    }

    @Override
    public void editUser(Long id, User user) {

    }

    @Override
    public List<User> getAllUser() {
        return List.of();
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
