package com.example.Post_api.service;

import com.example.Post_api.entity.Role;

import java.util.List;

public interface IRoleService {
    public Role createRole(Role newRole);
    public Role editRole(Long id, Role role);
    public List<Role> getAllRole();
    public Role getRole(Long id);
    public Role deleteRole(Long id);
}
