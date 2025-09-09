package com.example.Post_api.service;

import com.example.Post_api.entity.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService implements IPermissionService {
    @Override
    public void createPermission(Permission newPermission) {

    }

    @Override
    public Permission editPermission(Long id, Permission permission) {
        return null;
    }

    @Override
    public List<Permission> getAllPermission() {
        return List.of();
    }

    @Override
    public Permission getPermission(Long id) {
        return null;
    }

    @Override
    public Permission deletePermission(Long id) {
        return null;
    }
}
