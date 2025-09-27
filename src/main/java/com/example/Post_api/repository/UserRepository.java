package com.example.Post_api.repository;

import com.example.Post_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User>findUserEntityByUsername(String username);
}
