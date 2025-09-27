package com.example.Post_api.models;

import com.example.Post_api.entity.Permission;

import java.util.Set;

public record RoleDTO(Long id,
                      String roleName,
                      Set<Permission> permissions) {
}
