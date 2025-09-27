package com.example.Post_api.models;

import com.example.Post_api.entity.Role;

import java.util.Set;

public record UserDTO(Long id,
                      String username,
                      String password,
                      Boolean enable,
                      Boolean accountNotExpired,
                      Boolean accountNotLocked,
                      Boolean credentialNotExpired,
                      Set<Role> roles) {
}
