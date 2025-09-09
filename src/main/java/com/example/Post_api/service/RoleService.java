package com.example.Post_api.service;

import com.example.Post_api.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService{
    @Override
    public Role createRole(Role newRole) {

        return null;
    }

    @Override
    public Role editRole(Long id, Role role) {
        return null;
    }

    @Override
    public List<Role> getAllRole() {
        return List.of();
    }

    @Override
    public Role getRole(Long id) {
        return null;
    }

    @Override
    public Role deleteRole(Long id) {
        return null;
    }
}
