package com.example.Post_api.service;

import com.example.Post_api.entity.Role;
import com.example.Post_api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role createRole(Role newRole) {
        if (newRole.getPermissions() == null || newRole.getPermissions().isEmpty()) {
            throw new IllegalArgumentException("Role must have at least one permission");
        }
        Role role = new Role();
        role.setNameRole(newRole.getNameRole());
        role.setPermissions(newRole.getPermissions());
        roleRepository.save(role);
        return role;
    }

    @Override
    public Role editRole(Long id, Role role) {
        Optional<Role> opt =  roleRepository.findById(id);
        if (opt.isEmpty()){
            throw new IllegalArgumentException("Role with id: " + id + "not found");
        }
        Role role1 = opt.get();
        role1.setNameRole(role.getNameRole());
        role1.setPermissions(role.getPermissions());
        roleRepository.save(role1);
        return role1;
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(Long id) {
        Optional<Role> opt =  roleRepository.findById(id);
        if (opt.isEmpty()){
            throw new IllegalArgumentException("Role with id: " + id + "not found");
        }
        return opt.get();
    }

    @Override
    public Role deleteRole(Long id) {
        Optional<Role> opt =  roleRepository.findById(id);
        if (opt.isEmpty()){
            throw new IllegalArgumentException("Role with id: " + id + "not found");
        }
        Role oldRole = opt.get();
        roleRepository.deleteById(id);
        return oldRole;
    }
}
