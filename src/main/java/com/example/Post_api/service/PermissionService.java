package com.example.Post_api.service;

import com.example.Post_api.entity.Permission;
import com.example.Post_api.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService implements IPermissionService {
    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public Permission createPermission(Permission newPermission) {
        if (permissionRepository.existPermissionByName(newPermission.getPermissionName())){
            throw new IllegalArgumentException("Permission already exist");
        }
        Permission permission = new Permission();
        permission.setPermissionName(newPermission.getPermissionName());
        Permission p = permissionRepository.save(permission);
        return p;
    }

    @Override
    public Permission editPermission(Long id, Permission permission) {
        Optional<Permission> opt = permissionRepository.findById(id);
        if (opt.isEmpty()){
            throw new IllegalArgumentException("Not found permission with id: " + id);
        }
        Permission permission1 = opt.get();
        permission1.setPermissionName(permission.getPermissionName());
        return permissionRepository.save(permission1);
    }

    @Override
    public List<Permission> getAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getPermission(Long id) {
        Optional<Permission> opt = permissionRepository.findById(id);
        if (opt.isEmpty()){
            throw new IllegalArgumentException("Not found permission with id: " + id);
        }
        Permission permission = opt.get();
        return permission;
    }

    @Override
    public Permission deletePermission(Long id){
        Optional<Permission> opt = permissionRepository.findById(id);
        if (opt.isEmpty()){
            throw new IllegalArgumentException("Not found permission with id: " + id);
        }
        Permission oldPermission = opt.get();
        permissionRepository.deleteById(id);
        return oldPermission;
    }
}
