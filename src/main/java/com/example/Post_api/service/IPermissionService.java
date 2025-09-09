package com.example.Post_api.service;

import com.example.Post_api.entity.Permission;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

import java.util.List;

public interface IPermissionService {
    public void createPermission(Permission newPermission);
    public Permission editPermission(Long id, Permission permission);
    public List<Permission> getAllPermission();
    public Permission getPermission(Long id);
    public Permission deletePermission(Long id);
}
