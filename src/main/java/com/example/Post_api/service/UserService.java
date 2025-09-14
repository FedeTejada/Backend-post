package com.example.Post_api.service;

import com.example.Post_api.entity.User;
import com.example.Post_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void createUser(User newUser) {
        if (newUser.getRoles().isEmpty() || newUser.getRoles() == null){
            throw new IllegalArgumentException("User must have at least one Role");
        }
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setEnable(newUser.isEnable());
        user.setAccountNotExpired(newUser.isAccountNotExpired());
        user.setAccountNotLocked(newUser.isAccountNotLocked());
        user.setCredentialNotExpired(newUser.isCredentialNotExpired());
        userRepository.save(user);
    }

    @Override
    public void editUser(Long id, User user) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()){
            throw new IllegalArgumentException("Not found user by id:" + id);
        }
        if (user.getRoles().isEmpty() || user.getRoles() == null){
            throw new IllegalArgumentException("User must have at least one Role");
        }
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setEnable(user.isEnable());
        user1.setAccountNotExpired(user.isAccountNotExpired());
        user1.setAccountNotLocked(user.isAccountNotLocked());
        user1.setCredentialNotExpired(user.isCredentialNotExpired());
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()){
            throw new IllegalArgumentException("Not found user by id:" + id);
        }

        return opt.get();
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()){
            throw new IllegalArgumentException("Not found user by id:" + id);
        }
        userRepository.deleteById(id);
    }
}
